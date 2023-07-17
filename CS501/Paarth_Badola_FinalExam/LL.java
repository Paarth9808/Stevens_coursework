//Paarth Badola
//20012789

public class LL<E extends Comparable<E>>{
	
	public Node<E> head;
	public Node<E> tail;
	int len = 0;
	
	LL(){
		head = null;
		tail = null;
	}
	
	public String toString() {
		String retStr = "";
		int cntr = 0;
		Node<E> temp = head;
		while(temp!=null) {
			retStr += "B[" + cntr + "] "+ "= ";
			retStr += temp.val + "\n";
			temp = temp.next;
			cntr += 1;
		}
		
		return retStr;
	}
	
	public void append(E val) {
		Node<E> tempNode = new Node<E>(val);
		len += 1;
		if (head == null) {
			head = tempNode;
			tail = tempNode;
			return;
		}
		
		tail.next = tempNode;
		tail = tempNode;
	}
	
	public void prepend(E val) {
		Node<E> tempNode = new Node<E>(val);
		
		if (head == null) {
			head = tempNode;
			tail = tempNode;
			return;
		}
		
		tempNode.next = head;
		head = tempNode;
		len += 1;
	}
	
	public Node<E> deleteEnd() {
		if(head == null) {
			System.out.println("List is empty");
			System.exit(0);
		}
		
		if (head.next == null) {
			Node<E> retNode = head;
			head = null;
			tail = null;
			return retNode;
		}
		Node<E> retNode = tail;
		Node<E> scanNode = head;
		
		if (scanNode == null) {
			return null;
		}
		while(scanNode.next.next != null) {
			scanNode = scanNode.next;
		}
		
		scanNode.next = null;
		tail = scanNode;
		
		len -= 1;
		return retNode;
	}
	
	public Node<E> deleteStart(){
		if(head == null) {
			System.out.println("List is empty");
			System.exit(0);
		}
		
		if (head.next == null) {
			Node<E> retNode = head;
			head = null;
			tail = null;
			len -= 1;
			return retNode;
		}
		
		Node<E> retNode = head;
		head = head.next;
		len -= 1;
		return retNode;
	}
	
	public void delete(E val){
		
		Node<E> scanNode = head;
		Node<E> prevNode = null;
		while (scanNode != null) {
			if(scanNode.val == val) {
				prevNode.next = scanNode.next;
				scanNode.next = null;
				len -= 1;
				return;
			}
			prevNode = scanNode;
			scanNode = scanNode.next;
		}
	}
	
	public void deleteAll(E val) {
		
		Node<E> scanNode = head;
		Node<E> prevNode = null;
		while (scanNode != null) {
			if(scanNode.val == val) {
				prevNode.next = scanNode.next;
				scanNode.next = null;
				len -= 1;
			}
			prevNode = scanNode;
			scanNode = scanNode.next;
		}
	}
	
	public int getLen() {
		return len;
	}
	
	public void sort() {
		if(len == 0)
			return;
		
		Node<E> current = head;
		
		while (current != null) {
			Node<E> nextNode = current.next;
			while(nextNode != null) {
				if(current.val.compareTo(nextNode.val) > 0) {
					E temp;
					temp = nextNode.val;
					nextNode.val = current.val;
					current.val = temp;
				}
				nextNode = nextNode.next;
			}
			current = current.next;
		}
	}
	
	public int find(E val1) {
		int cntr = -1;
		Node<E> scanNode = head;
		
		while (scanNode != null) {
			cntr += 1;
			if (scanNode.val == val1) {
				return cntr;
			}
			scanNode = scanNode.next;
		}
		
		return -1;
		
	}
	// make new reverse function
	public void reverse() {
		Node<E> prevNode = null;  
		Node<E> currNode = head;  
		Node<E> nextNode = null;  
		  
		while (currNode != null)   
		{  
		nextNode = currNode.next;  
		currNode.next = prevNode;  
		prevNode = currNode;  
		currNode = nextNode;  
		}  
		
		head = prevNode;
	}
	
	public String rString() {
		String rStr = "";
		Node<E> temp1 = deleteStart();
		rStr += "B[0] = " + temp1.val + "\n";
		Node<E> temp2 = deleteStart();
		rStr += "B[1] = " + temp2.val + "\n";
		Node<E> temp3 = deleteStart();
		rStr += "B[2] = " + temp3.val + "\n";
		Node<E> temp4 = deleteStart();
		rStr += "B[3] = " + temp4.val + "\n";
		Node<E> temp5 = deleteStart();
		rStr += "B[4] = " + temp5.val + "\n";
		Node<E> temp6 = deleteStart();
		rStr += "B[5] = " + temp6.val + "\n";
		Node<E> temp7 = deleteStart();
		rStr += "B[6] = " + temp7.val + "\n";
		Node<E> temp8 = deleteStart();
		rStr += "B[7] = " + temp8.val + "\n";
		
		rStr += "The length now is: " + len;
		return rStr;
	}
	
	public static void main(String[] args) throws Exception {
		LL<String>l1 = new LL<String>();
		String []A = {"s00", "4s1", "41s", "s31", "12s", "s14", "s23", "s42"};
		
		for (int i = 0; i< A.length; i++) {
			l1.append(A[i]);
		}
		
		for (int i = 0; i< A.length; i++) {
			// printing the array
			System.out.println("A[" + i + "] " + "= " + A[i]);
		}
		System.out.println("***********");
		// printing the linked list
		System.out.println(l1.toString());
		System.out.println("***********");
		l1.sort();
		// printing after sorting the linked list
		System.out.println(l1.toString());
		System.out.println("***********");
		l1.reverse();
		
		//printing the remove from start string after reverse and also last length
		System.out.println(l1.rString());
	}
}
