//Paarth Badola
//20012789

public class Node<E> {
	public E val;
	public Node<E> next;
	
	public Node(E val) {
		this.val = val;
		this.next = null;
	}
	
	public Node(E val, Node<E> nextNode) {
		this.val = val;
		this.next = nextNode;
	}
}
