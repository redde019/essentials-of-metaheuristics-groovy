package artificalAnt

class ForwardNode {
	
	def moveForward(ant, antBoard){
		ant.pellets++
		ant.steps++
		
		def tempCoord = ant.getCoordinate()
		def temp1 = tempCoord[0]
		def temp2 = tempCoord[1]
		def tempSize = antBoard.size()
		
		if(ant.getDirection() == 1){
			if(tempCoord[1]++ >= tempSize){
				ant.setCoordinate(tempCoord[0], tempSize-tempCoord[1])
				antBoard.removePellet(temp2, tempSize-temp1) // Trying to figure out why it is breaking
			}
			else{
			ant.setCoordinate(tempCoord[0],tempCoord[1]++)
			antBoard.removePellet(temp2, temp1+1)
			}
		}
		if(ant.getDirection() == 2){
			if(tempCoord[1]++ >= tempSize){
				ant.setCoordinate(tempSize-tempCoord[0], tempCoord[1])
				antBoard.removePellet(tempSize-temp2, temp1)
			}
			else{
			ant.setCoordinate(tempCoord[1]++, tempCoord[0])
			antBoard.removePellet(temp2+1, temp1)
			}
		}
		else if(ant.getDirection() == 3){
			ant.setCoordinate(tempCoord[0],tempCoord[1]--)
			antBoard.removePellet(temp2, temp1-1)
		}
		else if(ant.getDirection() == 4){
			ant.setCoordinate(tempCoord[0]--,tempCoord[1])
			antBoard.removePellet(temp2-1, temp1)
		}
		
	}
	def numbChildren(){
		return 0
	}
}
