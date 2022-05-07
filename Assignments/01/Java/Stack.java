public class Stack<T> extends OrderedContainer<T> {

    // Constructor
    Stack(LinearStructure<T> c) {
        super(c);
    }


    // Copy constructor
    Stack(Stack<T> other) {
        super(other);
    }


    /// Remove
    @Override
    public T remove() throws RemoveException {
        return this.dataStructure.remove(0);
    }


    // Next
    public T next() throws RemoveException {
        T top_item = this.remove();
        this.insert(top_item);
        return top_item;
    }


    // Insert
    public void insert(T el) throws RemoveException {
        this.dataStructure.insert(0, el);
    }

    // Clone
    @Override
    public Stack<T> clone() {
        return new Stack<>(this);
    }
}

