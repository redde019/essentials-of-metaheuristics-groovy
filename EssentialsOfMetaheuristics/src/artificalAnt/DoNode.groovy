package artificalAnt

class DoNode {
	
	def child1
	def child2
	def parent
	def numbChildren(){
		return 2
	}
	def setChild1(node){
		child1 = node
	}
	def setChild2(node){
		child2 = node
	}
	
	def getChild1(){
		return child1
	}
	def getChild2(){
		return child2
	}
	

}
