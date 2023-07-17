// Paarth Badola
// 20012789

public class Node<T> {
	public T item_;
	public Node<T> prev;
	public Node<T> next;

	public Node(T item) {
		item_ = item;
		prev = null;
		next = null;
	}

	public String toString() {

		String outStr = "";

		if (item_ != null) {
			outStr += "item = " + item_.toString() + "\n";
		} else {
			outStr += "item =  null\n";
		}

		if (prev != null) {
			outStr += "prev_ hash code = " + prev.hashCode() + "\n";
		} else {
			outStr += "prev_ hash code = null\n";
		}

		if (next != null) {
			outStr += "next_ hash code = " + next.hashCode() + "\n";
		} else {
			outStr += "next_ hash code = null\n";
		}

		return outStr;
	}

}
