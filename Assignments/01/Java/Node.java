class Node <T> {
    public Node(T data, Node<T> n) {
        element = data;
        next = n;
    }

    // Public fields
    public T element;
    public Node<T> next;
}

