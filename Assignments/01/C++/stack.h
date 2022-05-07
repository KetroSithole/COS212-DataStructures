#ifndef ASSIGNMENT_1_C___STACK_H
#define ASSIGNMENT_1_C___STACK_H

#include "orderedContainer.h"

template<class T>
class Stack : public OrderedContainer<T> {
public:
    /*
    The constructor initializes the stack with
    the structure which will contain the elements.
    */
    Stack(LinearStructure<T> *c);

    /*
    Copy constructor
    */
    Stack(const Stack<T> &other);

    /*
    Overloaded assignment operator.
    */
    Stack<T> &operator=(const Stack<T> &other);

    /*
    Destructor.
    */
    virtual ~Stack();

    /*
    This function pops and returns the element
    on the top of the Stack.
    */
    virtual T remove();

    /*
    This function returns, but does NOT remove, the
    element at the top of the stack.
    */
    virtual T next();


    /*
    This function pushes the element sent in as a
    parameter onto the top of the Stack.
    */
    virtual void insert(T el);
};


#endif //ASSIGNMENT_1_C___STACK_H
