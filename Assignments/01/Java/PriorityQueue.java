public class PriorityQueue<T extends Comparable<? super T>> extends OrderedContainer<T> {

    // Constructor
    public PriorityQueue(LinearStructure<T> c) {
        super(c);
    }


    // Copy Constructor
    public PriorityQueue(OrderedContainer<T> other) {
        super(other);
    }


    // Remove
    public T remove() throws RemoveException {
      return this.dataStructure.remove(0);
    }


    // Next
   public T next() throws RemoveException {
       T top_item = this.dataStructure.remove(0);
       this.dataStructure.insert(0, top_item);
       return top_item;
   }


   // Insert
    public void insert(T el) throws RemoveException {
        if (this.isEmpty())
            this.dataStructure.insert(0, el);
        else {
            PriorityQueue<T> clone = this.clone(), insert_clone = this.clone();
            int index = 0;

            while (!clone.isEmpty()){
                if (clone.remove().compareTo(el) < 0)
                    break;
                else{
                    index++;
                    insert_clone.remove();
                }
            }
            this.dataStructure.insert(index, el);
            while (!insert_clone.isEmpty()) {
                this.dataStructure.insert(++index, insert_clone.remove());
            }
        }
    }


    // Clone
    @Override
    public PriorityQueue<T> clone(){
        return new PriorityQueue<>(this);
    }
}
