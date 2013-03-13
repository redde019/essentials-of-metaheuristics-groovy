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
		def tempSize = antBoard.size() 		
		if(ant.getDirection() == 1){
			if(temp[1]++ >= tempSize){
				return antboard.lookAtCoordinate(temp[0], tempSize-temp[1]) == 1
			}
			else{
				return antboard.lookAtCoordinate(temp[0], temp[1]++) == 1 
			}
		}
		else if(ant.getDirection() == 2){
			if(temp[0]++ >= tempSize){
				return antboard.lookAtCoordinate(tempSize-temp[0], temp[1]) == 1
			}
			else{
				return antboard.lookAtCoordinate(temp[0]++, temp[1]) == 1
			}
		}
		else if(ant.getDirection() == 3){
			return antboard.lookAtCoordinate(temp[0], temp[1]-1) == 1
		}
		else if(ant.getDirection() == 4){
			return antboard.lookAtCoordinate(temp[0]-1, temp[1]) == 1
		}
	}
	
}
