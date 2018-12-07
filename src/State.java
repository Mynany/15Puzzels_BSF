// created by Yumeng Yang on 9/27/2018

class State {
	int[][] matrix;
	int moveNums;
	int nodesExp;
	String move;
	public State(int[][] matrix) {
		this.matrix = matrix;
		moveNums = 0;
		nodesExp = 0;
		move = "";
	}
	public State(int[][] matrix, int moveNums, int nodesExp, String move, String nextMove) {
		this.matrix = matrix;
		this.moveNums = moveNums + 1;
		this.nodesExp = nodesExp + 1;
		this.move = move + nextMove;
	}

	public int getMoveNums() {
		return this.moveNums;
	}

	public int getNodesExp() {
		return this.nodesExp;
	}

	public String getMove() {
		return this.move;
	}
	
	public int[] getZero() {
		int[] result = {0, 0};
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				if (this.matrix[i][j] == 0) {
					result[0] = i;
					result[1] = j; 
					return result;
				}
			}
		}
		return result;
	}

	public int[][] getMatrix(){
		return this.matrix;
	}

	public String getUniq(){
		String str = "";
		for(int i = 0; i < this.matrix.length; i++) {
			for(int j = 0; j < this.matrix[0].length; j++) {
				str = str + Integer.toString(this.matrix[i][j]);
			}
		}
		return str;
	}
	// @Override
	// public boolean equals(Object obj) {
	// 	System.out.println("equals?");
	// 	if (obj == this) return true;
 //        if (!(obj instanceof State)) {
 //            return false;
 //        }
	// 	State state = (State) obj;
	// 	for(int i = 0; i < matrix.length; i++) {
	// 		for(int j = 0; j < matrix[0].length; j++) {
	// 			if(matrix[i][j] != state.matrix[i][j])
	// 				return false;
	// 		}
	// 	}
	// 	return true;
	// }
	// @Override
	// public int hashCode(){
	// 	System.out.println("equals?");
	// 	int sum = 0;
	// 	for(int i = 0; i < this.matrix.length; i++) {
	// 		for(int j = 0; j < this.matrix[0].length; j++) {
	// 			sum = (i + j) * matrix[i][j] + sum;
	// 		}
	// 	}
	// 	return sum;
	// }
	public void printInfo(){
		System.out.println("Moves: " + move);
	}
	public boolean isOver() {	
		for(int i = 0; i < this.matrix.length; i++) {
			for(int j = 0; j < this.matrix[0].length - 1; j++) {
				if(this.matrix[i][j] != i * this.matrix.length + j + 1) {
					return false;
				}
			}
		}			

		if(this.matrix[3][3] == 0) {
			return true;
		}
		return false;
	}  
}