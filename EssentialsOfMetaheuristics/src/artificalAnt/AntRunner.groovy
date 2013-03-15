package artificalAnt

class AntRunner {
	
	public static void main(String [] args) {
		

		def superTree = new GPTree()
		
		superTree.runGPTree()
		println superTree.size + " kittens"
		
		
		superTree.run()
		println superTree.ant.getPellets()+" pellets"
		superTree.printTree(superTree.head)


	}
}
