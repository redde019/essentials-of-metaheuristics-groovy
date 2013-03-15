package artificalAnt

import spock.lang.Specification;

class ParentTest extends Specification{
	
	def do1 = new DoNode()

	
	def "find parent at root"(){
		when:
		def ant = new Ant()
		def board1 = new TrailBoard()
		def superTree = new GPTree(ant:ant,antBoard: board1)
		board1.initialize(15)
		superTree.head = new DoNode()
		superTree.head.setChild1(new DoNode())
		superTree.head.child1.setChild1(new RightNode())
		superTree.head.child1.setChild2(new LeftNode())
		superTree.head.setChild2(new ForwardNode())
		
		
		then:
		superTree.getNode(0) instanceof DoNode
		superTree.getNode(1) instanceof DoNode
		superTree.getNode(2) instanceof RightNode
		
	}
}
