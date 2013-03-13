package artificalAnt

class AntRunner {
	
	public static void main(String [] args) {
		
		def ant = new Ant()
		def board = new TrailBoard()
		board.initialize(15)
		def superTree = new GPTree(ant:ant,antBoard: board)
		
		superTree.runGPTree()
		println superTree.head 
		println "Magic Unicorns"
		
		superTree.runEverything(superTree.head)
		superTree.printTree(superTree.head)

		println superTree.counter
		
	}
}
