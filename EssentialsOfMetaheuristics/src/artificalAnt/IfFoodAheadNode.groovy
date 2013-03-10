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
		if(ant.getDirection() == 1){
			return 1 == antBoard[temp[1]][temp[2]++]
		}
		else if(ant.getDirection() == 2){
			return 1 == antBoard[temp[1]++][temp[2]]
		}
		else if(ant.getDirection() == 3){
			return 1 == antBoard[temp[1]][temp[2]--]
		}
		else if(ant.getDirection() == 4){
			return 1 == antBoard[temp[1]--][temp[2]]
		}
	}
	
}
