
public interface PriorityQueueI<K, V> {
	// Only static methods, default methods and data fields can be defined here
	// (nothing else)

	void insert(K priority, V item); // textbook calls this method enqueue

	Pair<K, V> removeMin(); // textbook calls this method dequeue

	Pair<K, V> findMin(); // textbook calls this method peek

	boolean isEmpty();

	int getLength();

}
