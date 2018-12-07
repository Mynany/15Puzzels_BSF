// created by Yumeng Yang on 9/27/2018

import java.util.Scanner;
class Puzzle {
	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// String inputString = scan.next().toString();
		// String stringArray[] = inputString.split(" ");
		// int input[][] = new int[4][4];
		// for(int i = 0; i < 4; i++) {
		// 	for(int j = 0; j < 4; j++) {
		// 		input[i][j] = Integer.parseInt(stringArray[i * 4 + j]);
		// 	}
		// }
		final long startTime = System.nanoTime();
				// int[][] matrix = {{5,2,4,8},{10,3,11,14},{6,0,9,12},{13,1,15,7}};
		// int[][] matrix = {{5,2,4,8},{10,3,11,14},{6,0,9,12},{13,1,15,7}};
		// int[][] matrix = {{5,2,4,8},{10,3,11,14},{6,0,9,12},{13,1,15,7}};

		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15}};
		// int[][] matrix = {{1,0,2,4},{5,7,3,8},{9,6,11,12},{13,10,14,15}};
		FifteenPuzzel newPuzzel = new FifteenPuzzel();
		newPuzzel.solution(matrix);
		final long duration = System.nanoTime() - startTime;
		System.out.println("Time Taken: " + duration/1000000 + "ms");
	}
}