package artificalAnt
import java.util.Random
class Grow {

	def max
	def functionSet
	def rand = new Random()

	def doGrow(depth, max, functionSet){
		if(depth >= max){
			return functionSet[rand.nextInt(4)]
		}
		else{
			def randFunc = functionSet[rand.nextInt(4)]
			def arity = randFunc.numbChildren()
			for(int i = 1; i < arity; i++){
				if(i==1){
					randFunc.child1 = doGrow(depth++, max, functionSet)
				}
				else {
					randFunc.child2 = doGrow(depth++, max, functionSet)
				}

			}
			return randFunc
		}
	}


}
