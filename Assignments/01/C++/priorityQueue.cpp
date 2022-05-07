//Provide the implementation for the PriorityQueue class in this file.
#include "priorityQueue.h"


template <class T>
PriorityQueue<T>::PriorityQueue(LinearStructure<T>* c) : OrderedContainer<T>(c) {}


template <class T>
PriorityQueue<T>::PriorityQueue(const PriorityQueue<T> &other) : OrderedContainer<T>(other) {}


template <class T>
PriorityQueue<T> &PriorityQueue<T>::operator=(const PriorityQueue<T>& other) {
    if (this != &other)
        this->dataStructure = &other.dataStructure->clone();
    return *this;
}


template <class T>
PriorityQueue<T>::~PriorityQueue() {}


template <class T>
T PriorityQueue<T>::remove() {
    T data_item = this->dataStructure->remove(0);
    return data_item;
}


template <class T>
T PriorityQueue<T>::next(){
    T top_item = this->dataStructure->remove(0);
    this->dataStructure->insert(0, top_item);
    return top_item;
}


template <class T>
void PriorityQueue<T>::insert(T el) {
    if (this->isEmpty())
        this->dataStructure->insert(0, el);
    else {
        LinearStructure<T> *clone = &this->dataStructure->clone();
        int index = 0;
        for (;  !clone->isEmpty();  index++){
            if (clone->remove(0) < el)
                break;
        }
        this->dataStructure->insert(index, el);
    }
}
