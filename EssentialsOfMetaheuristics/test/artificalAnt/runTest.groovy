package artificalAnt

import spock.lang.Specification;

class runTest extends Specification {

   def ' test with forward node as head'(){
       when:
       def tree = new GPTree()
       tree.head = new ForwardNode()
       tree.run()
       
       then:
       tree.quality() == 2
   }
}
