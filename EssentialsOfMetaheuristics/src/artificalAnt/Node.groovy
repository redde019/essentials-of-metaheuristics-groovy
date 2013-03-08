package artificalAnt

class Node {
	
	def key
	def value
	def left
	def right
	
	
	def Node(key, value, left = NullNode.instance(), right = NullNode.instance()){
		this.key = key
		this.value = value
		this.left = left
		this.right = right
	}
	
	def isNull() {
		return false
	}
	
	def count
	
	def size() {
		count = 0
		sizeHelper(this)
		return count
	}
	
	def sizeHelper(currentNode) {
		count++
		if (currentNode.left != NullNode.instance()) {
			sizeHelper(currentNode.left)
		}
		if (currentNode.right != NullNode.instance()) {
			sizeHelper(currentNode.right)
		}
	}
	
	def insert(key, value) {
		if (key > this.key) {
			return new Node(this.key, this.value, this.left, this.right.insert(key, value))
		}
		return new Node(this.key, this.value, this.left.insert(key, value), this.right)
	}
	
	def depth() {
		if (right.depth() > left.depth()) {
			return (right.depth() + 1)
		}
		return (left.depth() + 1)
	}

}
