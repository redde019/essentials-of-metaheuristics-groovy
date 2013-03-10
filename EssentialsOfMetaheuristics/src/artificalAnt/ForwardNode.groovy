package artificalAnt

class ForwardNode {
	def forwardNode
	
	def forwardNode(number){
		forwardNode = number
	}
	def moveForward(ant, antBoard){
		ant.pellets++
		ant.steps++
		def temp = ant.getCoordinate()		
		if(ant.getDirection() == 1){
			ant.setCoordinate(temp[1],temp[2]++)
			antBoard[temp[1]][temp[2]++] = 0
		}
		else if(ant.getDirection() == 2){
			ant.setCoordinate(temp[1]++,temp[2])
			antBoard[temp[1]++][temp[2]] = 0
		}
		else if(ant.getDirection() == 3){
			ant.setCoordinate(temp[1],temp[2]--)
			antBoard[temp[1]][temp[2]--] = 0
		}
		else if(ant.getDirection() == 4){
			ant.setCoordinate(temp[1]--,temp[2])
			antBoard[temp[1]--][temp[2]] = 0
		}
		
	}
	def numbChildren(){
		return 0
	}
}
