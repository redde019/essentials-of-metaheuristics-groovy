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



