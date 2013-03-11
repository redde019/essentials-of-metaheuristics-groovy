package artificalAnt

class TrailBoard {
	public static void main(String [] args) {
		int [][] antBoard = new int[32][32]
		initialize(antBoard)

		printAntBoard(antBoard)

	}



	public static void initialize(int [][] antBoard){
		for (int i = 0; i < 32; i++){
			for(int j = 0; j < 32; j++){
				antBoard[i][j] = 0
			}
		}
		setPellets(antBoard)
	}



	private static void setPellets(int [][] antBoard){
		antBoard[0][1] = 1
		antBoard[0][2] = 1
		antBoard[0][3] = 1
		antBoard[1][3] = 1
		antBoard[1][4] = 1
		antBoard[1][5] = 1
		antBoard[1][6] = 1
		antBoard[2][6] = 1
		antBoard[3][6] = 1
		antBoard[4][6] = 1
		antBoard[5][6] = 1
		antBoard[5][7] = 1
		antBoard[5][8] = 1
		antBoard[5][9] = 1
		antBoard[5][10] = 1
	}

	public static void printAntBoard(int[][] antBoard) {
		for(int i = 0; i < 32; i++) {
			for(int j = 0; j < 32; j++) {
				print (antBoard [i] [j])
			}
			println()
		}
	}

}


