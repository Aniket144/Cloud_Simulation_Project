package org.cloudbus.cloudsim.examples;


import java.util.Random;

/**
 * Represents a particle from the Particle Swarm Optimization algorithm.
 */
class Particle {

    private Vector position;        // Current position.
    private Vector velocity;
    private Vector bestPosition;    // Personal best solution.
    private double bestEval;        // Personal best value.
      // The evaluation function to use.

    /**
     * Construct a Particle with a random starting position.
     * @param beginRange    the minimum xyz values of the position (inclusive)
     * @param endRange      the maximum xyz values of the position (exclusive)
     */
    
    
    Particle (int a,int b,int c,int d,int e) {
        
        
        position = new Vector(a,b,c,d,e);
        velocity = new Vector();
        
        bestPosition = velocity.clone();
        bestEval = eval();
    }

    /**
     * The evaluation of the current position.
     * @return      the evaluation
     */
    private double eval () {
    	
			double cost=vmlist[0].executioncost[a] + vmlist[1].executioncost[b] + vmlist[2].executioncost[c]+vmlist[3].executioncost[d]+vmlist[4].executioncost[e];
		
		//communication cost
			cost=cost+(cloudletList[individual[1]].comcost[individual[0]])*vmlist[1].datasize[0]+(cloudletList[individual[2]].comcost[individual[1]])*vmlist[2].datasize[0]
					+(cloudletList[individual[3]].comcost[individual[2]])*vmlist[3].datasize[0]+(cloudletList[individual[4]].comcost[individual[3]])*vmlist[4].datasize[0];
							

		// Calculate fitness
		double fitness = (double) cost;

		// Store fitness
		

		return fitness;
    }


    
    /**
     * Generate a random number between a certain range.
     * @param beginRange    the minimum value (inclusive)
     * @param endRange      the maximum value (exclusive)
     * @return              the randomly generated value
     */
    

    /**
     * Update the personal best if the current evaluation is better.
     */
    void updatePersonalBest () {
        double eval = eval();
        if (eval < bestEval) {
            bestPosition = position.clone();
            bestEval = eval;
        }
    }

    /**
     * Get a copy of the position of the particle.
     * @return  the x position
     */
    Vector getPosition () {
        return position.clone();
    }

    /**
     * Get a copy of the velocity of the particle.
     * @return  the velocity
     */
    Vector getVelocity () {
        return velocity.clone();
    }

    /**
     * Get a copy of the personal best solution.
     * @return  the best position
     */
    Vector getBestPosition() {
        return bestPosition.clone();
    }

    /**
     * Get the value of the personal best solution.
     * @return  the evaluation
     */
    double getBestEval () {
        return bestEval;
    }

    /**
     * Update the position of a particle by adding its velocity to its position.
     */
    void updatePosition () {
        this.position.add(velocity);
    }

    /**
     * Set the velocity of the particle.
     * @param velocity  the new velocity
     */
    void setVelocity (Vector velocity) {
        this.velocity = velocity.clone();
    }

    
}
