public class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	public LinkedList() {
		this.size = 0;
	}
	private class Node{
		private int value;
		private Node next;
		public Node(int value) {
			this.value = value;
		}
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	public void insertFirst(int val) {
		Node node =  new Node(val);
		node.next = head;
		head = node;
		if(tail == null) {
			tail = head;
		}
		size++;
	}
	public void insertLast(int val) {
		if(tail == null) {
			insertFirst(val);
			return;
		}
		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size++;
	}
	public void insertAtPos(int val, int index) {
		if(index == 0) {
			insertFirst(val);
			return;
		}
		if(index == size) {
			insertLast(val);
			return;
		}
		Node temp  = head;
		for(int i = 1; i < index; i++) {
			temp = temp.next;
		}
		Node node = new Node(val,temp.next);
		temp.next = node;
		size++;
	}
	public int deleteFirst() {
		int val =  head.value;
		head = head.next;
		if(head == null) {
			tail = null;
		}
		size--;
		return val;
	}
	public int deleteLast() {
		int val = tail.value;
		if(size <= 1)
		{
			deleteFirst();
		}
		Node node = get(size-2);
		node.next = null;
		tail = node;
		size--;
		return val;
	}
	public int deleteAtPos(int index) {
		if(index == 0) {
			deleteFirst();
		}
		if(index == size-1) {
			deleteLast();
		}
		Node node = get(index-1);
		int val = node.next.value;
		node.next = node.next.next;
		size--;
		return val;
	}
	public Node get(int index) {
		Node node = head;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	public void displayList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.value+"->");
			temp = temp.next;
		}
		System.out.println("END");
	}
	
}
