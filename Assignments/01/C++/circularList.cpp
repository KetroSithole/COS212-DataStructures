//Provide the implementation for the CircularList class in this file.
#include "circularList.h"


//Constructor
template <class T>
CircularList<T>::CircularList() {
    tail = nullptr;
}


//Copy Constructor
template <class T>
CircularList<T>::CircularList(const CircularList<T> &other) {
    tail = nullptr;
    if (other.tail != nullptr) {
        Node<T> *currPtr = other.tail->next;
        int count = 0;
        do {
            insert(count++, currPtr->element);
            currPtr = currPtr->next;
        }
        while (currPtr != other.tail->next);
    }
}


//Overload assignment operator
template <class T>
CircularList<T> &CircularList<T>::operator=(const CircularList<T> &other) {
    if (this != &other) {
        this->clear();
        Node<T> *currPtr = other.tail->next;
        int count = 0;
        do {
            insert(count++, currPtr->element);
            currPtr = currPtr->next;
        }
        while (currPtr != other.tail->next);
    }
    return *this;
}


//Clone
template <class T>
CircularList<T> &CircularList<T>::clone() {
    CircularList<T> *cloned_list = new CircularList<T>(*this);
    return *cloned_list;
}


//Destructor
template <class T>
CircularList<T>::~CircularList() {
    clear();
}


//Insert
template <class T>
void CircularList<T>::insert(int index, T element) {
    if (index < 0 || index > size())
        throw RemoveException("invalid index");
    else {
        Node<T> *newNode = new Node<T>(element);
        if (tail == nullptr) {
            tail = newNode;
            newNode->next = tail;
        }
        else if (index == 0) {
            newNode->next = tail->next;
            tail->next = newNode;
        }
        else if (index == size()) {
            newNode->next = tail->next;
            tail->next = newNode;
            tail = newNode;
        }
        else {
            Node<T> *currPtr = tail->next, *previousPtr = nullptr;
            for (int count=0;   count<index;    count++, currPtr = currPtr->next)
                previousPtr = currPtr;
            newNode->next = currPtr;
            previousPtr->next = newNode;
        }
    }
}


//Remove
template <class T>
T CircularList<T>::remove(int index) {
    if (index < 0 || index > size() || tail == nullptr)
        throw RemoveException("empty structure");
    else {
        Node<T> *currPtr = tail->next, *previousPtr = nullptr, *temp = nullptr, *tailPtr = tail;
        T data_item;
        if (tail->next == tail) {
            data_item = tail->element;
            delete tail;
            tail = nullptr;
        }
        else if (index == 0) {
            data_item = currPtr->element;
            tail->next = currPtr->next;
            delete currPtr;
        }
        else {
            for (int count=0;   count<index;    count++, currPtr = currPtr->next )
                previousPtr = currPtr;

            if (index == size()-1) {
                data_item = tail->element;
                previousPtr->next = currPtr->next;
                tail = nullptr;
                delete currPtr;
                tail = previousPtr;
            }

            else {
                data_item = currPtr->element;
                previousPtr->next = currPtr->next;
                delete currPtr;
            }
        }
        return data_item;
    }
}


//Empty
template <class T>
bool CircularList<T>::isEmpty() {
    return (tail == nullptr);
}


//Clear
template <class T>
void CircularList<T>::clear() {
    if (tail) {
        Node<T> *currPtr = tail->next;
        while (currPtr != tail) {
            Node<T> *previousPtr = currPtr;
            currPtr = currPtr->next;
            delete previousPtr;
        }
        delete tail;
        tail = nullptr;
    }
}



//Head Getter
template <class T>
Node<T> *CircularList<T>::getLeader() {
    return tail;
}


//Size Getter
template <class T>
int CircularList<T>::size() {
    int size =0;
    if (tail) {
        Node<T> *currPtr = tail->next;
        do {
            currPtr = currPtr->next;
            size++;
        }
        while (currPtr != tail->next);
    }
    return size;
}


//Print
template <class T>
ostream &CircularList<T>::print(ostream& os) {
    os << "[";
    if (tail) {
        Node<T> *currPtr = tail->next;
        do {
            if (currPtr->next == tail->next)
                os << currPtr->element;
            else
                os << currPtr->element << ",";
            currPtr = currPtr->next;
        }
        while (currPtr != tail->next);
    }
    os << "]";
    return os;
}




//Extraction Operator Overload
template <class T>
ostream &operator<<(ostream &os, CircularList<T> &obj) {
    obj.print(os);
    return os;
}

