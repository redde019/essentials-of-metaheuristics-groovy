package artificalAnt

class IfFoodAheadNode {
	
	def ifFoodAheadNode
	def child1
	def child2
	def parent
    def childId  // distinguish which child a node is, if its a child1 or child2 node
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
        node.setChildId(1)
	}
	def setChild2(node){
		child2 = node
        node.setChildId(2)
	}
    def setChildId(number){
        childId = number
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
