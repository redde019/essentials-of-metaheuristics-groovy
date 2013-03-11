package artificalAnt

class AntBoard {
	public static void main(String [] args) {
		int [][] antBoard = new int[32][32]
		initialize(antBoard)

		printAntBoard(antBoard)
		println antBoard.size()

	}
	
	def size(){
		antBoard.size
	}



	public static void initialize(int [][] antBoard){
		def tempSize = antBoard.size()
		for (int i = 0; i < tempSize; i++){
			for(int j = 0; j < tempSize; j++){
				antBoard[i][j] = 0
			}
		}
		setPellets(antBoard)
	}



	private static void setPellets(int [][] antBoard){
		def tempSize = antBoard.size()
		Random rand = new Random()
		int k = 0
		for(k = 0; k < 100; k++){
			int place1 = rand.nextInt(tempSize)
			int place2 = rand.nextInt(tempSize)
			if(antBoard[place1][place2] == 1){
				k--
			}
			else{
				antBoard[place1][place2] = 1
			}
		}
	}

	public static void printAntBoard(int[][] antBoard) {
		def tempSize = antBoard.size()
		for(int i = 0; i < tempSize; i++) {
			for(int j = 0; j < tempSize; j++) {
				print (antBoard [i] [j])
			}
			println()
		}
	}

}
