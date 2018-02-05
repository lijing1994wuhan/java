package dataStructure;


public class DoubleLinkedList2 {
	private static class Node { // LinkedList.Node
     int val;
	 Node next;
	 Node prev;
	}
	
	private Node head, tail;
	
	public DoubleLinkedList2() {
		head = null;
		tail = null;
	}
	
	public void addStart(int v) {
		Node temp = new Node();
		if(head == null) {
			temp.val = v;
			temp.next = head;
			temp.prev = null;
			head = temp;
			tail = temp;
		}
		else {
			temp.val = v;
			temp.next = head;
			temp.prev = null;
			head = temp;
		}
	}


	public void addEnd(int v) {
		Node temp = new Node();
		if(tail == null) {
			temp.val = v;
			temp.next = null;
			temp.prev = null;
			head = temp;
			tail = temp;
		}
		else {
			temp.val = v;
			temp.next = null;
			temp.prev = tail;
			tail = temp;
		}
	}
	public void insert(int i, int v) {
		Node p = head;
		while(i > 0) {
			if(p ==null)
				return;
			p = p.next;
			i--;
		}
		Node temp = new Node();
		temp.val = v;
		temp.next = p.next;
		temp.prev = p;
		p.next = temp;
	}
	
	public void removeEnd() {
		if(tail == null)
			return;
		tail = tail.prev;
	}
	public void removeStart() {
		if(head ==null)
			return;
		head = head.next;
	}


	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("[");
		for(Node p = head; p !=null; p = p.next)
			b.append(p.val).append(",");
		b.append("]");
		return b.toString();
	}

	public int size() {
		int count = 0;
		for (Node p = head; p != null; p = p.next) //O(n)
			count++;
		return count;
	}

	public int get(int i) {
		Node temp = head;
		for(int j = 0; j < i; j++)
			temp = temp.next;
		return temp.val;
	}

	public static void main(String[]args) {
		LinkedList2 a = new LinkedList2();
		for (int i = 0; i < 10; i++)
			a.addStart(i);
		System.out.println(a);
		for (int i = 0; i < 10; i++)
			a.addEnd(i);
		System.out.println(a);
		a.removeStart();
		System.out.println(a);
		a.removeEnd();
		System.out.println(a);
		a.insert(2, 200);
		System.out.println(a);
		System.out.println(a.get(2));
	}
}	