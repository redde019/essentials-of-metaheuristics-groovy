package artificalAnt

class LeftNode {
	
	def leftNode
	def parent
	def numbChildren(){
		return 0
	}
	
	def turn(ant){
		ant.setDirection(ant.getDirection()-1)
	}

}
