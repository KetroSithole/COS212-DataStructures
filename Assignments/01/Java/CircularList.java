public class CircularList<T> extends LinearStructure<T>{

    // Constructor
    public CircularList() {
        tail = null;
    }

    // Copy Constructor
    CircularList(CircularList<T> other) throws RemoveException {
        this.tail = null;
        if (other.tail != null) {
            Node<T> currPtr = other.tail.next;
            int count = 0;
            do {
                insert(count++, currPtr.element);
                currPtr = currPtr.next;
            }
            while (currPtr != other.tail.next);
        }
    }


    // Clone
    @Override
    public CircularList<T> clone() {
        CircularList<T> clone = new CircularList<>();
        if (this.tail != null) {
            Node<T> currPtr = this.tail.next;
            int count = 0;
            do {
                try {
                    clone.insert(count++, currPtr.element);
                } catch (RemoveException e) {
                    e.printStackTrace();
                }
                currPtr = currPtr.next;
            }
            while (currPtr != this.tail.next);
        }
        return clone;
    }


    // Insert
    @Override
    public void insert(int index, T element) throws RemoveException {
        if (index < 0 || index > size())
            throw new RemoveException("invalid index");
        else {
            Node<T> newNode = new Node<>(element, null);
            if (tail == null) {
                tail = newNode;
                newNode.next = tail;
            }
            else if (index == 0) {
                newNode.next = tail.next;
                tail.next = newNode;
            }
            else if (index == size()) {
                newNode.next = tail.next;
                tail.next = newNode;
                tail = newNode;
            }
            else {
                Node<T> currPtr = tail.next, previousPtr = null;
                for (int count=0;   count<index;    count++, currPtr = currPtr.next)
                    previousPtr = currPtr;
                newNode.next = currPtr;
                previousPtr.next = newNode;
            }
        }
    }


    // Remove
    @Override
    public T remove(int index) throws RemoveException{
        if (index < 0 || index > size() || tail == null)
            throw new RemoveException("empty structure");
        else {
            Node<T> currPtr = tail.next, previousPtr = null;
            T data_item;
            if (tail.next == tail) {
                data_item = tail.element;
                tail = null;
            }
            else if (index == 0) {
                data_item = currPtr.element;
                tail.next = currPtr.next;
            }
            else {
                for (int count=0;   count<index;    count++, currPtr = currPtr.next )
                    previousPtr = currPtr;

                if (index == size()-1) {
                    data_item = tail.element;
                    previousPtr.next = currPtr.next;
                    tail = null;
                    tail = previousPtr;
                }

                else {
                    data_item = currPtr.element;
                    previousPtr.next = currPtr.next;
                }
            }
            return data_item;
        }
    }


    // isEmpty
    @Override
    public boolean isEmpty() {
        return (tail == null);
    }

    @Override
    // Clear
    public void clear() {
        tail = null;
    }

    // Get Leader
    public Node<T> getLeader() {
        return tail;
    }

    // Print Overload
    @Override
    public String toString() {
        StringBuilder printString = new StringBuilder("[");
        if (tail != null) {
            Node<T> currPtr = tail.next;
            do {
                if (currPtr.next == tail.next)
                    printString.append(currPtr.element);
                else
                    printString.append(currPtr.element).append(",");
                currPtr = currPtr.next;
            }
            while (currPtr != tail.next);
        }
        printString.append("]");
        return printString.toString();
    }


    // Private fields and methods
    private int size(){
        int size =0;
        if (tail != null) {
            Node<T> currPtr = tail.next;
            do {
                currPtr = currPtr.next;
                size++;
            }
            while (currPtr != tail.next);
        }
        return size;
    }

    private Node<T> tail;
}
