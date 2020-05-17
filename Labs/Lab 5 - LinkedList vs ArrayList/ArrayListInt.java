import java.util.ArrayList;

public class ArrayListInt {
	public static void main(String[] args) {
		int value = 5000000;
		ArrayList<Integer> list = new ArrayList<Integer>(value);

		//Adds numbers to end of list
		for (int i = 1; i < (value + 1); i++) {
			list.add(i);
		}
	}
}
