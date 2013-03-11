package artificalAnt

class AntRunner {
	
	public static void main(String [] args) {
		
		def ant = new Ant()
		def board = new AntBoard()
		board.initialize(int [][])
		def boards = board.makeBoard()
		def superTree = new GPTree(ant:ant,antBoard: board)
		def forward = new ForwardNode()
		forward.moveForward(ant, board)
		//superTree.runGPTree()
		//superTree.printTree(superTree.head)
		//superTree.runEverything(superTree.head)
		

		
		
	}
}
