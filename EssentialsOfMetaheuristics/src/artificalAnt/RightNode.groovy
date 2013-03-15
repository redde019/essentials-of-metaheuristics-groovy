package artificalAnt

class RightNode {
	
	def rightNode
	def parent
	def numbChildren(){
		return 0
	}
	
	def turn(ant){
		ant.setDirection(ant.getDirection()+1)
	}
}
