package artificalAnt

class RightNode {
	
	def rightNode
	
	def numbChildren(){
		return 0
		
	}
	
	def turn(ant){
		ant.setDirection(ant.getDirection()++)
	}
}
