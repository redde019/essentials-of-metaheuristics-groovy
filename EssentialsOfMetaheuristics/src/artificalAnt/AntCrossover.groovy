package artificalAnt
import java.util.Random
class AntCrossover {
    def rand = new Random()
    def crossover(fatherTree,motherTree){
        def fatherPoint = rand.nextInt(fatherTree.size)
        def motherPoint = rand.nextInt(motherTree.size) 
        def fatherNode = fatherTree.getNode(fatherPoint)
        def motherNode = motherTree.getNode(motherPoint)
        def grandFather = fatherNode.parent
        def grandMother = motherNode.parent
    }
}
