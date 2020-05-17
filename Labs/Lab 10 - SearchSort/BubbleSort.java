// BubbleSort.java

import java.util.Random;
import java.lang.Math;
public class BubbleSort {
    //private static int SIZE = 25;

    public static void bubbleSort(int[] array) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i <= (array.length - 2); i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    changed = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        // put in random numbers
		int SIZE = Integer.parseInt(args[0]);
        int[] nums = new int[SIZE];
        Random rng = new Random();
        for (int i = 0; i < SIZE; i++) {
            nums[i] = rng.nextInt(100);
        }

        // print them
        //System.out.print("Unsorted numbers: ");
        //for (int i = 0; i < SIZE; i++) {
        //    System.out.print(nums[i] + " ");
        //}
        //System.out.print("\n");

        // sort them
        bubbleSort(nums);

        // print them again
        //System.out.println("Sorted numbers: ");
        //for (int i = 0; i < SIZE; i++) {
        //    System.out.print(nums[i] + " ");
        //}
        //System.out.print("\n");
    }
}
