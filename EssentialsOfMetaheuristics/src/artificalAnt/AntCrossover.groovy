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
		def biggestSize = biggestSize(dadTree,momTree)
		//println "biggestSize ${biggestSize}"
		def fatherPoint = 0
		def motherPoint = 0
		if(biggestSize != 0){
			fatherPoint = rand.nextInt(biggestSize)
			motherPoint = rand.nextInt(biggestSize)
		}
		//println "Father: " + fatherPoint
		//println "Mother: " + motherPoint
		def fatherNode = dadTree.returnNode(fatherPoint)
		def motherNode = momTree.returnNode(motherPoint)
		def grandFather
		def grandMother
		//println "Father Node is head? ${fatherNode == fatherTree.head}"
		//println "Mother Node is head?  ${motherNode == motherTree.head}"
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
		//println "grandFather Node: "+ grandFather
		//println "grandMother Node: "+ grandMother
		if(fatherPoint == 0 && motherPoint == 0){
			def tempNode = dadTree.head
			dadTree.head = momTree.head
			momTree.head = tempNode
		}
		else if(fatherPoint == 0 && motherPoint != 0){
			def tempFather = fatherNode
			dadTree.head = motherNode
			def tempParent1 = motherNode.parent
			if(tempParent1 instanceof DoNode || tempParent1 instanceof IfFoodAheadNode){
				if(motherNode.childId == 1){
					tempParent1.child1 = fatherNode
					fatherNode.parent = tempParent1
					fatherNode.childId = 1
				}else{
					tempParent1.child2 = fatherNode
					fatherNode.parent = tempParent1
					fatherNode.childId = 2
				}
			}
			dadTree.head.parent = null
		}
		else if(motherPoint == 0 && fatherPoint != 0){
			def tempMother = motherNode
			momTree.head = fatherNode
			def tempParent1 = fatherNode.parent
			if(tempParent1 instanceof DoNode || tempParent1 instanceof IfFoodAheadNode){
				if(fatherNode.childId == 1){
					tempParent1.child1 = motherNode
					motherNode.parent = tempParent1
					motherNode.childId = 1
				}
				else{
					tempParent1.child2 = motherNode
					motherNode.parent = tempParent1
					motherNode.childId = 2
				}
			}
			momTree.head.parent = null

		}
		else if (motherPoint != 0 && fatherPoint != 0) {
			def tempParent = fatherNode.parent
			def tempParent1 = motherNode.parent
			if(tempParent == null || tempParent1 == null){
				println "Kittens is null"
				println "father Node: ${fatherNode} and number ${fatherPoint} and size ${fatherTree.size()}"
				println "Mother Node: ${motherNode} and number ${motherPoint} and size ${motherTree.size()}"
				println "TempParent1 Node: ${tempParent1} and grandmother is ${grandFather}"
				println "TempParent Node: ${tempParent} and grandfather is ${grandMother}"
				
			}
			if(tempParent instanceof DoNode || tempParent instanceof IfFoodAheadNode){
				if(fatherNode.childId == 1){
					tempParent.setChild1(motherNode)
					motherNode.parent = tempParent
					motherNode.childId = 1
				}else{
					tempParent.setChild2(motherNode)
					motherNode.parent = tempParent
					motherNode.childId = 2
				}
			}
			
			if( tempParent1 instanceof DoNode || tempParent1 instanceof IfFoodAheadNode){
				if(motherNode.childId == 1){
					tempParent1.setChild1(fatherNode)
					fatherNode.parent = tempParent1
					fatherNode.childId = 1
				}else{
					tempParent1.setChild2(fatherNode)
					fatherNode.parent = tempParent1
					fatherNode.childId = 2
				}
			}
		}
		//println"quality of father: ${fatherTree.quality()}"
		return [dadTree,momTree]
	}
}
