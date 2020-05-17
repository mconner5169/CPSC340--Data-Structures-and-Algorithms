import java.util.ArrayList;

public class ArrayListBegin {
	public static void main(String args[]) {
		int value = 500000;
		int index = 500000;
		ArrayList<Integer> list = new ArrayList<Integer>(value);

		for (int i = 1; i < (value + 1); i++) {
			list.add(i);
		}
		//Adds numbers to end of list
		for (int i = 500000; i > 0; i--) {
			list.add(index, i);
			index = index - 1;
		}
	}
}
