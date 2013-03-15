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
        }
    

}
