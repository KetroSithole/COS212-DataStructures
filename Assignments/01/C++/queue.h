#ifndef ASSIGNMENT_1_C___QUEUE_H
#define ASSIGNMENT_1_C___QUEUE_H

#include "orderedContainer.h"


template<class T>
class Queue : public OrderedContainer<T> {
public:
    /*
    The constructor initializes the Queue with
    the structure which will contain the elements.
    */
    Queue(LinearStructure<T> *c);

    /*
    Copy constructor
    */
    Queue(const Queue<T> &other);

    /*
    The overloaded assignment operator.  You will have to replace this
    operator with an appropriate equivalent in your Java code
    */
    Queue<T> &operator=(const Queue<T> &other);

    /*
    Destructor.
    */
    virtual ~Queue();

    /*
    This function removes and returns the element
    at the front of the Queue.
    */
    virtual T remove();

    /*
    This function returns, but does NOT remove, the
    element at the front of the queue.
    */
    virtual T next();

    /*
    This function places the element sent in as a
    parameter at the back of the Queue.
    */
    virtual void insert(T el);
};


#endif //ASSIGNMENT_1_C___QUEUE_H
