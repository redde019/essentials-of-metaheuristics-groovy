package artificalAnt
import java.util.Random

class GPTree {
	def leftChild
	def rightChild
	def max
	def ant
	def antBoard
	def functionSet
	def rand = new Random()
	def head

	def runGPTree(){
		grow(1, 5)
	}

	def depth(){

	}

	def runEverything(node){
		if(Instanceof(node,RightNode())){
			node.turn(ant)
			if(head == node){
				println "rightnode was first"
				return
			}
		}
		else if(Instanceof(node,LeftNode())){
			node.turn(ant)
			if(head == node){
				println "lefttnode was first"
				return
			}
		}
		else if(Instanceof(node,ForwardNode())){
			node.moveForward(ant, antBoard)
		}
		else if(Instanceof(node,IfFoodAheadNode())){
			def result = lookForFood(ant, antBoard)
			if(result){
				runEverything(node.child1)
			}else{
				runEverything(node.child2)
			}
		}
		else if(Instanceof(node,DoNode())){
			runEverything(node.child1)
			runEverything(node.child2)
			
		}
	}

	def grow(depth, max){
		if(depth >= max){
			return functionSet[rand.nextInt(4)]
		}
		else{
			if (head == null ){
				head = functionSet[rand.nextInt(4)]
				def randFunc = head
			}
			else {
				def randFunc = functionSet[rand.nextInt(4)]
			}
			def arity = randFunc.numbChildren()
			for(int i = 1; i < arity; i++){
				if(i==1){
					randFunc.child1 = grow(depth++, max, functionSet)
				}
				else {
					randFunc.child2 = grow(depth++, max, functionSet)
				}

			}
			return randFunc
		}
	}

}



