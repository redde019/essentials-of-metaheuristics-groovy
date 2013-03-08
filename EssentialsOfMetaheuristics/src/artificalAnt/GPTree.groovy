package artificalAnt

class GPTree {
	
	def doNode = new DoNode(0, 0) 
	
	def ifFoodAhead(ant, leftChild, rightChild, forwardChild) {
		if(forwardChild == false){
			if (leftChild == false){
				if(rightChild == false){
					
				}
				else{
					def newX = ant.x
					def newY = ant.y
					def tempAnt = new Ant(x: newX++, y: newY++)
				}
				
			}
			ifFoodAhead()
		}
		
	}
	
	def leftChild
	def rightChild
	
	def GPTree(){
		
	}
	

}
