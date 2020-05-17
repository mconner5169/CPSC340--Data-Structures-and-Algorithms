import java.util.*;

public class main {

	public static void main(String[] args) {

		int element;
		int value;
		int totalValue = 0;
		double average;

		Scanner stdin = new Scanner(System.in);

		System.out.print("Enter number of elements: ");
		element = stdin.nextInt();

		for (int i = 0; i < element; ++i) {
		       System.out.print("Enter value: ");
			value = stdin.nextInt();
			totalValue = totalValue + value;
		}

		average = (double) totalValue/element;
		System.out.println("Average: " + average);

		stdin.close();
	}
}
