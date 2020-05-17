import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class SpellCheck {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree<String> BSTdict = new BinarySearchTree<String>();

		try {
			scan = new Scanner(new FileReader(args[0]));
			String line = null;

			//Inserts the strings into the BST
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				BSTdict.insert(line);
			}

			//Closes the file
			scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("No such file exists.");
			System.exit(1);
		}

		//Counts the length of the tree
		int treeCount = BSTdict.count();
		System.out.println("Loaded the words into a tree with height = "+ treeCount);

		Scanner input = new Scanner(System.in);
		String userSentence = input.nextLine();

		//Checks to see if the word contains END 
		while (!userSentence.equals("END")) {
			//Each word is put into the array
			String[] word = userSentence.split(" ");

			//Checks if the word is in the binary tree
			for (String userWord:word) {
				if(BSTdict.search(userWord) == null) {
					System.out.println(userWord + " is spelled wrong!");
				}
			}
			//Reads another user input
			userSentence = input.nextLine();
		}
		//Exits if user types END
		System.exit(1);
	}
}
