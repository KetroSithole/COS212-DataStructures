// public class Test {
// 	public static void main(String[] args) {
// 		// System.out.println("This Main does not guarantee full marks, or any marks at all");
// 		// System.out.println();
// 		// System.out.println("The parameter _d_ that appears in all the functions (apart from oldTest)");
// 		// System.out.println("is the d value that will be used for the heap inside the function");
// 		// System.out.println("this value can be changed if so desired, however, keep in mind that the");
// 		// System.out.println("accompanying output is obtained using the values passed in originally.");
// 		// System.out.println();
// 		// System.out.println("uncomment the functions as you test, the functions do not test anything in a particular order.");
// 		// System.out.println();

// 		oldTest();

// 		//    extraTest(2);

// 		// partOne(2);

// 		//     //original loop values i = 2 -> i < 4
// 		//    for (int i = 2; i < 4; i++)
// 		//        partTwo(i);

// 		//    randNumsTestOne(2);

// 		//    randNumsTestOne(5);

// 		//    randNumsTestTwo(3);

// 		//    finalTest(2);

// 	}

// 	static void partOne(int _d_) {
// 		System.out.println("Using _d_=" + _d_);
// 		System.out.println("Filling heap with numbers from 0 to 14: ");
// 		MinMaxDHeap<Integer> h1 = new MinMaxDHeap(_d_);
// 		for (int i = 0; i < 15; i++) {
// 			h1.insert(i, i);
// 		}
// //        h1.printTree();
// 		System.out.println("h1 Heap: " + h1);
// 		System.out.println();

// 		System.out.println("Emptying tree by removing max element continuously: ");
// 		for (int i = 0; i < 15; i++) {
// 			System.out.println("Removed: " + h1.deleteMax());
// 			System.out.println("h1 Heap: " + h1);
// 			System.out.println();

// 		}

// 		System.out.println("Heap should now be empty");
// 		System.out.println();

// 		System.out.println("Filling heap with numbers from 0 to 14: ");
// 		for (int i = 0; i < 15; i++) {
// 			h1.insert(i, i);
// 		}

// 		System.out.println("h1 Heap: " + h1);
// //        h1.printTree();
// 		System.out.println();
// 		System.out.println("Emptying tree by removing min element continuously: ");
// 		for (int i = 0; i < 15; i++) {
// 			System.out.println("Removed: " + h1.deleteMin());
// 			System.out.println("h1 Heap: " + h1);
// //            h1.printTree();
// 			System.out.println();
// 		}
// 	}

// 	static void partTwo(int _d_) {
// 		System.out.println("Using _d_=" + _d_);
// 		MinMaxDHeap<Integer> h1 = new MinMaxDHeap(_d_);
// 		System.out.println("Filling heap with numbers from 14 to 0: ");
// 		for (int i = 14; i >= 0; i--) {
// 			h1.insert(i, i);
// 		}
// //        h1.printTree();
// 		System.out.println("h1 Heap: " + h1);
// 		System.out.println();

// 		System.out.println("Emptying tree by removing max element continuously: ");
// 		for (int i = 0; i < 15; i++) {
// 			System.out.println("Removed: " + h1.deleteMax());
// 			System.out.println("h1 Heap: " + h1);
// 			System.out.println();
// 		}

// 		System.out.println("Heap should now be empty");
// 		System.out.println();

// 		System.out.println("Filling heap with numbers from 14 to 0: ");
// 		for (int i = 14; i >= 0; i--) {
// 			h1.insert(i, i);
// 		}

// 		System.out.println("h1 Heap: " + h1);
// 		System.out.println();
// 		System.out.println("Emptying tree by removing min element continuously: ");
// 		for (int i = 0; i < 15; i++) {
// 			System.out.println("Removed: " + h1.deleteMin());
// 			System.out.println("h1 Heap: " + h1);
// 			System.out.println();
// 		}
// 	}

// 	static void randNumsTestOne(int _d_) {
// 		int[] randNumArr = new int[]{61, 37, 80, 71, 48, 27, 41, 17, 55, 1, 36, 14, 65,
// 				54, 21, 69, 33, 6, 4, 28, 77,
// 				26, 25, 64, 63, 32, 20, 58, 39, 35, 71};
// 		System.out.println("Using _d_=" + _d_);
// 		System.out.println("Filling heap with random numbers: ");
// 		System.out.print("Numbers used: ");
// 		for (int num : randNumArr) System.out.print(num + " ");

// 		System.out.println();
// 		System.out.println();

// 		MinMaxDHeap<Integer> h1 = new MinMaxDHeap(_d_);
// 		for (int num : randNumArr) h1.insert(num, num);
// 		System.out.println("h1: " + h1);
// 		//        h1.printTree();

// 		System.out.println();
// 		System.out.println("Emptying tree by removing min elements: ");
// 		for (int num : randNumArr) System.out.println("Removed: " + h1.deleteMin());

// 		System.out.println();
// 		System.out.println("Filling heap with same numbers:");
// 		for (int num : randNumArr) h1.insert(num, num);
// 		System.out.println("h1: " + h1);

// 		System.out.println();
// 		System.out.println("Emptying tree by removing max elements: ");
// 		for (int num : randNumArr) System.out.println("Removed: " + h1.deleteMax());


// 	}

// 	static void randNumsTestTwo(int _d_) {
// 		int[] randNumArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
// 				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 14,
// 				1, 28, 29, 30, 31, 32, 5, 33, 34, 35, 36, 37, 38, 39, 40,
// 				41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 21, -1};
// 		System.out.println("Using _d_=" + _d_);
// 		System.out.println("Filling heap with random numbers: ");
// 		System.out.print("Numbers used: ");
// 		for (int num : randNumArr) System.out.print(num + " ");

// 		System.out.println();
// 		System.out.println();

// 		MinMaxDHeap<Integer> h1 = new MinMaxDHeap(_d_);
// 		for (int num : randNumArr) h1.insert(num, num);
// 		System.out.println("h1: " + h1);
// //        h1.printTree();
// 		System.out.println();
// 		System.out.println("Peeking Min: " + h1.peekMin());
// 		System.out.println("Peeking Max: " + h1.peekMax());
// 		System.out.println();

// 		System.out.println("Clearing all but the last 2 elements, alternating between max and min: ");
// 		for (int i = 0; i < randNumArr.length - 2; i++) {
// 			if (i % 2 == 0) System.out.println("Min removed: " + h1.deleteMin());
// 			else System.out.println("Max removed: " + h1.deleteMax());
// 		}
// 		System.out.println();
// 		System.out.println("Heap is now: " + h1);
// 		System.out.println();
// 		System.out.println("Peeking Min: " + h1.peekMin());
// 		System.out.println("Peeking Max: " + h1.peekMax());
// 		System.out.println();

// 		System.out.println("Removing Min: ");
// 		System.out.println("Min removed: " + h1.deleteMin());
// 		System.out.println();
// 		System.out.println("Peeking Min: " + h1.peekMin());
// 		System.out.println("Peeking Max: " + h1.peekMax());
// 		System.out.println();

// 		System.out.println("Removing Max: " + h1.deleteMax());

// 		System.out.println();

// 		System.out.println("Heap is now: " + h1);

// 		System.out.println();

// 		System.out.println("Peeking Min: " + h1.peekMin());
// 		System.out.println("Peeking Max: " + h1.peekMax());

// 		System.out.println();

// 		System.out.println("Removing Max: " + h1.deleteMax());
// 		System.out.println("Removing Min: " + h1.deleteMax());

// 	}

// 	static void finalTest(int _d_) {
// //        int[] randNumArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
// //                15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 14,
// //                1, 28, 29, 30, 31, 32, 5, 33, 34, 35, 36, 37, 38, 39, 40,
// //                41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 21};
// //
// 		int[] randNumArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
// 				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 14,
// 				1, 28, 29, 30, 31, 32, 5, 33, 34, 35, 36, 37, 38, 39, 40,
// 				41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 21, -1};
// 		System.out.println("Using _d_=" + _d_);
// 		System.out.println("Filling heap with random numbers: ");
// 		System.out.print("Numbers used: ");
// 		for (int num : randNumArr) System.out.print(num + " ");

// 		System.out.println();
// 		System.out.println();

// 		MinMaxDHeap<Integer> h1 = new MinMaxDHeap(_d_);
// 		for (int num : randNumArr) h1.insert(num, num);
// 		System.out.println("h1: " + h1);
// //        h1.printTree();
// 		System.out.println();

// 		System.out.println();

// 		System.out.println("Changing _d_ to _d_ + 1: ");
// 		h1.changeD(++_d_);
// 		System.out.println("h1: " + h1);

// 		System.out.println();

// 		System.out.println("Removing Min: " + h1.deleteMin());
// 		System.out.println("Removing Max: " + h1.deleteMax());
// 		System.out.println("h1: " + h1);
// //        h1.printTree();

// 		System.out.println();

// 		System.out.println("Changing _d_ to _d_ + 1: ");
// 		h1.changeD(++_d_);
// 		System.out.println("h1: " + h1);

// 		System.out.println();

// 		System.out.println("Removing Min: " + h1.deleteMin());
// 		System.out.println("Removing Max: " + h1.deleteMax());
// 		System.out.println("h1: " + h1);
// //        h1.printTree();

// 		System.out.println();

// 		System.out.println("Changing _d_ to _d_ + 1: ");
// 		h1.changeD(++_d_);
// 		System.out.println("h1: " + h1);

// 		System.out.println();

// 		System.out.println("Removing Min: " + h1.deleteMin());
// 		System.out.println("Removing Max: " + h1.deleteMax());
// 		System.out.println("h1: " + h1);
// //        h1.printTree();

// 		System.out.println("_______________________________________________________________");
// 		System.out.println();
// 		System.out.println("Clearing the heap using the clear function, and setting _d_ to 2: ");

// 		h1.clear();
// 		h1.changeD(2);
// 		System.out.println("h1: " + h1);
// 		System.out.println();

// 		System.out.println("Inserting 1000, 500, 250 and 1500: ");
// 		h1.insert(1000, 1000);
// 		h1.insert(500, 500);
// 		h1.insert(250, 250);
// 		h1.insert(1500, 1500);
// 		System.out.println("h1: " + h1);
// //        h1.printTree();
// 		System.out.println();
// 		System.out.println("Removing Max: " + h1.deleteMax());
// 		System.out.println("h1: " + h1);
// //        h1.printTree();
// 		System.out.println();
// 		System.out.println();

// 		System.out.println("Constructing a new heap using the original array");
// 		Node<Integer>[] nodeArr = new Node[randNumArr.length];
// 		for (int i = 0; i < nodeArr.length; i++) {
// 			nodeArr[i] = new Node<>(randNumArr[i], randNumArr[i]);
// 		}

// 		Node<Integer>[] nodeArrCopy = nodeArr.clone();

// 		h1.construct(nodeArrCopy);
// 		System.out.println("Constructed");
// //        h1.printTree();
// 		System.out.println("h1: " + h1);
// 		System.out.println();
// 		System.out.println("Emptying by removing Max: ");
// 		for (Node<Integer> node : nodeArr) {
// 			System.out.println("Removing max: " + h1.deleteMax());
// 		}

// 		nodeArrCopy = nodeArr.clone();

// 		System.out.println();
// 		System.out.println("Changing _d_ to 3 and constructing new heap using same values: ");
// 		h1.changeD(3);
// 		System.out.println("Constructing a new heap using the original array");
// 		h1.construct(nodeArrCopy);
// 		System.out.println("Constructed");
// //        h1.printTree();
// 		System.out.println("h1: " + h1);
// 		System.out.println("Emptying by removing Min: ");
// 		for (Node<Integer> node : nodeArr) {
// 			System.out.println("Removing min: " + h1.deleteMin());
// 		}

// 	}

// 	static void extraTest(int _d_) {
// 		int[] randNumArr = new int[]{66, 67, 69, 72, 74, 75, 76, 80, 82, 83, 84, 86, 87, 88, 90};
// 		System.out.println("Using _d_=" + _d_);
// 		System.out.println("Filling heap with random numbers: ");
// 		System.out.print("Numbers used: ");
// 		for (int num : randNumArr) System.out.print(num + " ");

// 		System.out.println();
// 		System.out.println();

// 		MinMaxDHeap<Character> h1 = new MinMaxDHeap(_d_);
// 		for (int num : randNumArr) h1.insert((char) num, num);
// 		System.out.println("h1: " + h1);

// 		System.out.println();
// 		System.out.println("Clearing h1 by alternating between removing max and min:");
// 		for (int i = 0; i < randNumArr.length; i++) {
// //            h1.printTree();
// 			System.out.println((i % 2 == 0) ? "Removing Min: " + h1.deleteMin() : "Removing Max: " + h1.deleteMax());
// 			System.out.println("h1: " + h1);
// 			System.out.println();
// 		}
// 	}

// 	static void oldTest() {
// 		MinMaxDHeap<Integer> h = new MinMaxDHeap<>(3);
// //		h.insert(1,1);
// //		h.insert(3,3);
// //		h.insert(0,0);
// //		h.insert(4,4);
// 		h.insert(6, 6);
// 		h.insert(81, 81);
// 		h.insert(87, 87);
// 		System.out.println("Min peek: " + h.peekMin());
// 		System.out.println("Max peek: " + h.peekMax());


// 		h.insert(14, 14);
// 		h.insert(17, 17);
// 		h.insert(12, 12);
// 		h.insert(28, 28);

// 		h.insert(71, 71);
// 		h.insert(25, 25);
// 		h.insert(80, 80);
// 		h.insert(20, 20);
// 		h.insert(52, 52);
// 		h.insert(78, 78);
// 		h.insert(31, 31);
// 		h.insert(42, 42);

// 		h.insert(31, 31);
// 		h.insert(59, 59);
// 		h.insert(16, 16);
// 		h.insert(24, 24);
// 		h.insert(79, 79);
// 		h.insert(63, 63);
// 		h.insert(18, 18);
// 		h.insert(19, 19);
// 		h.insert(32, 32);
// 		h.insert(13, 13);
// 		h.insert(15, 15);
// 		h.insert(48, 48);

// 		h.deleteMax();

// 		System.out.println("heap: " + h.toString());

// 		System.out.println("Min peek: " + h.peekMin());
// 		System.out.println("Max peek: " + h.peekMax());

// 		System.out.println();

// 		Node<Integer>[] nodeArr = new Node[10];
// //		nodeArr[0] = new Node(1, 1);
// //		nodeArr[1] = new Node(3, 3);
// //		nodeArr[2] = new Node(0, 0);
// //		nodeArr[3] = new Node(0, 0);

// 		nodeArr[0] = new Node(11, 11);
// 		nodeArr[1] = new Node(3, 3);
// 		nodeArr[2] = new Node(6, 6);
// 		nodeArr[3] = new Node(8, 8);
// 		nodeArr[4] = new Node(20, 20);
// 		nodeArr[5] = new Node(0, 0);
// 		nodeArr[6] = new Node(90, 90);
// 		nodeArr[7] = new Node(8, 8);

// 		System.out.println("About to constuct");
// 		h.construct(nodeArr);
// 		System.out.println("heap: " + h);

// 		h.deleteMax();
// 		System.out.println("heap: " + h);

// 		h.deleteMax();
// 		System.out.println("heap: " + h);

// 		h.deleteMax();
// 		System.out.println("heap: " + h);

// 		h.deleteMax();
// 		System.out.println("heap: " + h);

// 		h.deleteMax();
// 		System.out.println("heap: " + h);
// 	}
// }
