#ifndef ASSIGNMENT_1_C___PRIORITYQUEUE_H
#define ASSIGNMENT_1_C___PRIORITYQUEUE_H


#include "orderedContainer.h"


template<class T>
class PriorityQueue : public OrderedContainer<T> {
public:
    /*
    The constructor initializes the PriorityQueue with
    the structure which will contain the elements.
    */
    PriorityQueue(LinearStructure<T> *c);

    /*
    Copy constructor
    */
    PriorityQueue(const PriorityQueue<T> &other);

    /*
    The overloaded assignment operator.  You will have to replace this
    operator with an appropriate equivalent in your Java code
    */
    virtual PriorityQueue<T> &operator=(const PriorityQueue<T> &other);

    /*
    Destructor.
    */
    virtual ~PriorityQueue();

    /*
    This function removes and returns the element
    with the highest priority in the PriorityQueue.
    For this implementation that would be the largest
    element in the queue
    */
    virtual T remove();

    /*
    This function returns, but does NOT remove, the
    element with the higest priority.
    */
    virtual T next();

    /*
    This function inserts an element in the PriorityQueue.
    */
    virtual void insert(T el);

};


#endif //ASSIGNMENT_1_C___PRIORITYQUEUE_H
