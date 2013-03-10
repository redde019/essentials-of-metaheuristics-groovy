package artificalAnt

class antRunner {
	def ifFood = new IfFoodAheadNode()
	def Do = new DoNode()
	def left = new LeftNode()
	def right = new RightNode()
	def forward = new ForwardNode()
	def funcSet = [ifFood,Do,left,right,forward]
	def ant = new Ant()
	def board = new AntBoard()
 def superTree = new GPTree()
}
