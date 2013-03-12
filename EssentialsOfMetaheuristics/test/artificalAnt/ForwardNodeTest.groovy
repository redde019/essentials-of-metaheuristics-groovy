package artificalAnt

import spock.lang.Specification;

class ForwardNodeTest extends Specification{
	def forward = new ForwardNode()
	def ant1 = new Ant()
	def board1 = new TrailBoard()
	
	def "check board"(){
		when:		
		board1.initialize(32)
		
		then:
		board1.size() == 32
	}
	
	def "go forward"(){
		when:
		board1.initialize(32)
		forward.moveForward(ant1, board1)
		
		then:
		ant1.pellets == 1
		ant1.steps == 1
		ant1.getCoordinate() == [1,0]
		board1.getPlace(1,0) == 0
		
	}
	
	
	

}
