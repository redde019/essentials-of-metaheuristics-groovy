package populationMethods

import java.util.Random
import operators.Crossovers
import operators.TournamentSelection
import artificalAnt.GPTree
import artificalAnt.AntCrossover
class GeneticAlgorithm {
	// Algorithm 20
	
	// We need popsize to be global so that we can use it in the toString method, also added a default value
	def popsize = 100
	
	// Our Algorithm takes a Genetic Algorithm Problem, a desired population size
	def maximize(problem, populationSize=popsize, selector=new TournamentSelection(), Crossover= new AntCrossover()) {
		popsize = populationSize
		println popsize
	
		def startingPopulation = [] 
		println startingPopulation.size()
		def tree
		for(int i = 0; i < popsize;i++) {
			tree = new GPTree()
			tree.create()
			startingPopulation[i] = tree // Add a new random individual
		}
		
		def best = new GPTree()
		best.create()
		def qualityOfBest = best.quality()
		def genCounter = 0
		while(!best.terminate(best, qualityOfBest) && genCounter < 10) {
			def t =0
			for(def individual: startingPopulation) {
				def newQuality = individual.quality()
				//println "GEN_${genCounter}_individual_${t}_quality_${newQuality}"
				t++
				if(newQuality > qualityOfBest) {
					best = individual.clone()
					println"new best: ${newQuality}"
					qualityOfBest = newQuality
				}
				//println"bestQuality ${best.quality()}"
			}
			println "end of Gen ${genCounter}"
			def endingPopulation = [] 
			
			for(i in 0..(popsize/2)) {
				
				def parentA = selector.select(startingPopulation)
				def parentB = selector.select(startingPopulation)
				def children = Crossover.crossover(parentA, parentB)
				endingPopulation.add(children[0])
				endingPopulation.add(children[1])
			}
			startingPopulation = endingPopulation
			genCounter++
		}
		println "best tree " + best
		return best
	}
	
	String toString() {
		"GA_" + popsize
	}

}
