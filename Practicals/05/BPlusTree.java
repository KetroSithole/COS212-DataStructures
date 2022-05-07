/*
	You may not change the signatures of any of the given methods.  You may 
	however add any additional methods and/or field(s) which you may require to aid 
	you in the completion of this practical.
 */



public class BPlusTree {
	int order;
	int minKeys;
	int maxKeys;
	BPlusNode root; // do not modify

	public BPlusTree(int m) {
		/*
		The constructor.  Creates a BPlusTree object of order m,
		where m is passed as a parameter to the constructor. 
		You may assume that m >= 3.
		*/
		order = m;
		minKeys = (int) Math.ceil(m / 2.0) - 1;
		maxKeys = order - 1;
		root = new BPlusNode(m, true); /* root starts as leaf node and root's parent is null */
	}

	/* insert an element into the BPlusTree, you may assume duplicates will not be inserted. */
	public void insertElement(int element) {
		// your code goes here

		BPlusNode node = root;

		//find leaf node to insert at
		int index = 0;
		while(node.branches[0] != null){
			index = 0;
			while (index < node.keyTally){
				if (element <= node.keys[index]){
					break;
				}
				index++;
			}
			node = node.branches[index];
		}

		//Create temporary array to store children for rearranging later
		BPlusNode[] tempBranches = new BPlusNode[maxKeys+1];
		int tempTally = 0;
		int currMin = minKeys;
		int tempStart;int level = 0;


		//Iteratively split up as nodes gets full
		while (true){

			//1.If node is not full
			if (node.keyTally < maxKeys) {
				insertAtNode(element, node.keys, node.keyTally);

				for (int i = 0; i < tempBranches.length-1; i++){
					if (tempBranches[i] == null)
						break;
					node.branches[i] = tempBranches[i];
					node.branches[i].parent = node;
				}

				node.keyTally++;
				return;

			}//2.If the node node is full
			else{

				//Find index this node is at from it's parent
				if (node != root){
					index = 0;
					while (node != node.parent.branches[index]) {
						index++;
					}
				}

				//copy elements to a temporary array and insert new element there
				int [] temp = new int[maxKeys+1];
				if (maxKeys >= 0) System.arraycopy(node.keys, 0, temp, 0, maxKeys);
				insertAtNode(element,temp,maxKeys);

				//clear Old node
				for (int i = 0; i < maxKeys; i++){
					node.keys[i] = 0;
					node.branches[i] = null;
					node.keyTally = 0;
				}

				//Insert half of the nodes at node
				if (minKeys >= 0) System.arraycopy(temp, 0, node.keys, 0, minKeys);

				if (order%2 == 0){
						currMin = minKeys+1;
				}

				for (int i = 0; i < currMin; i++){
					node.keys[i] = temp[i];
					node.keyTally++;
				}

				//Attach half of the branches at the node
				//Branches should be at least 1 more than the keys, hence <= currMin
				for (int i = 0; i <= currMin; i++){

					if (tempBranches[i] == null)
						continue;;
					node.branches[i] = tempBranches[i];
					node.branches[i].parent = node;
				}

				//create the other newNode to distribute at
				BPlusNode newNode = new BPlusNode(order,level == 0);

				if (node.leaf)
					tempStart = currMin;
				else
					tempStart = currMin+1;


				//Insert the other half of the keys to the newNode
				for (int i = tempStart, j = 0; i < temp.length; i++, j++){
					newNode.keys[j] = temp[i];
					newNode.keyTally++;
				}

				tempStart = currMin+1;
				//Attach the other half of the branches to the newNode
				for (int i = tempStart, j=0; i < tempBranches.length;i++,j++)
				{
					if (tempBranches[i] == null)
						continue;
					newNode.branches[j] = tempBranches[i];
					newNode.branches[j].parent = newNode;
				}

				element = temp[currMin];

				//Arrange branches in temp array
				if (node != root) {
					tempBranches = new BPlusNode[maxKeys + 2];
					tempTally = 0;

					index = index+1;
					for (int i = 0; i < index; i++){
						tempBranches[i] = node.parent.branches[i];
						tempTally++;
						//System.out.println(tempBranches[i].toString());
					}

					tempBranches[index] = newNode;
					tempTally++;

					for (int i = index+1; i < tempBranches.length; i++) {

						tempBranches[i] = node.parent.branches[i-1];
						tempTally++;
					}

					//Assign ponter to next node of all leafs
					if (node.leaf){
						newNode.next = node.next;
						for (int i = 0; i < tempBranches.length-1; i++){
							if (tempBranches[i] == null)
								continue;;
							tempBranches[i].next = tempBranches[i+1];
						}
					}
				}

				level++;//Determines Wheter we are splitting leaf/internal nodes
				//if Node was the root
				if (node == root){
					//create new node and make it root
					BPlusNode newRoot = new BPlusNode(order,false);
					newRoot.keys[0] = element;
					newRoot.branches[0] = node;
					newRoot.branches[1] = newNode;
					newRoot.keyTally = 1;

					node.parent = newRoot;
					newNode.parent = newRoot;
					root = newRoot;
					return;
				}
				else{
					node = node.parent;
				}

			}
		}
	}

	/*  
	    This method should return the left-most leaf node in the tree.
		If the tree is empty, return null.
	 */
	public BPlusNode getFirstLeaf() {
		// your code goes here
		if (root.keyTally == 0)
			return null;
		else
		{
			BPlusNode node = root;

			while (!node.leaf )
				node = node.branches[0];

			return node;
		}
	}

	void insertAtNode(int elem, int [] arr, int n) {

		if (n == 0){
			arr[0] = elem;
			return;
		}

		int i = 0;
		for (i = n-1; i >= 0; i--) {
			if (elem > arr[i]){
				arr[i+1] = elem;
				return;
			}
			arr[i+1] = arr[i];
		}

		if (i < 0)
			arr[0] = elem;


	}
}
