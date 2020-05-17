import java.util.LinkedList;

public class LinkedListBegin {
	public static void main(String args[]) {
		int value = 500000;
		LinkedList<Integer> list = new LinkedList<Integer>();

		//Adds numbers to end of list
		for (int i = 1; i < (value + 1); i ++) {
			list.addLast(i);
		}
	}
}
