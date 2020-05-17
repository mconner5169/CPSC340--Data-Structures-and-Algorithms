// Main.java
// test the BigInt class

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// create a BigInt with the default zero value
		BigInt zero = new BigInt();
		System.out.println(zero);

		// test the other constructors
		BigInt a = new BigInt(123456);
		BigInt b = new BigInt("123456789012345678901234567890123456789012345678901234567890");
		System.out.println(a);
		System.out.println(b);

		// test addition
		BigInt sum = a.add(b);
		System.out.println("Sum = " + sum);

		// read in to BigInts
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two values:");
		BigInt c = new BigInt(in.next());
		BigInt d = new BigInt(in.next());
		// test comparisons
		        int result = c.compareTo(d);
		       if (result < 0) {
		            System.out.println(c + " < " + d);
		        } else if (result > 0) {
		            System.out.println(c + " > " + d);
		       } else {
		            System.out.println(c + " = " + d);
		       }

	//	show the sum
			System.out.println(c + " + " + d + " = " + c.add(d));
	}
}

