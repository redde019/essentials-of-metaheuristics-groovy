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
				return 1 == antBoard[temp[0]][tempSize-temp[1]]
			}
			else{
				return 1 == antBoard[temp[0]][temp[1]++]
			}
		}
		else if(ant.getDirection() == 2){
			if(temp[0]++ >= tempSize){
				return 1 == antBoard[tempSize-temp[0]][temp[1]]
			}
			else{
				return 1 == antBoard[temp[0]++][temp[1]]
			}
		}
		else if(ant.getDirection() == 3){
			return 1 == antBoard[temp[0]][temp[1]--]
		}
		else if(ant.getDirection() == 4){
			return 1 == antBoard[temp[0]--][temp[1]]
		}
	}
	
}
