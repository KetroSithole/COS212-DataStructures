@SuppressWarnings("unchecked")
public class LinkedList<T extends Comparable<? super T>> extends LinearStructure<T>{

    // Constructor
    public LinkedList(){
        head = null;
    }


    // Copy Constructor
    LinkedList(LinkedList<T> other) throws RemoveException {
        head = null;
        int count = 0;
        for (Node<T> currPtr = other.head;     currPtr != null;     currPtr = currPtr.next)
            insert(count++, currPtr.element);
    }


    // Clone
    @Override
    public LinkedList<T> clone() {
        LinkedList<T> clone_list = new LinkedList<>();
        Node<T> currPtr = this.head;
        int count = 0;
        try {
            for (;  currPtr != null;    currPtr = currPtr.next)
                clone_list.insert(count++, currPtr.element);
        } catch (RemoveException e) {
            e.printStackTrace();
        }
        return clone_list;
    }


    //Insert
    @Override
    public void insert(int index, T element) throws RemoveException {
        if (index < 0 || index > size())
            throw new RemoveException("invalid index");
        else {
            Node<T> newNode = new Node<>(element, null), currPtr = head, previousPtr = null;
            if (head == null)
                head = newNode;
            else if (index == 0){
                newNode.next = head;
                head = newNode;
            }
            else {
                for (int count=0;   count<index;    count++, currPtr = currPtr.next)
                    previousPtr = currPtr;
                previousPtr.next = newNode;
                newNode.next = currPtr;
            }
        }
    }


    // Remove
    @Override
    public T remove(int index) throws RemoveException {
        if (index < 0 || index >= size() || head == null)
            throw new RemoveException("empty structure");
        else {
            Node<T> currPtr = head, previousPtr = null;
            T data_item;
            if (index == 0) {
                data_item = head.element;
                head = head.next;
            }
            else {
                for (int count=0;   count<index;    count++, currPtr=currPtr.next)
                    previousPtr = currPtr;
                previousPtr.next = currPtr.next;
                data_item = currPtr.element;
            }
            return data_item;
        }
    }


    // isEmpty
    @Override
    public boolean isEmpty() {
        return (head == null);
    }


    // Clear
    @Override
    public void clear() {
        head = null;
    }


    // Get Leader
    public Node<T> getLeader() {
        return head;
    }


    // Overloaded Print
    @Override
    public String toString() {
        StringBuilder printString = new StringBuilder("[");
        for (Node<T> currPtr = head;   currPtr != null;     currPtr = currPtr.next) {
            if (currPtr.next == null)
                printString.append(currPtr.element);
            else
                printString.append(currPtr.element).append(",");
        }
        printString.append("]");
        return printString.toString();
    }


    // Private methods and fields
    private int size(){
        int size = 0;
        for (Node<T> nodePtr = head;   nodePtr != null;     nodePtr = nodePtr.next)
            size++;
        return size;
    }

    private Node<T> head;
}
