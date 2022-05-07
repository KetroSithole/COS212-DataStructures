#include <iostream>
#include "stack.h"
#include "stack.cpp"
#include "queue.h"
#include "queue.cpp"
#include "priorityQueue.h"
#include "priorityQueue.cpp"
#include "linkedList.h"
#include "linkedList.cpp"
#include "dynamicArray.h"
#include "dynamicArray.cpp"
#include "circularList.h"
#include "circularList.cpp"
#include "orderedContainer.h"
#include "orderedContainer.cpp"
#include "RemoveException.h"
#include "linearStructure.h"


using namespace std;

void cListTest();

void lListTest();

void dArrayTest();

void testOrdered();

int main() {
    try {
       cListTest();
       lListTest();
        dArrayTest();
       testOrdered();
    }
    catch (RemoveException r) {
        cout << "Ex" << endl;
    }
    catch (RemoveException *r) {
        cout << "Ex" << endl;
    }
}

//CircularList
void cListTest() {
    try {
        CircularList<int> *c = new CircularList<int>();
        c->insert(0, 5);
        c->insert(1, 6);
        c->insert(2, 7);
        c->insert(3, 8);
        c->insert(4, 9);

        cout << *c << endl;

        Node<int> *n = c->getLeader();

        while (n != c->getLeader())
            n = n->next;

        cout << "out" << endl;

        while (!c->isEmpty())
            cout << c->remove(0);

        cout << endl;

        delete c;
    }
    catch (RemoveException r) {
        throw r;
    }
    catch (RemoveException *e) {
        throw e;
    }

    /*

     Output
    ---------------------------
    [5,6,7,8,9]
    out
    56789

    */

}

//LinkedList
void lListTest() {
    try {
        LinkedList<int> *c = new LinkedList<int>();
        c->insert(0, 5);
        c->insert(1, 6);
        c->insert(2, 7);
        c->insert(3, 8);
        c->insert(4, 9);
        c->insert(5, 10);

        cout << *c << endl;

        Node<int> *n = c->getLeader();

        n = n->next;

        while (n)
            n = n->next;

        cout << "out" << endl;

        while (!c->isEmpty())
            cout << c->remove(0);

        cout << endl;

        delete c;
    }
    catch (RemoveException r) {
        throw r;
    }
    catch (RemoveException *e) {
        throw e;
    }

    /*
     Output
     ------------------
     [5,6,7,8,9,10]
     out
     5678910
     */

}

//DynamicArray
void dArrayTest() {
    try {
        DynamicArray<int> *c = new DynamicArray<int>(1);
        c->insert(0, 5);
        c->insert(1, 6);
        c->insert(2, 7);
        c->insert(3, 8);
        c->insert(4, 9);
        c->insert(5, 9);
        c->insert(6, 9);
        c->insert(7, 9);
        c->insert(8, 9);
        c->insert(9, 9);

        DynamicArray<int> *c2 = c;

        cout << *c2 << endl;
        cout << *c << endl;

        while (!c->isEmpty())
            cout << c->remove(0);

        cout << endl;

        c->insert(0, 5);
        c->insert(1, 6);
        c->insert(2, 7);
        c->insert(3, 8);
        c->insert(4, 9);

        cout << *c << endl;

        delete c;
    }
    catch (RemoveException r) {
        throw r;
    }
    catch (RemoveException *e) {
        throw e;
    }

    /*
     Output
     ------------------
     [5,6,7,8,9,9,9,9,9,9]
     [5,6,7,8,9,9,9,9,9,9]
     5678999999
     [5,6,7,8,9,*,*,*,*,*]
     */
}

void populateOrdered(OrderedContainer<int> *c) {
    c->insert(5);
        c->insert(3);
        c->insert(1);
        c->insert(4);
        c->insert(2);
    cout << *(c->getImplementation()) << endl;
    while (!c->isEmpty())
        c->remove();
    cout << "Done" << endl;
    cout << *(c->getImplementation()) << endl;

}


void testOrdered(OrderedContainer<int> *c) {
    populateOrdered(c);
    delete c;
}

void testOrdered() {
    try {

        testOrdered(new Stack<int>(new LinkedList<int>()));
        testOrdered(new Queue<int>(new CircularList<int>()));
        testOrdered(new PriorityQueue<int>(new DynamicArray<int>(10)));

    }
    catch (RemoveException r) {
        cout << "Ex" << endl;
    }
    catch (RemoveException *r) {
        cout << "Ex" << endl;
    }
}

    /*
    Output
    ------------
    [11,10,9,8,7,6,5,4,3,2,1,0]
    Done
    []
    [0,1,2,3,4,5,6,7,8,9,10,11]
    Done
    []
    [11,10,9,8,7,6,5,4,3,2,1,0]
    Done
    [*,*,*,*,*,*,*,*,*,*,*,*]
    */
