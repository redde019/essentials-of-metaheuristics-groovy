package artificalAnt

class IfFoodAheadNode {
	
	def ifFoodAheadNode
	def child1
	def child2
	def parent
	def numbChildren(){
		return 2
	}
	def getChild1(){
		return child1
	}
	def getChild2(){
		return child2
	}
	def setChild1(node){
		child1 = node
	}
	def setChild2(node){
		child2 = node
	}
	
	def lookForFood(ant, antBoard){
		def temp = ant.getCoordinate()
		def tempY = temp[0]
		def tempX = temp[1]
		def tempSize = antBoard.size() 		
		if(ant.getDirection() == 1){
			if(temp[0]++ >= tempSize){
				return antBoard.lookAtCoordinate(tempSize-tempY, tempX) == 1
			}
			else{
				return antBoard.lookAtCoordinate(tempY+1, tempX) == 1 
			}
		}
		else if(ant.getDirection() == 2){
			if(temp[1]++ >= tempSize){
				return antBoard.lookAtCoordinate(tempY,tempSize-tempX) == 1
			}
			else{
				return antBoard.lookAtCoordinate( tempY, tempX+1) == 1
			}
		}
		else if(ant.getDirection() == 3){
			return antBoard.lookAtCoordinate(tempY-1, tempX ) == 1
		}
		else if(ant.getDirection() == 4){
			return antBoard.lookAtCoordinate(tempY, tempX-1 ) == 1
		}
	}
	
}
