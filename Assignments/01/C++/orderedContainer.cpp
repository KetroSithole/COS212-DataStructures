//Provide the implementation for the OrderedQueue class in this file.
#include "orderedContainer.h"
#include "linearStructure.h"


//Constructor
template <class T>
OrderedContainer<T>::OrderedContainer(LinearStructure<T>* c) {
    this->dataStructure = c;
}


//Copy Constructor
template <class T>
OrderedContainer<T>::OrderedContainer(const OrderedContainer<T>& other) {
    this->dataStructure = &other.dataStructure->clone();
}


//Overload Assignment Operator
template <class T>
OrderedContainer<T> &OrderedContainer<T>::operator=(const OrderedContainer<T>& other) {
    if (this != &other) {
        this->dataStructure = &other.dataStructure->clone();
    }
    return *this;
}


//Destructor
template <class T>
OrderedContainer<T>::~OrderedContainer(){
    dataStructure->clear();
}


//isEmpty
template <class T>
bool OrderedContainer<T>::isEmpty() {
    return dataStructure->isEmpty();
}


//Get Implementation
template <class T>
LinearStructure<T> *OrderedContainer<T>::getImplementation() {
    return dataStructure;
}

