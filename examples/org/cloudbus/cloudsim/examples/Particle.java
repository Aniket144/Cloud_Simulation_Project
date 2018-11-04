package org.cloudbus.cloudsim.examples;

import java.util.Arrays;
import java.util.Random;

/**
 * Represents a particle from the Particle Swarm Optimization algorithm.
 */
class Particle {

    public Vector position;        // Current position.
    public Vector velocity;
    public Vector bestPosition;    // Personal best solution.
    public double bestEval;        // Personal best value.
      // The evaluation function to use.

    /**
     * Construct a Particle with a random starting position.
     * @param beginRange    the minimum xyz values of the position (inclusive)
     * @param endRange      the maximum xyz values of the position (exclusive)
     */
    
    
    Particle (int a,int b,int c,int d,int e) {
        
        position = new Vector(a,b,c,d,e);
        velocity = new Vector();
        
        bestPosition = position.clone();
        bestEval = eval();
    }

    /**
     * The evaluation of the current position.
     * @return      the evaluation
     */
    private double eval () {
    	
    	double cost = 0.0;
		double computationCost = 0;
		//computation cost
		double[] executionCostArray = Swarm.cloudletList.get(0).executioncost;
		computationCost += executionCostArray[position.a];
		executionCostArray = Swarm.cloudletList.get(1).executioncost;
		computationCost += executionCostArray[position.b];
		executionCostArray = Swarm.cloudletList.get(2).executioncost;
		computationCost += executionCostArray[position.c];
		executionCostArray = Swarm.cloudletList.get(3).executioncost;
		computationCost += executionCostArray[position.d];
		executionCostArray = Swarm.cloudletList.get(4).executioncost;
		computationCost += executionCostArray[position.e];
		
		double communicationCost = 0;
		int[] data = Swarm.cloudletList.get(1).datasize;
//		System.out.println(Arrays.toString(data));
		
		double[] communicationCostArray = Swarm.vmlist.get(position.a).comcost;
		communicationCost+=data[0]*communicationCostArray[position.b];
		data = Swarm.cloudletList.get(2).datasize;
		
//		System.out.println(Arrays.toString(data));
		
		communicationCostArray = Swarm.vmlist.get(position.b).comcost;
		communicationCost+=data[0]*communicationCostArray[position.c];
		data = Swarm.cloudletList.get(3).datasize;
//		System.out.println(Arrays.toString(data));
		
		communicationCostArray = Swarm.vmlist.get(position.c).comcost;
		communicationCost+=data[0]*communicationCostArray[position.d];
		data = Swarm.cloudletList.get(4).datasize;
//		System.out.println(Arrays.toString(data));
		
		communicationCostArray = Swarm.vmlist.get(position.d).comcost;
		communicationCost+=data[0]*communicationCostArray[position.e];
//		System.out.println(Arrays.toString(data));
		
		cost = computationCost + communicationCost;
		return cost;
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
