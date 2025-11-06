package Problem_List.Q641_Design_Circular_Deque;

class MyCircularDeque {
	
	// Inner class for Node
	private class Node {
		int data;
		Node prev;
		Node next;
		
		Node(int value) {
			data = value;
			prev = null;
			next = null;
		}
	}
	
	private int capacity, size;
	private Node head, tail;
	
	// Constructor
	public MyCircularDeque(int k) {
		capacity = k;
		size = 0;
		
		// Dummy head and tail
		head = new Node(-1);
		tail = new Node(-1);
		
		head.next = tail;
		tail.prev = head;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public boolean insertFront(int value) {
		if (isFull()) return false;
		
		Node newNode = new Node(value);
		newNode.next = head.next;
		newNode.prev = head;
		head.next.prev = newNode;
		head.next = newNode;
		
		size++;
		return true;
	}
	
	public boolean insertLast(int value) {
		if (isFull()) return false;
		
		Node newNode = new Node(value);
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev.next = newNode;
		tail.prev = newNode;
		
		size++;
		return true;
	}
	
	public boolean deleteFront() {
		if (isEmpty()) return false;
		
		Node temp = head.next;
		head.next = temp.next;
		temp.next.prev = head;
		size--;
		return true;
	}
	
	public boolean deleteLast() {
		if (isEmpty()) return false;
		
		Node temp = tail.prev;
		tail.prev = temp.prev;
		temp.prev.next = tail;
		size--;
		return true;
	}
	
	public int getFront() {
		return isEmpty() ? -1 : head.next.data;
	}
	
	public int getRear() {
		return isEmpty() ? -1 : tail.prev.data;
	}
}

// * Your MyCircularDeque object will be instantiated and called as such:
// * MyCircularDeque obj = new MyCircularDeque(k);
// * boolean param_1 = obj.insertFront(value);
// * boolean param_2 = obj.insertLast(value);
// * boolean param_3 = obj.deleteFront();
// * boolean param_4 = obj.deleteLast();
// * int param_5 = obj.getFront();
// * int param_6 = obj.getRear();
// * boolean param_7 = obj.isEmpty();
// * boolean param_8 = obj.isFull();
// */

