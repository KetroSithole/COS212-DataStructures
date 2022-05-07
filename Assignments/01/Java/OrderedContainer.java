public abstract class OrderedContainer<T> implements Cloneable  {

    // Constructor
    public OrderedContainer(LinearStructure<T> c){
        this.dataStructure = c;
    }


    // Copy Constructor
    OrderedContainer(OrderedContainer<T> other) {
        this.dataStructure = other.dataStructure.clone();
    }


    // Abstract Methods
    abstract T remove() throws RemoveException;
    abstract T next() throws RemoveException;
    abstract void insert(T el) throws RemoveException;
    @Override
    public abstract OrderedContainer<T> clone();


    public boolean isEmpty(){
        return this.dataStructure.isEmpty();
    }


    public LinearStructure<T> getImplementation() {
        return dataStructure;
    }

    // Protected fields
    protected LinearStructure<T> dataStructure;
}
