public class Main {
    //CircularList
    public static void test1() throws RemoveException {


        CircularList<Integer> c = new CircularList<Integer>();
        c.insert(0, 5);
        c.insert(1, 6);
        c.insert(2, 7);
        c.insert(3, 8);
        c.insert(4, 9);

        System.out.println(c);

        Node<Integer> n = c.getLeader();

        n = n.next;

        while (n != c.getLeader())
            n = n.next;

        System.out.println("out");

        while (!c.isEmpty())
            System.out.print(c.remove(0));

        System.out.println("");
        /*

            Output
    ---------------------------
    [5,6,7,8,9]
    out
    56789

    */
    }
    //
//
    public static void test2() throws RemoveException {

        LinkedList<Integer> c = new LinkedList<Integer>();
        c.insert(0, 5);
        c.insert(1, 6);
        c.insert(2, 7);
        c.insert(3, 8);
        c.insert(4, 9);
        c.insert(5, 10);

        System.out.println(c);

        Node<Integer> n = c.getLeader();


        while (n != null)
            n = n.next;

        System.out.println("out");

        while (!c.isEmpty())
            System.out.print(c.remove(0));//567891011

        System.out.println("");
        /*
        Output
        ------------------
        [5,6,7,8,9,10]
        out
        5678910
        */

    }


    public static void test3() throws RemoveException {

        DynamicArray<Integer> c = new DynamicArray<Integer>(1);
        c.insert(0, 5);
        c.insert(1, 6);
        c.insert(2, 7);
        c.insert(3, 8);
        c.insert(4, 9);
        c.insert(5, 9);
        c.insert(6, 9);
        c.insert(7, 9);
        c.insert(8, 9);
        c.insert(9, 9);

        DynamicArray<Integer> c2 = c;
        System.out.println(c2);
        System.out.println(c);

        while (!c.isEmpty())
            System.out.print(c.remove(0));

        System.out.println("");

        c.insert(0, 5);
        c.insert(1, 6);
        c.insert(2, 7);
        c.insert(3, 8);
        c.insert(4, 9);
        System.out.println(c);
    /*
     Output
     ------------------
     [5,6,7,8,9,9,9,9,9,9]
     [5,6,7,8,9,9,9,9,9,9]
     5678999999
     [5,6,7,8,9,*,*,*,*,*]
     */
    }

    public static void populateOrdered(OrderedContainer<Integer> c) throws RemoveException {
    c.insert( 6);
    c.insert(1);
    c.insert(3);
    c.insert(2);
    c.insert(1);
    c.insert(4);
    c.insert(5);

        System.out.println(c.getImplementation());


        while (!c.isEmpty())
            c.remove();
        System.out.println("Done");
        System.out.println(c.getImplementation());

    }


    public static void testOrdered(OrderedContainer<Integer> c) throws RemoveException {
        populateOrdered(c);
    }


    public static void testOrdered() throws RemoveException {

        testOrdered(new Stack<Integer>(new LinkedList<Integer>()));

        testOrdered(new Queue<Integer>(new CircularList<Integer>()));

        testOrdered(new PriorityQueue<Integer>(new DynamicArray<Integer>(10)));

        /*
        Output
        ---------------------
        [0,1,2,3,4,5,6,7,8,9,10,11]
        Done
        []
        [0,1,2,3,4,5,6,7,8,9,10,11]
        Done
        []
        [11,10,9,8,7,6,5,4,3,2,1,0]
        Done
        [*,*,*,*,*,*,*,*,*,*,*,*]
         */
    }


    public static void main(String[] args) {
        try {
            test1();
            test2();
            test3();
            testOrdered();

        } catch (Throwable r) {
            System.out.println("Exception");
        }

    }

}
