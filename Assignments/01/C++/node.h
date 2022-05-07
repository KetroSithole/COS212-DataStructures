
#ifndef ASSIGNMENT_1_C___NODE_H
#define ASSIGNMENT_1_C___NODE_H

template<class T>
class Node {
public:
    Node(T data, Node<T> *n = 0) {
        element = data;
        next = n;
    }

    ~Node() {
        next = 0;
    }

    //The element stored in the node
    T element;
    //The next node in the list
    Node<T> *next;
};

#endif //ASSIGNMENT_1_C___NODE_H
