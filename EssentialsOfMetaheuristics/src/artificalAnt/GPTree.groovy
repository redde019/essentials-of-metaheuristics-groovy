package artificalAnt
import java.util.Random

class GPTree {
	
	
	def max
	def ant
	def antBoard
	
	def rand = new Random()
	def head = null
	

	def runGPTree(){
		max = 10
		grow(1, 10, head)
	}

	def depth(){

	}

	def runEverything(node){
		if(node instanceof RightNode){
			node.turn(ant)
			if(head == node){
				return
			}
		}
		else if(node instanceof LeftNode){
			node.turn(ant)
			if(head == node){
				return
			}
		}
		else if(node instanceof ForwardNode){
			node.moveForward(ant, antBoard)
			
		}
		else if(node instanceof IfFoodAheadNode){
			def result = node.lookForFood(ant, antBoard)
			if(result){
				runEverything(node.getChild1())
			}else{
				runEverything(node.getChild2())
			}
			//println "FOOD"
		}
		else if(node instanceof DoNode){
			runEverything(node.getChild1())
			runEverything(node.getChild2())
			println "DO"
		}
	}
	def counter = 0
	def printTree(node){
		if (counter > max){
			return
		}
		if(node instanceof RightNode){
			println"Right_Turn"
			counter++
			}
		else if(node instanceof LeftNode){
			println"Left_Turn"
			counter++
			}
		else if(node instanceof ForwardNode){
			println "Move_Forward"
			counter++
		}
		else if(node instanceof IfFoodAheadNode){
				println "If_Food_Ahead"
				counter++
				printTree(node.getChild1())
				printTree(node.getChild2())
				
		}
		else if(node instanceof DoNode){
			println "Do_Node"
			counter++
			printTree(node.getChild1())
			printTree(node.getChild2())
			
		}
		
	}
	def size = 0

	def grow(depth, max, node){
		def randFunc
		def Do = new DoNode()
		def left = new LeftNode()
		def right = new RightNode()
		def forward = new ForwardNode()
		def ifFood = new IfFoodAheadNode()
		def functionSet = [ifFood,Do,left,right,forward]
		
		if(depth >= max){
			def rand1 = functionSet[rand.nextInt(5)]
			size++
			println "Depth is greater than Max"
			if(rand1 instanceof DoNode || rand1 instanceof IfFoodAheadNode){
				rand1 = functionSet[rand.nextInt(3)+2]
		
			}
			println "rand1 child "+ rand1
			return rand1
		}
		else{
			if (head == null ){
				size++
				head = functionSet[rand.nextInt(5)]
				if(head.numbChildren() == 0) return head
				randFunc = head
			}
			else {
				size++
				randFunc = functionSet[rand.nextInt(5)]
				println "RandFunc " + randFunc
			}
			randFunc.parent = node
			def arity = 0
			arity = randFunc.numbChildren()
			if(arity != 0){				
					println "Child1"
					println depth
					randFunc.setChild1(grow(depth+1, max, randFunc))
					println "Child2"
					randFunc.setChild2(grow(depth+1, max, randFunc))
				}
			
			println randFunc
			return randFunc
		}
	}
	def nodeCounter = 0
	def getNode(nodeNumber){
		return nodeThing(head, nodeNumber)
	}
	def nodeThing(node, number)	{	
		if(nodeCounter == number){			
			return node
		}
		else if(!(node instanceof DoNode) || !(node instanceof IfFoodAheadNode)) {
			return
		}
		
		else{
			parentCounter++
			findParent(node.getChild1(), number, parentCounter)
			findParent(node.getChild2(), number, parentCounter)
			
		}
		
		
	}
	
	def printChildren(node){
		if(node instanceof DoNode || node instanceof IfFoodAheadNode){
			if(node == node.getChild1() || node == node.getChild2()){
				println "Problem"
				return
			}
			println "Child 1 of " + node + " is " + node.child1
			
			printChildren(node.getChild1())
			println "Child 2 of " + node + " is " + node.child2
			printChildren(node.getChild2())
		}
		else println "This is the end of " + node
	}

}



