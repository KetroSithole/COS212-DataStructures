@SuppressWarnings("unchecked")
public class DynamicArray<T> extends LinearStructure<T> {

    // Constructor
    public DynamicArray(int s) throws RemoveException {
        if (s <= 0)
            throw new RemoveException("Invalid size provided");
        else {
            size = s;
            elements = new Object[size];
            for (int count = 0;     count<size;     count++)
                elements[count] = null;
            numElements = 0;
        }
    }


    // Copy Constructor
    DynamicArray(DynamicArray<T> other){
        size = other.size;
        numElements = other.numElements;
        if (this.size != 0) {
            elements =  new Object[size];
            for (int count=0;   count<size;     count++)
                elements[count] = (other.elements[count] != null) ? other.elements[count] : null;
        }
    }


    // Clone
    @Override
    public DynamicArray<T> clone() {
        return new DynamicArray<>(this);
    }


    // Insert
    @Override
    public void insert(int index, T element) {
        DynamicArray<T> oldElements = new DynamicArray<>(this);

        if (index < size)
            elements[index] = element;
        else if(index >= size) {
            clear();

            elements = new Object[index+1];
            for (int count=0;   count<index+1;  count++)
                elements[count] = (count<size && oldElements.elements[count] != null) ? oldElements.elements[count] : null;
            resize(index);
            elements[index] = element;
        }
        numElements++;
    }


    // Remove
    @Override
    public T remove(int index) throws RemoveException {
        if (isEmpty() || elements[index] == null || index < 0 || index >= size)
            throw new RemoveException("empty structure");

        T data_item = (T) elements[index];
        elements[index] = null;

        for (int count=index+1;     count<size;     count++){
            if (index == size-1)
                break;
            else
                elements[count-1] = elements[count];
            if (count == size-1)
                elements[count] = null;
        }
        numElements--;
        return data_item;
    }


    // isEmpty
    @Override
    public boolean isEmpty() {
        for (int index=0;   index<size;     index++)
            if (elements[index] != null)
                return false;
        return true;
    }


    // Clear
    @Override
    public void clear() {
        for (int count=0;   count<size;     count++)
            elements[count] = null;
        numElements = 0;
    }


    // Print Overload
    public String toString() {
        StringBuilder printString = new StringBuilder("[");
        for (int count=0;   count<size;     count++) {
            if (elements[count] == null) {
                if (count == size -1)
                    printString.append("*");
                else
                    printString.append("*,");
            }
            else {
                if (count == size -1)
                    printString.append(elements[count]);
            else
                printString.append(elements[count]).append(",");
            }
        }
        printString.append("]");
        return printString.toString();
    }


    // Private Methods and Fields
    private void resize(int howMuch){
        this.size = howMuch + 1;
    }

    private Object[] elements;
    private int size;
    private int numElements;
}
