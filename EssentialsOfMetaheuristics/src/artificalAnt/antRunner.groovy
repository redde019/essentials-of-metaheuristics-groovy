package artificalAnt

class antRunner {
	
	public static void main(String [] args) {
		def ifFood = new IfFoodAheadNode()
		def Do = new DoNode()
		def left = new LeftNode()
		def right = new RightNode()
		def forward = new ForwardNode()
		def superTree = new GPTree()
		superTree.functionSet = [ifFood,Do,left,right,forward]
		def ant = new Ant()
		def board = new TrailBoard()
		superTree.runGPTree()
		superTree.runEverything(superTree.head)

		
		
	}
}
