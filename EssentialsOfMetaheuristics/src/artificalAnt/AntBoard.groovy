package artificalAnt

class AntBoard {
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
		Random rand = new Random()
		int k = 0
		for(k = 0; k < 100; k++){
			int place1 = rand.nextInt(32)
			int place2 = rand.nextInt(32)
			if(antBoard[place1][place2] == 1){
				k--
			}
			else{
				antBoard[place1][place2] = 1
			}
		}
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
