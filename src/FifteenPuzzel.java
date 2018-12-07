// created by Yumeng Yang on 9/27/2018

import java.util.*;
public class FifteenPuzzel {
	public void solution(int[][] matrix) {
		if(matrix.length != 4){
			System.out.println("solution cannot be found!!");
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(matrix[i].length != 4) {
				System.out.println("solution cannot be found!!");
				return;
			}
		}
		State initState = new State(matrix);
		int[] directionX = {0, 0, 1, -1};
		int[] directionY = {1, -1, 0, 0};
		Queue<State> queue = new LinkedList<>();
		HashSet<String> hashset = new HashSet<>();
		queue.add(initState);
		hashset.add(initState.getUniq());
		int round = 1;
		while(!queue.isEmpty()) {
			State currState = queue.poll();
			int[][] currMatrix = currState.getMatrix();

			if(currState.isOver()) {
				System.out.println("Memory used: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "KB");
				System.out.println("Numbers of Nodes expanded: " + round);
				currState.printInfo();
				return; 
			}
			// if(isOver(currMatrix)) {
			// 	System.out.println("Memory used: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "KB");
			// 	currState.printInfo();
			// 	return; 
			// }
			int[] currZero = currState.getZero();
			for(int i = 0; i < directionY.length; i++) {
				int[] nextZero = new int[2];
				nextZero[0] = currZero[0] + directionX[i];
				nextZero[1] = currZero[1] + directionY[i];
				if(!isBound(matrix, nextZero)) {
					continue;
				}
				round++;
				int[][] nextMatrix = new int[4][4];
				for(int k = 0; k < nextMatrix.length; k++) {
					for(int j = 0; j < nextMatrix[k].length; j++) {
						nextMatrix[k][j] = currMatrix[k][j];
				}
			}
				swap(nextMatrix, currZero, nextZero);
				String nextMove = "";
				switch(i) {
					case 0: 
						nextMove = "R";
						break;
					case 1:
						nextMove = "L";
						break;
					case 2:
						nextMove = "D";
						break;
					case 3:
						nextMove = "U";
						break;
				}
				// System.out.println(round + nextMove);
				State nextState = new State(nextMatrix, currState.getMoveNums(), currState.getNodesExp(), currState.getMove(), nextMove);
				if(hashset.contains(nextState.getUniq())) {
					continue;
				}
				hashset.add(nextState.getUniq());
				queue.add(nextState);						
			}
		}
		System.out.println("solution cannot be found!!");
	}

	private void swap(int[][] matrix, int[] currZero, int[] nextZero) {
		int temp = matrix[currZero[0]][currZero[1]];
		matrix[currZero[0]][currZero[1]] = matrix[nextZero[0]][nextZero[1]];
		matrix[nextZero[0]][nextZero[1]] = temp;
	}

	private boolean isBound(int[][] matrix, int[] nextZero) {
		return nextZero[0] >= 0 && nextZero[0] < matrix.length && nextZero[1] >= 0 && nextZero[1] < matrix[0].length;
	}

	// private boolean isOver(int[][] matrix) {
	// 	for(int i = 0; i < matrix.length; i++) {
	// 		for(int j = 0; j < matrix[0].length - 1; j++) {
	// 			if(matrix[i][j] != i * matrix.length + j + 1)
	// 				return false;
	// 		}
	// 	}
	// 	if(matrix[3][3] == 0) {
	// 		return true;
	// 	}
	// 	return false;
	// }    
}