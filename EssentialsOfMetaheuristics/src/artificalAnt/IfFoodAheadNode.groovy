package artificalAnt

class IfFoodAheadNode {
	
	def ifFoodAheadNode
	def child1
	def child2
	
	def numbChildren(){
		return 2
	}
	
	def lookForFood(ant, antBoard){
		def temp = ant.getCoordinate()
		def tempY = temp[0]
		def tempX = temp[1]
		def tempSize = antBoard.size() 		
		if(ant.getDirection() == 1){
			if(temp[0]++ >= tempSize){
				return antBoard.lookAtCoordinate(tempX, tempSize-tempY) == 1
			}
			else{
				return antBoard.lookAtCoordinate(tempX, tempY+1) == 1 
			}
		}
		else if(ant.getDirection() == 2){
			if(temp[1]++ >= tempSize){
				return antBoard.lookAtCoordinate(tempSize-tempX, tempY) == 1
			}
			else{
				return antBoard.lookAtCoordinate(tempX+1, tempY) == 1
			}
		}
		else if(ant.getDirection() == 3){
			return antBoard.lookAtCoordinate(tempX, tempY-1) == 1
		}
		else if(ant.getDirection() == 4){
			return antBoard.lookAtCoordinate(tempX-1, tempY) == 1
		}
	}
	
}
