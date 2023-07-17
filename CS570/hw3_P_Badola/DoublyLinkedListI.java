// Paarth Badola
// 20012789

public interface DoublyLinkedListI <T>{
	void prepend(T item);

	void append(T item);

	Node<T> removeFirst();

	Node<T> removeLast();

	void insertAfter(Node<T> location, T item);

	Node<T> removeAfter(Node<T> location);

	Node<T> search(T item);

	Node<T> swapNodes(Node<T> n, Node<T> m) ;
	
	void selectionSort();
}
