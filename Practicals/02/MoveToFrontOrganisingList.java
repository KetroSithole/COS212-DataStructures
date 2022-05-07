/**
 * Name:
 * Student Number:
 */

public class MoveToFrontOrganisingList extends OrganisingList {

    ////// Implement the function below this line //////

    /**
     * Retrieve the node with the specified key and move the accessed node
     * to the front, then recalculate all data fields.
     * @return The node with its data value before it has been moved to the front,
     * otherwise 'null' if the key does not exist.
     */
    @Override
    public ListNode searchNode(Integer key) {
        if(contains(key)) {
            ListNode currPtr = root, old_reference = null;
            if(root.key == key)
                return root;
            else {
                while(currPtr.next != null)  {
                    currPtr = currPtr.next;
                    if(currPtr.key == (key)) {
                        old_reference = new ListNode(currPtr.key, currPtr.data);
                        delete(key);
                        currPtr.next = root;
                        root = currPtr;
                    }
                }
            }
            calculateData();
            return old_reference;
        }
        else
            return null;
    }
}
