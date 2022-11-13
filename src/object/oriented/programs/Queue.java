package object.oriented.programs;

public class Queue<T> {

	Node head;
	
	class Node {
		T data;
		Node ref;
		
		Node(T data) {
			this.data = data;
		}
	}
	
	void enQueue(T data) {
		Node newNode = new Node(data);
		if (head == null)
			head = newNode;
		else {
			Node temp = head;
			while (temp.ref != null)
				temp = temp.ref;
			temp.ref = newNode;
		}
	}
}