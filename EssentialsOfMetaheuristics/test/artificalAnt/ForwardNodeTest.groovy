package artificalAnt

import spock.lang.Specification;

class ForwardNodeTest extends Specification{
	def forward = new ForwardNode()
	def ant1 = new Ant()
	def board1 = new TrailBoard()
	
	def "check board"(){
		when:		
		board1.initialize(15)
		
		then:
		board1.size() == 15
		board1.lookAtCoordinate(1,0) == 1
	}
	
	def "go forward"(){
		when:
		board1.initialize(15)
		forward.moveForward(ant1, board1)
		
		then:
		ant1.pellets == 1
		ant1.steps == 1
		ant1.getCoordinate() == [0, 1]
		board1.lookAtCoordinate(1,0) == 0
		
		when:
		forward.moveForward(ant1, board1)
		
		then:
		ant1.pellets == 2
		ant1.steps == 2
		ant1.getCoordinate() == [0, 2]
		board1.lookAtCoordinate(2,0) == 0
		
	}
	
	
	

}
