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
		println antBoard.size()	
		if(ant.getDirection() == 1){
			if(tempCoord[1]++ >= tempSize){
				ant.setCoordinate(tempCoord[0], tempSize-tempCoord[1])
				antBoard.eatPellets(tempCoord[0],tempSize-tempCoord[1])
			}
			else{
			ant.setCoordinate(tempCoord[0],tempCoord[1]++)
			antBoard.eatPellets(tempCoord[0],tempCoord[1]++)
			}
		}
		else if(ant.getDirection() == 2){
			if(tempCoord[0]++ >= tempSize){
				ant.setCoordinate(tempSize-tempCoord[0], tempCoord[1])
				antBoard.eatPellets(tempSize-tempCoord[0],tempCoord[1])
			}
			else{
			ant.setCoordinate(tempCoord[0]++,tempCoord[1])
			antBoard.eatPellets(tempCoord[0]++,tempCoord[1])
			}
		}
		else if(ant.getDirection() == 3){
			ant.setCoordinate(tempCoord[0],tempCoord[1]--)
			antBoard.eatPellets(tempCoord[0],tempCoord[1]--)
		}
		else if(ant.getDirection() == 4){
			ant.setCoordinate(tempCoord[0]--,tempCoord[1])
			antBoard.eatPellets(tempCoord[0]--,tempCoord[1])
		}
		
	}
	def numbChildren(){
		return 0
	}
}
