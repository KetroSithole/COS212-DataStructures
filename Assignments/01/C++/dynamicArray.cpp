//Provide the implementation for the DynamicArray class in this file.
#include "dynamicArray.h"


//Constructor
template <class T>
DynamicArray<T>::DynamicArray(int s) {
    if (s <= 0)
        throw RemoveException("Invalid size provided");
    else {
        size = s;
        elements = new T*[size];
        for (int count=0;   count<size;     count++)
            elements[count] = nullptr;
        numElements = 0;
    }
}


//Copy constructor
template <class T>
DynamicArray<T>::DynamicArray(const DynamicArray<T> &other) {
    size = other.size;
    numElements = other.numElements;
    if (this->size != 0) {
        elements = new T*[size];
        for (int count=0;   count<size;     count++)
            elements[count] = (other.elements[count] != nullptr) ? (new T (*(other.elements[count]))) : nullptr;
    }
}


//Clone
template <class T>
DynamicArray<T> &DynamicArray<T>::clone() {
    DynamicArray<T> *cloned_array = new DynamicArray<T>(*this);
    return *cloned_array;
}


//Overload assignment operator
template <class T>
DynamicArray<T> &DynamicArray<T>::operator=(const DynamicArray<T> &other) {
    if (this != &other) {
        this->clear();
        delete [] elements;

        size = other.size;
        numElements = other.numElements;

        if (this->size != 0) {
            elements = new T*[size];
            for (int count=0;   count<size;     count++)
                elements[count] = (other.elements[count] != nullptr) ? (new T (*(other.elements[count]))) : nullptr;
        }
    }
    return *this;
}


//Destructor
template <class T>
DynamicArray<T>::~DynamicArray() {
    clear();
    delete [] elements;
}



//Insert
template<class T>
void DynamicArray<T>::insert(int index, T element) {
    DynamicArray<T> oldElements(*this);
    int oldSize = size;

    if (index < size && elements[index] == nullptr)
        elements[index] = new T(element);
    else {
        if (index < size && elements[size-1] != nullptr) {
            for (int count=0;   count<size;     count++)
                delete elements[count];
            delete [] elements;

            elements = new T * [size + 1];
            for (int count=0;   count<size + 1;   count++)
                elements[count] = (count<size && oldElements.elements[count] != nullptr) ? (new T(*(oldElements.elements[count]))) : nullptr;
            resize(size);
        }
        else if(index >= size) {
            for (int count=0;   count<size;     count++)
                delete elements[count];
            delete [] elements;

            elements = new T * [index+1];
            for (int count=0;   count<index+1;  count++)
                elements[count] = (count<size && oldElements.elements[count] != nullptr) ? (new T(*(oldElements.elements[count]))) : nullptr;
            resize(index);
        }

        elements[index] = new T(element);
        for (int xCount=0, yCount=0;  xCount<size;    xCount++, yCount++) {
            if (xCount == index)
                yCount--;
            else if(yCount<oldSize && oldElements.elements[yCount] != nullptr) {
                delete elements[xCount];
                elements[xCount] = new T(*oldElements.elements[yCount]);
            }
        }
    }
    numElements++;
}


//Remove
template <class T>
T DynamicArray<T>::remove(int index) {
    if (elements[index] == nullptr || index < 0 || index >= size)
        throw RemoveException("empty structure");

    T data_item = *(elements[index]);
    delete elements[index];
    elements[index] = nullptr;

    for (int count=index+1;     count<size;     count++){
        if (index == size-1)
            break;
        else
            elements[count-1] = elements[count];
        if (count == size-1)
            elements[count] = nullptr;
    }
    numElements--;
    return data_item;
}


//Empty checker
template <class T>
bool DynamicArray<T>::isEmpty() {
    for (int index=0;   index<size;     index++)    {
        if (elements[index] != nullptr)
            return false;
    }
    return true;
}


//Clear
template <class T>
void DynamicArray<T>::clear() {
    for (int count=0;   count<size;     count++) {
        if (elements[count] != nullptr){
            delete elements[count];
            elements[count] = nullptr;
        }
    }
    numElements = 0;
}


//Resize
template<class T>
void DynamicArray<T>::resize(int howMuch) {
    this->size = howMuch + 1;
}


//Overloaded extraction operator
template <class T>
ostream &operator<< (ostream &os ,DynamicArray<T> &obj) {
    obj.print(os);
    return os;
}


//Print
template <class T>
ostream &DynamicArray<T>::print(ostream& os) {
    os << "[";
    for (int count=0;   count<size;     count++) {
        if (elements[count] == nullptr) {
            if (count == size -1)
                os << "*";
            else
                os << "*,";
        }
        else {
            if (count == size -1)
                os << *(elements[count]);
            else
                os << *(elements[count]) <<",";
        }
    }
    os << "]";
    return os;
}
