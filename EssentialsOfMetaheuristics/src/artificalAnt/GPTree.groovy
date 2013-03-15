package artificalAnt
import java.util.Random

class GPTree {


	def max
	def ant = new Ant()
	def antBoard = new TrailBoard()

	def rand = new Random()
	def head = null

	def terminate(best, qualityBest){
		if(qualityBest == 15 || best.ant.steps == 400){
			return true 
		}else{
		return false
		}
		
	}
	def create(){
		max = 1000
		grow(1, max, head)
	}
	def quality(){
		runEverything(head)
		return ant.pellets
	}
	def runGPTree(){
		max = 10
		grow(1, 10, head)
	}

	def run(){
		antBoard.initialize(32)
		antBoard.reset()
		ant.reset()
		runEverything(head)
	}

	def runEverything(node){
		
		if(ant.steps <= 400){
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
			}
			else if(node instanceof DoNode){
				runEverything(node.getChild1())
				runEverything(node.getChild2())
			}
		}else return
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
	def size(){
		return size

	}

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
			if(rand1 instanceof DoNode || rand1 instanceof IfFoodAheadNode){
				rand1 = functionSet[rand.nextInt(3)+2]
			}

			return rand1
		}
		else{
			if (head == null ){
				size+1
				head = functionSet[rand.nextInt(5)]
				if(head.numbChildren() == 0) return head
				randFunc = head
			}
			else {
				size+1
				randFunc = functionSet[rand.nextInt(5)]

			}
			randFunc.parent = node
			def arity = 0
			arity = randFunc.numbChildren()
			if(arity != 0){
				randFunc.setChild1(grow(depth+1, max, randFunc))
				randFunc.setChild2(grow(depth+1, max, randFunc))
			}

			return randFunc
		}
	}
	def returningNode
	def nodeCounter
	def returnNode(nodeNumber){
		getNode(nodeNumber)
		return returningNode
	}
	def getNode(nodeNumber){
		nodeCounter = 0
		def returningNode = null
		nodeThing(head, nodeNumber)
		return returningNode
	}
	def nodeThing(node, number)	{

		if(nodeCounter.equals(number)){
			returningNode = node
			return node
		}else{
			if((node instanceof DoNode) || (node instanceof IfFoodAheadNode)) {
				nodeCounter+= 1

				nodeThing(node.getChild1(), number)

				nodeCounter+= 1

				nodeThing(node.getChild2(), number)
			}
			else{
				return
			}
		}

	}

	def printChildren(node){
		if(node instanceof DoNode || node instanceof IfFoodAheadNode){
			if(node == node.getChild1() || node == node.getChild2()){
				println "Problem"
				return
			}

			printChildren(node.getChild1())
			printChildren(node.getChild2())
		}
		else println "This is the end of " + node
	}

}



