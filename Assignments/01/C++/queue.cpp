//Provide the implementation for the Queue class in this file.
#include "queue.h"


//Constructor
template <class T>
Queue<T>::Queue(LinearStructure<T>* c) : OrderedContainer<T>(c) {}


//Copy constructor
template <class T>
Queue<T>::Queue(const Queue<T>& other) : OrderedContainer<T>(other) {}


//Overloaded assignment operator.
template <class T>
Queue<T> &Queue<T>::operator=(const Queue<T>& other) {
    if (this != &other)
        this->dataStructure = &other.dataStructure->clone();
    return *this;
}


//Destructor.
template <class T>
Queue<T>::~Queue() {}


//Remove
template <class T>
T Queue<T>::remove() {
    T data_item = this->dataStructure->remove(0);
    return data_item;
}


//Return top
template <class T>
T Queue<T>::next() {
    LinearStructure<T> *clone = &this->dataStructure->clone();
    T data_item = clone->remove(0);
    return data_item;
}


//Insert
template <class T>
void Queue<T>::insert(T el) {
    LinearStructure<T> &clone = this->dataStructure->clone();
    int rear = 0;
    while(!clone.isEmpty()) {
        rear++;
        clone.remove(0);
    }
    this->dataStructure->insert(rear, el);
}

