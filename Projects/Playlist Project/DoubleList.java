// DoubleList.java
import java.util.Random;

class DoubleList<Song> {
	// a Node of the list
	private class Node {
		public Song data;
		public Node next;
		public Node prev;
	}

	//We store the head and tail
	private Node head;
	private Node tail;

	//The list starts empty
	public DoubleList() {
		head = null;
		tail = null;
	}

	//Add a new value at the start
	public void addStart(Song value) {
		Node newNode = new Node();
		newNode.data = value;
		newNode.next = head;
		newNode.prev = null;

		if (head != null) {
			head.prev = newNode;
		} else {
			tail = newNode;
		}

		head = newNode;
	}

	//Add a new value to the end
	public void addEnd(Song value) {
		Node newNode = new Node();
		newNode.data = value;
		newNode.prev = tail;
		newNode.next = null;

		//Set node before to point to new node, or head
		if (tail != null) {
			tail.next = newNode;
		} else {
			head = newNode;
		}

		tail = newNode;
	}

	//Print the list from start to finsih
	public void printForwards() {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	//Print the list from finish to start
	public void printBackwards() {
		Node current = tail;
		while (current != null) {
			System.out.println(current.data);
			current = current.prev;
		} 
	}

	//Remove a node from the list by value
	public void remove(Song value) {
		Node current = head;
		while (current != null) {
			//if we found the node
			if (current.data == value) {

				if (current.prev != null) {
					current.prev.next = current.next;
				} else {
					head = current.next;
				}

				if (current.next != null) {
					current.next.prev = current.prev;
				} else {
					tail = current.prev;
				}

				break;
			}

			//move on to the next one
			current = current.next;
		}
	}

	//Rearranges the nodes in the list
	public void rearrange(){
		//Gets the number of nodes in the list
		Node current = head;
		int totalSize = 0;
		while (current != null) {
			totalSize++;
			current = current.next;
		}

		//Resets current to head
		current = head;
		
		//Random number object
		Random r = new Random();
		
		for (int i = totalSize; i > 0; i--) {
			//picks a number from 0 to i
			int j = r.nextInt(i);
			
			//Copies data to temp, removes it, then adds it to end list
			Node temp = new Node();
			temp.data = get(j);
			remove(temp.data);
			addEnd(temp.data);
			System.out.println(temp.data);
		}
}

	//Counts the size of list
	public int size() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	//Getting the Song data from a nade at desired index
	public Song get(int index) {
		Node current = head;
		for (int i = 0; i <= index - 1; i++) {
			if (current != null) {
				current = current.next;
			}
			else {
				current.data = null;
			}
		}
		return current.data;
	}

	public boolean contains(Song value) {
		boolean decision = false;
		Node current = head;

		for (int i = 0; i <= 4; i++) {
			if (current.data != value) {
				decision = false;
			}
			else if (current.data == value) {
				decision = true;
				break;
			}
			current = current.next;
		}
		return decision;
	}
}
