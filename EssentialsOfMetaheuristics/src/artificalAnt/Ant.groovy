package artificalAnt

class Ant {
	
	def x = 0
	def y = 0
	
	def steps = 0
	def pellets = 0
	def direction = 2
	
	def setCoordinate(newX, newY){
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
		if(number < 1 || number > 4){
			return
		} 
		else{
		direction = number
		}
	}

}
