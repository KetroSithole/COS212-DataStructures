#include "linkedList.h"


//Constructor
template <class T>
LinkedList<T>::LinkedList() {
    head = nullptr;
}


//Clone
template <class T>
LinkedList<T> &LinkedList<T>::clone() {
    LinkedList<T> *cloned_list = new LinkedList<T>(*this);
    return *cloned_list;
}


//Copy Constructor
template <class T>
LinkedList<T>::LinkedList(const LinkedList<T> &other) {
    head = nullptr;
    int count = 0;
    for (Node<T> *currPtr = other.head;     currPtr != nullptr;     currPtr = currPtr->next)
        insert(count++, currPtr->element);
}


//Overload assignment operator
template <class T>
LinkedList<T> &LinkedList<T>::operator=(const LinkedList<T> &other){
    if (this != &other) {
        this->clear();
        int count = 0;
        for (Node<T> *currPtr = other.head;     currPtr != nullptr;     currPtr = currPtr->next)
            insert(count++, currPtr->element);
    }
    return *this;
}


//Destructor
template <class T>
LinkedList<T>::~LinkedList() {
    clear();
}


//Insert
template <class T>
void LinkedList<T>::insert(int index, T element) {
    if (index < 0 || index > size())
        throw RemoveException("invalid index");
    else {
        Node<T> *newNode = new Node<T>(element), *currPtr = head, *previousPtr = nullptr;
        if (!head)
            head = newNode;
        else if (index == 0){
            newNode->next = head;
            head = newNode;
        }
        else {
            for (int count=0;   count<index;    count++, currPtr = currPtr->next)
                previousPtr = currPtr;
            previousPtr->next = newNode;
            newNode->next = currPtr;
        }
    }
}


//Remove
template <class T>
T LinkedList<T>::remove(int index) {
    if (index < 0 || index >= size() || head == nullptr)
        throw RemoveException("empty structure");
    else {
        Node<T> *headPtr = head, *currPtr = head, *previousPtr = nullptr;
        T data_item;
        if (index == 0) {
            data_item = head->element;
            head = head->next;
            delete headPtr;
        }
        else {
            for (int count=0;   count<index;    count++, currPtr=currPtr->next)
                previousPtr = currPtr;

            previousPtr->next = currPtr->next;
            data_item = currPtr->element;
            delete currPtr;
        }
        return data_item;
    }
}


//Empty
template <class T>
bool LinkedList<T>::isEmpty() {
    return (head == nullptr);
}


// Clear()
template <class T>
void LinkedList<T>::clear() {
    for ( Node<T> *currPtr = head, *nextNode = nullptr;     currPtr != nullptr;     currPtr = nextNode){
        nextNode = currPtr->next;
        delete currPtr;
    }
    head = nullptr;
}


// Return head
template <class T>
Node<T> *LinkedList<T>::getLeader() {
    return head;
}


// Return size
template <class T>
int LinkedList<T>::size() {
    int size = 0;
    for (Node<T> *nodePtr = head;   nodePtr != nullptr;     nodePtr = nodePtr->next)
        size++;
    return size;
}


// Overloaded Print
template <class T>
ostream &LinkedList<T>::print(ostream& os) {
    os << "[";
    for (Node<T> *nodePtr = head;   nodePtr != nullptr;     nodePtr = nodePtr->next) {
        if (nodePtr->next == nullptr)
            os << nodePtr->element;
        else
            os << nodePtr->element << ",";
    }
    os << "]";
    return os;
}


//Extraction Operator Overload
template <class T>
ostream &operator<<(ostream &os, LinkedList<T> &obj) {
    obj.print(os);
    return os;
}

