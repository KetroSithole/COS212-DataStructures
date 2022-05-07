/**
 * Name:    Isheanesu Joseph Dzingirai
 * Student Number:  u20536951
 */

public class TransposeOrganisingList extends OrganisingList {

    ////// Implement the function below this line //////

    /**
     * Retrieve the node with the specified key and swap the
     * accessed node with its predecessor, then recalculate all data fields.
     * @return The node with its data value before it has been moved,
     * otherwise 'null' if the key does not exist.
     */
    @Override
    public ListNode searchNode(Integer key) {
         if(contains(key)) {
            ListNode original_reference = null, original_moved = null, prevPtr = null, currPtr = root;
            if(root.key == key){
                calculateData();
                return root;
            }
            else {
                for (;  currPtr.next.key != key;    currPtr = currPtr.next)
                    prevPtr = currPtr;

                original_reference = new ListNode (currPtr.next.key, currPtr.next.data);
                original_moved = new ListNode (currPtr.next.key, currPtr.next.data);
                delete(currPtr.next.key);
                prevPtr.next = original_reference;
                original_reference.next = currPtr;
            }
            calculateData();
            return original_moved;
       }
       else
        return null;
    }
}
