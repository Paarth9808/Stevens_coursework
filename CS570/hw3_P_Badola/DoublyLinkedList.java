// Paarth Badola
// 20012789

public class DoublyLinkedList<T extends Comparable<T>> implements DoublyLinkedListI<T>{
	
	Node<T> head;
	Node<T> tail;
	
	// default constructor class
	DoublyLinkedList(){
		head = null;
		tail = null;
	}
	
	public String toString() {
		
		String outStr = "";
		Node<T> node = head;
		
		while (node != null) {
			outStr += node.item_.toString() + " ->  \n";
			node = node.next;
		}
		outStr += "***********";
		return outStr;
	}
	
	@Override
	public void prepend(T item) {
		// TODO Auto-generated method stub
		Node<T> node = new Node<T> (item);
		
		// if linked list is empty we give item value to head as well as tail
		if (head == null) {
			head = node;
			tail = node;
			return;
		}
		
		// assigning head to node's next value, then assigning node value to head's previous value and at last giving node value to head
		node.next = head;
		head.prev = node;
		head = node;
	}

	@Override
	public void append(T item) {
		// TODO Auto-generated method stub
		
		// if linked list is empty we give item value to head and tail
		Node<T> node = new Node <T> (item);
		if (head == null) {
			head = node;
			tail = node;
			return;
		}
		
		// assigning tail to node's previous value, then assigning node value to tail's next value and at last giving node value to tail
		node.prev = tail;
		tail.next = node;
		tail = node;
	}

	@Override
	public Node<T> removeFirst() {
		// TODO Auto-generated method stub
		// if no element return null
		if (head == null) {
			return head;
		}
		
		// making return node object for head
		Node<T> returnNode = head;
		
		if(head.next == null) {
			head = null;
			tail = null;
			return returnNode;
		}
		
		head = head.next;
		head.prev = null;
		
		return returnNode;
		
	}

	@Override
	public Node<T> removeLast() {
		// TODO Auto-generated method stub
		if(head == null) {
			return head;
		}
		
		Node<T> returnNode = tail;
		
		if(head.next == null) {
			head = null;
			tail = null;
			return returnNode;
		}
		
		tail = tail.prev;
		tail.next = null;
		
		return returnNode;
	}

	@Override
	public void insertAfter(Node<T> location, T item) {
		// TODO Auto-generated method stub
		if (location == null) {
			prepend(item);
			return;
		}

		// If location is tail_ append and return
		if (location == tail) {
			append(item);
			return;
		}

		// We have at least two nodes
		Node<T> node = new Node<T>(item);
		Node<T> sucNode = location.next;

		node.next = sucNode;
		sucNode.prev = node;
		node.prev = location;
		location.next = node;
		
	}

	@Override
	public Node<T> removeAfter(Node<T> location) {
		// TODO Auto-generated method stub
		if (location == null) {
			return removeFirst();
		}

		// if location is tail_, there's nothing to remove
		if (location == tail)
			return null;

		// if location is penultimate node remove lastj
		if (location.next == tail) {
			return removeLast();
		}

		// Finally, we have a typical case

		Node<T> retNode = location.next;
		Node<T> sucNode = location.next.next;

		location.next = sucNode;
		sucNode.prev = location;

		return retNode;
	}

	@Override
	public Node<T> search(T item) {
		// TODO Auto-generated method stub
		Node<T> temp = head;

		while (temp != null) {
			if (temp.item_ == item) {
				return temp;
			}

			temp = temp.next;
		}

		return null;
	}
	
	public Node<T> swapNodes(Node<T> n, Node<T> m) {
		
		// if both nodes equal return list
		if(n == m) {
			return m;
		}
		
		// if nodes are neighbours 
		if (n.next == m) {
			
			Node<T> temp = n.prev;
			removeAfter(temp);
			insertAfter(m, n.item_);
			
			return m.next;
			
		}
		
		// general case
		
		// declaring and initializing previous nodes of both the values  
		Node<T> prevNode1 = n.prev;
		Node<T> prevNode2 = m.prev;
		
		// removing the nodes
		removeAfter(prevNode1);
		removeAfter(prevNode2);
		
		// then inserting them 
		insertAfter(prevNode1, m.item_);
		insertAfter(prevNode2, n.item_);
		
		return prevNode2.next;
	}
	
	
	public void selectionSort() {

		// If we have no nodes or exactly one, there's nothing to do
		if (head == null || head.next == null)
			return;

		Node<T> currNode = head;
		
		while(currNode != null) {
			Node<T> minVal = currNode;
			Node<T> currVal = currNode;
			//System.out.println(minVal);
			Node<T> succNode = currNode.next;
			
			while(succNode != null) {
				
				//T succVal = succNode.item_;
				
				if(succNode.item_.compareTo(minVal.item_) < 0) {
					minVal = succNode;
				}
				
				succNode = succNode.next;
			}
			//System.out.println(minVal);
			swapNodes(currVal , minVal);
			currNode = currNode.next;
		}
	}
	
	
	public static void main(String [] args) {
		
		DoublyLinkedList<String> sList = new DoublyLinkedList<String>();
		//DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
		//list1.append(1);
		//list1.append(-1);
		//list1.append(11);
		//list1.append(9);
		//list1.append(21);
		//list1.append(88);
		
		sList.append("alpha");
		sList.append("beta");
		sList.append("gamma");
		sList.append("delta");

		sList.prepend("epsilon");
		sList.prepend("phi");
		sList.prepend("kappa");
		sList.prepend("mu");

		System.out.println(sList);
		
		Node<String> muNode = sList.search("phi");
		Node<String> kappaNode = sList.search("delta");
		Node<String> ret = sList.swapNodes(muNode, kappaNode);
		System.out.println(sList);
		System.out.println(ret);
		
		sList.selectionSort();
		System.out.println(sList);
	}
}
