package org.cloudbus.cloudsim.examples;

import java.util.List;
import java.util.Random;

/**
 * Represents a swarm of particles from the Particle Swarm Optimization algorithm.
 */
public class Swarm {

    private int numOfParticles, epochs;
    private double inertia, cognitiveComponent, socialComponent;
    public Vector bestPosition;
    private double bestEval;
    private int[][] particles;
    // The function to search.
    public static final double DEFAULT_INERTIA = 0.729844;
    public static final double DEFAULT_COGNITIVE = 1.496180; // Cognitive component.
    public static final double DEFAULT_SOCIAL = 1.496180; // Social component.
    public static List<cloudlet3> cloudletList;
	public static List<vm3> vmlist;

    /**
     * When Particles are created they are given a random position.
     * The random position is selected from a specified range.
     * If the begin range is 0 and the end range is 10 then the
     * value will be between 0 (inclusive) and 10 (exclusive).
     */
    

    /**
     * Construct the Swarm with default values.
     * @param particles     the number of particles to create
     * @param epochs        the number of generations
     */
    public Swarm (int[][] particles, int epochs, int numOfParticles, List<cloudlet3> cloudletList, List<vm3> vmlist) {
    	this.numOfParticles = numOfParticles;
    	this.particles=particles;
    	this.epochs=epochs;
        this.cloudletList = cloudletList;
    	this.vmlist = vmlist;
        bestPosition = new Vector(0, 0, 0, 0, 0);
        bestEval = Double.POSITIVE_INFINITY;
        
    }

    /**
     * Construct the Swarm with custom values.
     * @param particles     the number of particles to create
     * @param epochs        the number of generations
     * @param inertia       the particles resistance to change
     * @param cognitive     the cognitive component or introversion of the particle
     * @param social        the social component or extroversion of the particle
     */
    

    /**
     * Execute the algorithm.
     */
    public void run (int[][] individuals) {
        Particle[] particle=new Particle[numOfParticles];
        for(int i=0;i<numOfParticles;i++)
        {
        	int a = particles[i][0];
        	int b = particles[i][1];
        	int c = particles[i][2];
        	int d = particles[i][3];
        	int e = particles[i][4];
        	particle[i]=new Particle(a,b,c,d,e);
        	System.out.println("particle " + i + " =>" + (particle[i].position).toString());
        }

        double oldEval = bestEval;
        System.out.println("--------------------------EXECUTING-------------------------");
        

        for (int i = 0; i < epochs; i++) {

            if (bestEval < oldEval) {
                
                oldEval = bestEval;
            }
            

            for (int j=0;j<numOfParticles;j++) {
            	particle[j].updatePersonalBest();
                updateGlobalBest(particle[j]);
            }

            for (int j=0;j<numOfParticles;j++) {
                updateVelocity(particle[j]);
                particle[j].updatePosition();
            }
        }

        
        
        
        System.out.println("Final Best Evaluation: " + bestEval);
        System.out.println("---------------------------COMPLETE-------------------------");

    }

    /**
     * Create a set of particles, each with random starting positions.
     * @return  an array of particles
     */
    

    /**
     * Update the global best solution if a the specified particle has
     * a better solution
     * @param particle  the particle to analyze
     */
    private void updateGlobalBest (Particle particle) {
        if (particle.getBestEval() < bestEval) {
            bestPosition = particle.getBestPosition();
            bestEval = particle.getBestEval();
        }
    }

    /**
     * Update the velocity of a particle using the velocity update formula
     * @param particle  the particle to update
     */
    private void updateVelocity (Particle particle) {
        Vector oldVelocity = particle.getVelocity();
        Vector pBest = particle.getBestPosition();
        Vector gBest = bestPosition.clone();
        Vector pos = particle.getPosition();

        Random random = new Random();
        double r1 = random.nextDouble();
        double r2 = random.nextDouble();

        // The first product of the formula.
        Vector newVelocity = oldVelocity.clone();
        newVelocity.mul(inertia);

        // The second product of the formula.
        pBest.sub(pos);
        pBest.mul(cognitiveComponent);
        pBest.mul(r1);
        newVelocity.add(pBest);

        // The third product of the formula.
        gBest.sub(pos);
        gBest.mul(socialComponent);
        gBest.mul(r2);
        newVelocity.add(gBest);

        particle.setVelocity(newVelocity);
    }

}
