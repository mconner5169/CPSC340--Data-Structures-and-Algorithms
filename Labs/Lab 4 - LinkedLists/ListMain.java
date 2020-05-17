public class ListMain {
	public static void main(String args[]) {
		//make a linked list of letters A-Z
		LinkedList<Character> letters = new LinkedList<Character> ();
		for (char c = 'Z'; c >= 'A'; c--) {
			letters.add(c);
		}

		//print them out, and the count
		letters.print();
		System.out.println("There are " + letters.count() + " letters in the alphabet.");
	}
}
