package artificalAnt
import java.util.Random
class AntCrossover {
	def rand = new Random()
	def biggestSize(tree1,tree2){
		def biggestsize
		if(tree1.size() > tree2.size()){
			biggestsize = tree2.size()
		}
		else{biggestsize = tree1.size()}
		return biggestsize
	}
	def crossover(fatherTree, motherTree){
		def dadTree = fatherTree
		def momTree = motherTree
		def biggestSize = biggestSize(fatherTree,motherTree)
		println "biggestSize ${biggestSize}"
		def fatherPoint = 0
		def motherPoint = 0
		if(biggestSize != 0){
			fatherPoint = rand.nextInt(biggestSize)
			motherPoint = rand.nextInt(biggestSize)
		}
		def fatherNode = fatherTree.returnNode(fatherPoint)
		def motherNode = motherTree.returnNode(motherPoint)
		def grandFather
		def grandMother
		if(fatherPoint == 0){
			grandFather = null
		}
		else{
			grandFather = fatherNode.parent

		}
		if(motherPoint == 0){
			grandMother = null
		}
		else{
			grandMother = motherNode.parent
		}
		if(fatherPoint == 0 && motherPoint == 0){
			def tempNode = fatherTree.head
			fatherTree.head = motherTree.head
			motherTree.head = tempNode
		}
		else if(fatherPoint == 0 && motherPoint != 0){
			def tempFather = fatherNode
			fatherTree.head = motherNode
			def tempParent1 = motherNode.parent
			if(motherNode instanceof DoNode || motherNode instanceof IfFoodAheadNode){
				if(motherNode.childId == 1){
					tempParent1.child1 = fatherNode
					fatherNode.parent = tempParent1
				}else{
					tempParent1.child2 = fatherNode
					fatherNode.parent = tempParent1
				}
			}
			fatherTree.head.parent = null
		}
		else if(motherPoint == 0 && fatherPoint != 0){
			def tempMother = motherNode
			motherTree.head = fatherNode
			def tempParent1 = fatherNode.parent
			if(fatherNode instanceof DoNode || fatherNode instanceof IfFoodAheadNode){
				if(fatherNode.childId == 1){
					tempParent1.child1 = motherNode
					motherNode.parent = tempParent1
				}
				else{
					tempParent1.child2 = motherNode
					motherNode.parent = tempParent1
				}
			}
			motherTree.head.parent = null

		}
		else {
			def tempNode = fatherNode
			def tempParent = fatherNode.parent
			def tempMother = motherNode
			def tempParent1 = motherNode.parent
			if( fatherNode instanceof DoNode || fatherNode instanceof IfFoodAheadNode){
				if(fatherNode.childId == 1){
					tempParent.setChild1(motherNode)
				}else{
					tempParent.setChild2(motherNode)
				}
			}
			if( motherNode instanceof DoNode || motherNode instanceof IfFoodAheadNode){
				if(motherNode.childId == 1){
					tempParent1.setChild1(fatherNode)
				}else{
					tempParent1.setChild2(fatherNode)
				}
			}
		}
		return [fatherTree,motherTree]
	}
}
