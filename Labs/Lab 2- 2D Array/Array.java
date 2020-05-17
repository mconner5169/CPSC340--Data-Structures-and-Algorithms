import java.util.*;

public class Array {
	public static void main(String args[]) {
		int row;
		int col;

		if (args.length == 2) {
			//Converts both strings to integers
			row = Integer.parseInt(args[0]);
			col = Integer.parseInt(args[1]);

			//Creats 2D array
			int [][] time = new int [row][col];

			//Load values
			for(int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					time [i][j] = (i + 1) * (j + 1);
				}
			}

			//Prints values
			for(int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.print(time [i][j] + "\t");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("Please enter only two numeric parameters.");
			return;
		}
	}
}
