import java.util.*;
public class GA_Sequential {
	public static void main(String[] args) {
		
	}
}
class Population{
	int populationSize = 100;
	Individual[] people = new Individual[populationSize];
	public Population() {
		for(int i=0;i<populationSize;i++) {
			people[i] = new Individual();
		}
	}
}

class Individual{
	int fitness, genesLength = 23;
	int genes[] = new int[genesLength];
	public Individual() {
		// Setting Genes.
		Random randomNum = new Random();
		for(int i=0;i<genesLength;i++) {
			genes[i] = Math.abs(randomNum.nextInt()%2);
		}
		// Calculating Fitness.
		fitness = 0;
		for(int i=0;i<genesLength;i++) {
			if(genes[i]==1) {
				fitness += 1;
			}
		}
	}
}
