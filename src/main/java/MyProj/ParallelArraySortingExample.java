package MyProj;

import java.util.Arrays;

public class ParallelArraySortingExample {

	public static void main(String[] args) {
		// Create an integer array
		int[] arr = { 5, 8, 2, 3, 4, 10, 12, 1 };
		for(int i: arr) {
			System.out.print(i + " ");
		}
		
		Arrays.parallelSort(arr);
		System.out.println("\nArray elements after sorting");
		for(int i: arr) {
			System.out.print(i + " ");
		}

	}

}
