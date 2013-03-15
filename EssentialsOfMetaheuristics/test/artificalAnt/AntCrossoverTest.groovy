package artificalAnt

import spock.lang.Specification;

class AntCrossoverTest  extends Specification {
    
    def 'test child node knows which child it is'(){
        when:
        def tree = new GPTree()
        tree.head = new DoNode()
        tree.head.setChild1(new IfFoodAheadNode())
        tree.head.child1.setChild1(new LeftNode())
        tree.head.child1.setChild2(new ForwardNode())
        tree.head.setChild2(new RightNode())
        
        then:
        tree.head.child1.childId == 1
        tree.head.child2.childId == 2
        tree.head.child1.child1.childId == 1
        tree.head.child1.child2.childId == 2
    }
    
    def'test get node'(){
        when:
        def tree = new GPTree()
        tree.head = new DoNode()
        tree.head.setChild1(new IfFoodAheadNode())
        tree.head.child1.setChild1(new LeftNode())
        tree.head.child1.setChild2(new ForwardNode())
        tree.head.setChild2(new RightNode())
		def k = tree.returnNode(0)
        def a = tree.returnNode(1)
        def b = tree.returnNode(2)
        def c = tree.returnNode(3)
        def d = tree.returnNode(4)
        
        then:
        tree.head instanceof DoNode
        tree.head.child1 instanceof IfFoodAheadNode
        tree.head.child2 instanceof RightNode
        tree.head.child1.child1 instanceof LeftNode
        tree.head.child1.child2 instanceof ForwardNode
        //tree.getNode(0) instanceof DoNode
        a instanceof IfFoodAheadNode
        b instanceof LeftNode
        c instanceof ForwardNode
        d instanceof RightNode
		k instanceof DoNode
        }
	def "test crossover same size"(){
		when:
		//must set size
		def tree = new GPTree()
		tree.head = new DoNode()
		tree.head.setChild1(new LeftNode())
		tree.head.setChild2(new ForwardNode())
		tree.size = 3
		def tree2 = new GPTree()
		tree2.head = new IfFoodAheadNode()
		tree2.head.setChild1(new RightNode())
		tree2.head.setChild2(new LeftNode())
		tree2.size = 3
		println tree.head
		println tree2.head
		def cross = new AntCrossover()
		cross.crossover(tree, tree2)
		println "head tree after crossOver ${tree.head}"
		println "head tree 2 after crossOver ${tree2.head}"
		
		then:
		tree.head instanceof IfFoodAheadNode
		tree2.head instanceof DoNode
	}
	def "test crossover"(){
		when:
		def tree = new GPTree()
		tree.head = new DoNode()
		tree.head.setChild1(new IfFoodAheadNode())
		tree.head.child1.setChild1(new LeftNode())
		tree.head.child1.setChild2(new ForwardNode())
		tree.head.setChild2(new RightNode())
		tree.size = 5
		def tree2 = new GPTree()
		tree2.head = new LeftNode()
		tree2.size = 1
		def cross = new AntCrossover()
		println tree.head
		println tree2.head
		cross.crossover(tree, tree2)
		
		
		then:
		tree.head instanceof LeftNode
		tree2.head instanceof DoNode
		tree2.head.child1 instanceof IfFoodAheadNode
		
	}
    

}
