public class Queue<T> extends OrderedContainer<T>{

    // Constructor
    public Queue(LinearStructure<T> c) {
        super(c);
    }


    // Copy Constructor
    public Queue(OrderedContainer<T> other) {
        super(other);
    }

    // Clone
    @Override
    public Queue<T> clone() {
        return new Queue<>(this);
    }


    // Remove
    T remove() throws RemoveException {
        return this.dataStructure.remove(0);
    }

    // Next
    T next() throws RemoveException {
        LinearStructure<T> clone = this.dataStructure.clone();
        return clone.remove(0);
    }

    // Insert
    void insert(T el) throws RemoveException {
        LinearStructure<T> clone = this.dataStructure.clone();
        int rear = 0;
        while(!clone.isEmpty()) {
            rear++;
            clone.remove(0);
        }
        this.dataStructure.insert(rear, el);
    }
}
