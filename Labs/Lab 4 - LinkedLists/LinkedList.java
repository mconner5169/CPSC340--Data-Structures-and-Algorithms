// LinkedList.java

public class LinkedList<Type> {
    // a Node of the list
    private class Node {
        public Type data;
        public Node next;
    }

    // the head of the list is first node
    private Node head;

    // the list starts empty
    public LinkedList() {
        head = null;
    }

    // add an item to the list
    public void add(Type item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        head = newNode;
    }

    // print the list from start to finsih
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //print the number of items in the list
    public int count() {
	    int count = 0;
	    Node current = head;
	    while (current != null) {
		    count++;
		    current = current.next;
	    }
	    return count;
    }
}
