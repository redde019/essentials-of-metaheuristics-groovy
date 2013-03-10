package artificalAnt

class Ant {
	
	def x = 0
	def y = 0
	
	def steps
	def pellets
	def direction = 2
	
	def coordinateChange(newX, newY){
		x = newX
		y = newY
	}
	def getCoordinate(){
		return [x, y]
	}
	
	def getDirection(){
		return direction
		
	}
	
	def setDirection(number){
		direction = number
	}

}
