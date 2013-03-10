package artificalAnt

class ForwardNode {
	def forwardNode
	
	def forwardNode(number){
		forwardNode = number
	}
	def isfood(){
		if (forwardNode == 1){
			return true
		}
		else return false
	}
	def numbChildren(){
		return 0
		
	}
}
