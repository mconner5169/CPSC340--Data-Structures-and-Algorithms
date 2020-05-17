import java.util.Scanner;

class Stack {
	private int top;
	private char[] array;

	public Stack(int size){
		top = -1;
		array = new char [size];
	}

	public void push(char value) {
		array[top + 1] = value;
		top++;
	}

	public char pop() {
		top--;
		return array[top + 1];
	}

	public boolean empty() {
		return top == -1;
	}
}

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] brackets;

		System.out.println("Please enter a series of parenthesis and brackets: ");
		String s = in.next();
		brackets = s.toCharArray();

		//Debugging statement
		for (int i = 0; i < s.length(); i++) {
			System.out.println(brackets[i]);
		}

		Stack b = new Stack(s.length());

		for (int i = 0; i < brackets.length; i++) {
			//Pushing open symbols
			if (brackets[i] == '(') {
				b.push('(');
			}
			else if (brackets[i] == '[') {
				b.push('[');
			}
			//Popping symbols
			if (brackets[i] == ')') {
				if (brackets[i - 1] == '(') { 
					b.pop();
				}
			}
			else if (brackets[i] == ']') {
				if (brackets[i - 1] == '[') {
					b.pop();
				}
			}
		}

		//Checks empty stack
		if (b.empty()) {
			System.out.println("This is a well-formed string.");
		}
		else if (!b.empty()){
			System.out.println("This is NOT a well-formed string.");
		}
	}
}
