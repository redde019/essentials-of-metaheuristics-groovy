package artificalAnt

class ForwardNode {
	def parent
	def moveForward(ant, antBoard){
		ant.pellets++
		ant.steps++
		
		def tempCoord = ant.getCoordinate()
		def tempX = tempCoord[1]
		def tempY = tempCoord[0]
		def tempSize = antBoard.size()
		
		if(ant.getDirection() == 1){
			if(tempY-1 < 0){
				ant.setCoordinate((tempSize-tempY)-1, tempX)
				antBoard.removePellet((tempSize-tempY)-1, tempX) // Trying to figure out why it is breaking
			}
			else{
			ant.setCoordinate(tempY-1, tempX )
			antBoard.removePellet(tempY-1, tempX)
			}
			
		}
		
		else if(ant.getDirection() == 2){
			if(tempX+1 >= tempSize){
				ant.setCoordinate(tempY, tempSize-tempX)
				antBoard.removePellet(tempY, tempSize-tempX)
			}
			else{
			ant.setCoordinate(tempY, tempX+1)
			antBoard.removePellet(tempY, tempX+1)
			}
			
		}
		
		else if(ant.getDirection() == 3){
			if(tempY+1 > tempSize-1){
				def result = (tempSize-tempY)-1
				
				ant.setCoordinate(result, tempX)
				antBoard.removePellet(result, tempX)
			}
			else{
			ant.setCoordinate(tempY+1,tempX)
			antBoard.removePellet(tempY+1,tempX)
			}
			
		}
		
		else if(ant.getDirection() == 4){
			if(tempX-1 < 0){
				println tempX-1
				ant.setCoordinate(tempY,tempSize+tempX-1)
				antBoard.removePellet(tempY, tempSize+tempX-1)
				println tempX +" "+ tempY
			} 
			else{
			ant.setCoordinate(tempY, tempX-1)
			antBoard.removePellet(tempY, tempX-1)
			
			}
		}
		
	}
	
	def numbChildren(){
		return 0
	}
}
