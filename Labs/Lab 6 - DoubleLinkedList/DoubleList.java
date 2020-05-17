// DoubleList.java

class DoubleList<Type> {
    // a Node of the list
    private class Node {
        public Type data;
        public Node next;
        public Node prev;
    }

    // we store the head and tail
    private Node head;
    private Node tail;

    // the list starts empty
    public DoubleList() {
        head = null;
        tail = null;
    }

    // add a new value at the start
    public void addStart(Type value) {
        Node newNode = new Node();
        newNode.next = head;
        newNode.prev = null;
        newNode.data = value;

        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }

        head = newNode;
    }

    // add a new value to the end
    public void addEnd(Type value) {
        Node newNode = new Node();
        newNode.prev = tail;
        newNode.data = value;
        newNode.next = null;

        // set node before to point to new node, or head
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }

        tail = newNode;
    }

	//returns the element at a given index
	public Type get(int index) {
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

    // print the list from start to finsih
    public void printForwards() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // call the helper function to print backwards starting from the head
    public void printBackwards() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        } 
    }

    // remove a node from the list by value
    public void remove(Type value) {
        // find the node with our number
        Node current = head;
        while (current != null) {
            // if the value was found
            if (current.data == value) {
                // if the previous is null, we are removing head!
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else {
                    // point previous's next pointer at the one after current
                    current.prev.next = current.next;

                    // also point next's previous pointer to current's prev
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    } else {
                        tail = current.prev;
                    }
                }
            }

            // move on to the next one
            current = current.next;
        }
    }

	//remove first not from list
	public void removeFirst() {
		Node current = head;
		if (current.prev == null){
			head = current.next;
		}
		if (current.next != null) {
			current.next.prev = current.prev;
		}

	}

	//removes last node from list
	public void removeLast() {
		Node current = tail;
		if (current.next == null) {
			current.prev.next = current.next;
		}
		if (current.prev != null) {
			tail = current.prev;
		}
	}

	//clears the double linked list
	public void clear() {
		Node current = head;
		head = current.prev;

		while (current != null){
			if(current.next == null) {
				tail = current.next;
			}
		current = current.next;
		}
	}

}

