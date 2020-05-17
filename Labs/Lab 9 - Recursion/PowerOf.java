import java.util.*;

public class PowerOf {
	private static Scanner s = new Scanner(System.in);

	public static int getNumbers() {
		System.out.print("Enter a positive number: ");
		int temp = s.nextInt();
		if (temp <= 0) {
			System.out.println("I said a positive number!");
			return getNumbers();
		}
		return temp;
	}

	public static int power(int base, int expo) {
		if (expo == 0) {
			return 1;
		}
		//If expo is odd
		if(expo % 2 == 1) {
			return (base * power(base, expo/2) * power(base, expo/2));
		}
		else {
			return (power(base, expo/2)* power(base, expo/2));
		}		
	}

	public static void main(String args[]) {
		int base = 0;
		int expo = 0;
		base = getNumbers();
		expo = getNumbers();
		System.out.println(power(base, expo));
	}
}
