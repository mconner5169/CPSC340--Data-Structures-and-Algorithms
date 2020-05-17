import java.util.*;

public class Main2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] brackets;
		Stack<Character> b = new Stack<Character>();

		System.out.println("Please enter a series of parenthesis and brackets: ");
		String s = in.next();
		brackets = s.toCharArray();

		//Stack tracker
		int top = -1;
			
		for (int i = 0; i < brackets.length; i++) {
			//Pushing open symbols
			if (brackets[top + 1] == '(') {
				b.push('(');
				top = top + 1;
			}
			else if (brackets[top + 1] == '[') {
				b.push('[');
				top = top + 1;
			}
			//Popping symbols
			else if (brackets[top] == '(' && brackets[top + 1] == ')') {
				top = top - 1;
				System.out.println(b.pop());
				top = top + 1;
			}
			else if (brackets[top] == '[' && brackets[top + 1] == ']') {
				top = top - 1;
				System.out.println(b.pop());
					top = top + 1;
			}
		}

		//Checks empty stack
		if (b.empty()) {
			System.out.println("This is a well-formed string.");
		}
		else {
			System.out.println("This is NOT a well-formed string.");
		}
	}
}
