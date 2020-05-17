import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.image.*;

class Pixel {
	private int red;
	private int green;
	private int blue;
	int width = 500;
	int height = 500;
	public Color [][] image = new Color [width][height];

	public Pixel(Scanner s, int [][] img) {

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++){
				red = s.nextInt();
				green = s.nextInt();
				blue = s.nextInt();
				int sum = red + green + blue;
				img [i][j] = (sum);

				//Makes them colors objects
				Color c = new Color (red, green, blue);
				image [i][j] = c;

				//Gets the r, g, b values and converts to gray
				red = c.getRed();
				green = c.getGreen();
				blue = c.getBlue();
				int gray = (red + green + blue) / 3;
				Color grayColor = new Color (gray, gray, gray);
				image [i][j] = grayColor;
			}
		}
	}
}

public class Converter {
	public static void main(String args[]) throws FileNotFoundException {
		int width = 500;
		int height = 500;
		int[][] img = new int [width][height];

		try{
			File filename = new File(args[0]);
			Scanner in = new Scanner(filename);

			//Reads past the header
			in.nextLine();
			in.nextLine();
			in.nextLine();
			
			//Loads PPM into array
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					img [i][j] = in.nextInt();
				}
			}

			Pixel p = new Pixel(in, img);
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} 
	}
}
