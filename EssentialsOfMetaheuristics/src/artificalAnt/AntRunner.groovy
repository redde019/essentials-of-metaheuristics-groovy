package artificalAnt

class AntRunner {
	
	public static void main(String [] args) {
		
		def ant = new Ant()
		def board = new TrailBoard()
		board.initialize(15)
		def superTree = new GPTree(ant:ant,antBoard: board)
		
		superTree.runGPTree()
		
		superTree.printChildren(superTree.head)
		println "Magic Unicorns"
		println superTree.head 
		println "Magic Unicorns"
		println superTree.size + " kittens"
		
		
		superTree.runEverything(superTree.head)
		println ant.getPellets()+" pellets"
		superTree.printTree(superTree.head)
		println superTree.counter

	}
}
