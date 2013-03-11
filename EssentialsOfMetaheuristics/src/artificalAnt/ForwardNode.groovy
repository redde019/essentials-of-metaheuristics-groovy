package artificalAnt

class ForwardNode {
	def forwardNode
	
	def forwardNode(number){
		forwardNode = number
	}
	def moveForward(ant, antBoard){
		ant.pellets++
		ant.steps++
		def tempCoord = ant.getCoordinate()
		def tempSize = antBoard.size()	
		if(ant.getDirection() == 1){
			if(tempCoord[2]++ >= tempSize){
				ant.setCoordinate(tempCoord[1], tempSize-tempCoord[2])
				antBoard[tempCoord[1]][tempSize-tempCoord[2]] = 0
			}
			else{
			ant.setCoordinate(tempCoord[1],tempCoord[2]++)
			antBoard[tempCoord[1]][tempCoord[2]++] = 0
			}
		}
		else if(ant.getDirection() == 2){
			if(tempCoord[1]++ >= tempSize){
				ant.setCoordinate(tempSize-tempCoord[1], tempCoord[2])
				antBoard[tempSize-tempCoord[1]][tempCoord[2]] = 0
			}
			else{
			ant.setCoordinate(tempCoord[1]++,tempCoord[2])
			antBoard[tempCoord[1]++][tempCoord[2]] = 0
			}
		}
		else if(ant.getDirection() == 3){
			ant.setCoordinate(tempCoord[1],tempCoord[2]--)
			antBoard[tempCoord[1]][tempCoord[2]--] = 0
		}
		else if(ant.getDirection() == 4){
			ant.setCoordinate(tempCoord[1]--,tempCoord[2])
			antBoard[tempCoord[1]--][tempCoord[2]] = 0
		}
		
	}
	def numbChildren(){
		return 0
	}
}
