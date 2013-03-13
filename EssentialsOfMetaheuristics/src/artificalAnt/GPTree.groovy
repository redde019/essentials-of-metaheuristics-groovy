package artificalAnt
import java.util.Random

class GPTree {
	def ifFood = new IfFoodAheadNode()
	def Do = new DoNode()
	def left = new LeftNode()
	def right = new RightNode()
	def forward = new ForwardNode()
	def max
	def ant
	def antBoard
	def functionSet = [ifFood,Do,left,right,forward]
	def rand = new Random()
	def head
	

	def runGPTree(){
		grow(2, 10)
	}

	def depth(){

	}

	def runEverything(node){
		if(node instanceof RightNode){
			node.turn(ant)
			if(head == node){
				return
			}
			println "RIGHT"
		}
		else if(node instanceof LeftNode){
			node.turn(ant)
			if(head == node){
				return
			}
			println "LEFT"
		}
		else if(node instanceof ForwardNode){
			node.moveForward(ant, antBoard)
			println "FORWARD"
		}
		else if(node instanceof IfFoodAheadNode){
			def result = node.lookForFood(ant, antBoard)
			if(result){
				runEverything(node.child1)
			}else{
				runEverything(node.child2)
			}
			println "FOOD"
		}
		else if(node instanceof DoNode){
			runEverything(node.child1)
			runEverything(node.child2)
			println "DO"
		}
	}
	
	def printTree(node){
		if(node instanceof RightNode){
			println"Right_Turn"
			}
		else if(node instanceof LeftNode){
			println"Left_Turn"
			}
		else if(node instanceof ForwardNode){
			println "Move_Forward"
		}
		else if(node instanceof IfFoodAheadNode){
				println "If_Food_Ahead"
				printTree(node.child1)
				printTree(node.child2)
		}
		else if(node instanceof DoNode){
			println "Do_Node"
			printTree(node.child1)
			printTree(node.child2)
			
		}
		
	}

	def grow(depth, max){
		def randFunc
		if(depth >= max){
			return functionSet[rand.nextInt(5)]
		}
		else{
			if (head == null ){
				head = functionSet[rand.nextInt(5)]
				if(head.numbChildren() == 0) return head
				 randFunc = head
			}
			else {
				 randFunc = functionSet[rand.nextInt(5)]
			}
			def arity = randFunc.numbChildren()
			for(int i = 1; i < arity; i++){
				if(i==1){
					randFunc.child1 = grow(depth++, max)
				}
				else {
					randFunc.child2 = grow(depth++, max)
				}

			}
			println randFunc
			return randFunc
		}
	}

}



