/**
 * Name:
 * Student Number:
 */

abstract class OrganisingList {

    public ListNode root = null;

    public OrganisingList() {

    }

    /**
     * Calculate the data field of all nodes in the list using the recursive functions.
     */
    public void calculateData() {
        if (root != null) {
            dataRec(root);
        }
    }

    ////// You may not change any code above this line //////

    ////// Implement the functions below this line //////


    //Recursive functions

    /**
     * Calculate the sum of keys recursively, starting with the given node until the end of the list
     * @return The sum of keys from the current node to the last node in the list
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int sumRec(ListNode node) {
        if(node.next != null)
            return node.key + sumRec(node.next);
        else
            return node.key;
    }


    /**
     * Calculate and set the data for the given node.
     * @return The calculated data for the given node
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int dataRec(ListNode node) {
        if(node.next != null)
            node.data = (node.key * sumRec(node))-dataRec(node.next);
        else
            node.data = node.key;
        return node.data;
    }


    //Organising List functions
    /**
     * Retrieve the node with the specified key, move the node as required and recalculate all data fields.
     * @return The node with its data value before it has been moved, otherwise 'null' if the key does not exist.
     * Implement only in specific subclass!
     */
    public abstract ListNode searchNode(Integer key);


    /**
     * Check if a key is contained in the list
     * @return true if the key is in the list, otherwise false
     */
    public boolean contains(Integer key) {
        if (root != null){
            ListNode currPtr = root;
            while (currPtr != null){
                if (currPtr.key.equals(key))
                    return true;
                currPtr = currPtr.next;
            }
        }
        return false;
    }


    /**
     * Insert a new key into the linked list.
     * New nodes should be inserted at the back.
     * calculateData() should be called after insertion.
     * Duplicate keys should not be added.
     */
    public void insert(Integer key) {
        ListNode newNode = new ListNode(key);
        if (root == null) {
                root = newNode;
                newNode.next = null;
        }
        else {
            if (!contains(key)) {
                ListNode currPtr = root;
                while(currPtr.next != null)
                    currPtr = currPtr.next;
                currPtr.next = newNode;
                newNode.next=null;
            }
        }
        calculateData();
    }


    /**
     * Delete the node with the given key.
     * calculateData() should be called after deletion.
     * If the key does not exist, do nothing.
     */
    public void delete(Integer key) {
        if (contains(key)){
            ListNode currPtr = root, prevPtr = null;
            if (root.key.equals(key))
                root = root.next;
            else {
                for (; currPtr.key != key;  currPtr = currPtr.next)
                    prevPtr = currPtr;
                prevPtr.next = currPtr.next;
            }
            calculateData();
        }
    }
}
