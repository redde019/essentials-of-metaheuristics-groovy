package artificalAnt

class AntRunner {
	
	public static void main(String [] args) {
		
		def ant = new Ant()
		def board = new TrailBoard()
		board.initialize(15)
		def superTree = new GPTree(ant:ant,antBoard: board)
		superTree.runGPTree()
		superTree.printTree(superTree.head)
		superTree.runEverything(superTree.head)
		

		
		
	}
}
