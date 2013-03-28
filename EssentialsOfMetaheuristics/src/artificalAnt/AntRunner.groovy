package artificalAnt
import populationMethods.GeneticAlgorithm
class AntRunner {
	
	public static void main(String [] args) {
		
//        def forest = []
//		for(int i = 0 ; i<100 ; i++){
//            forest.add(new GPTree())
//        }
//        int j
//        for(tree in forest){
//            tree.create()
//            j++
//            println "tree ${j} ${tree.quality()}"
//        }
		
		def algorithm = new GeneticAlgorithm()
		def cross = new AntCrossover()
		def tree = new Problem()
		
		def coolBest = algorithm.maximize(problem: tree, crossover: cross)
		println coolBest.quality()
		algorithm.toString()

	}
}
