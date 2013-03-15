package artificalAnt
import java.util.Random
class AntCrossover {
    def rand = new Random()
    def crossover(fatherTree, motherTree){
		def biggestSize
		if(fatherTree.size > motherTree.size){
			biggestSize = motherTree.size
		}
		else{biggestSize = fatherTree.size}
		println biggestSize
		if(biggestSize == 0){
			
			fatherTree = motherTree
			println fatherTree.head
			motherTree = fatherTree
			println motherTree.head
			return
		}
        def fatherPoint = rand.nextInt(biggestSize)
        def motherPoint = rand.nextInt(biggestSize) 
        def fatherNode = fatherTree.getNode(fatherPoint)
        def motherNode = motherTree.getNode(motherPoint)
        def grandFather = fatherNode.parent
        def grandMother = motherNode.parent
    }
}
