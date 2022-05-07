public class Node<T> {
	public Node(T data_, int key_) {
		this.data = data_;
		this.key = key_;
	}

	public T getData() {
		return data;
	}

	public int getKey() {
		return key;
	}

	public String toString() {
		return data.toString();
	}

	protected T data;
	protected int key;
}
