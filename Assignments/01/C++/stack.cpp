//Provide the implementation for the Stack class in this file.
#include "stack.h"


//Constructor
template <class T>
Stack<T>::Stack(LinearStructure<T>* c) : OrderedContainer<T>(c) {}


//Copy constructor
template <class T>
Stack<T>::Stack(const Stack<T>& other) : OrderedContainer<T>(other) {}


//Overloaded assignment operator.
template <class T>
Stack<T> &Stack<T>::operator=(const Stack<T>& other) {
    if (this != &other)
        this->dataStructure = &other.dataStructure->clone();
    return *this;
}


//Destructor.
template <class T>
Stack<T>::~Stack() {}


//Remove
template <class T>
T Stack<T>::remove() {
    T data_item = this->dataStructure->remove(0);
    return data_item;
}


//Return top
template <class T>
T Stack<T>::next() {
    T top_item = this->dataStructure->remove(0);
    this->dataStructure->insert(0, top_item);
    return top_item;
}


//Insert
template <class T>
void Stack<T>::insert(T el) {
    this->dataStructure->insert(0, el);
}
