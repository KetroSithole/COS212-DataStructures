abstract class LinearStructure<T> {
    @Override
    public abstract LinearStructure<T> clone();
    abstract void insert(int index, T element) throws RemoveException;
    abstract T remove(int index) throws RemoveException;
    abstract boolean isEmpty();
    abstract void clear();
}