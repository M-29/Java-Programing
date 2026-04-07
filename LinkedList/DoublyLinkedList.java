public class DoublyLinkedList {
	public  Node head;
	private class Node{
		private int val;
		private Node next;
		private Node prev;
		public Node(int val){
			this.val = val;
		}
		public Node(int val, Node next, Node prev) {
			this.next = next;
			this.prev = prev;
			this.val = val;
		}
	}
	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		if(head != null) {
			head.prev   = node;
		}
		node.prev = null;
		head = node;
	}
	public void insertLast(int val) {
		Node node = new Node(val);
		Node last  = head;
		if(head == null) {
			node.prev = null;
			head = node;
		}
		while(last.next != null) {
			last = last.next;
		}
		last.next = node;
		node.prev = last;
	}
	public void insertAfter(int after, int val) {
		Node p = find(after);
		if(p == null) {
			return;
		}
		Node node = new Node(val);
		node.next = p.next;
		p.next = node;
		node.prev = p;
		if(node.next != null) {
			node.next.prev = node;
		}
	}
	public Node find(int val) {
		Node node = head;
		while(node != null) {
			if(node.val == val) {
				return node;
			}
			node = node.next;			
		}
		return null;
	}
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
		System.out.println("END");
	}
}
