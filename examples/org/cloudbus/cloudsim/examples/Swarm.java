package org.cloudbus.cloudsim.examples;


import java.util.Random;



/**
 * Represents a swarm of particles from the Particle Swarm Optimization algorithm.
 */
public class Swarm {

    private int numOfParticles, epochs;
    private double inertia, cognitiveComponent, socialComponent;
    private Vector bestPosition;
    private double bestEval;
    // The function to search.
    public static final double DEFAULT_INERTIA = 0.729844;
    public static final double DEFAULT_COGNITIVE = 1.496180; // Cognitive component.
    public static final double DEFAULT_SOCIAL = 1.496180; // Social component.

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
    public Swarm (int particles, int epochs) {
        this( particles, epochs, DEFAULT_INERTIA, DEFAULT_COGNITIVE, DEFAULT_SOCIAL);
    }

    /**
     * Construct the Swarm with custom values.
     * @param particles     the number of particles to create
     * @param epochs        the number of generations
     * @param inertia       the particles resistance to change
     * @param cognitive     the cognitive component or introversion of the particle
     * @param social        the social component or extroversion of the particle
     */
    public Swarm (int particles, int epochs, double inertia, double cognitive, double social) {
        this.numOfParticles = particles;
        this.epochs = epochs;
        this.inertia = inertia;
        this.cognitiveComponent = cognitive;
        this.socialComponent = social;
        
        
        bestPosition = new Vector(0, 0, 0, 0, 0);
        bestEval = Double.POSITIVE_INFINITY;
        
    }

    /**
     * Execute the algorithm.
     */
    public void run (int[][] individuals) {
        Particle[] particle=new Particle[numOfParticles];
        for(int i=0;i<individuals.length;i++)
        {
        	int a=individuals[i][0];
        	int b=individuals[i][1];
        	int c=individuals[i][2];
        	int d=individuals[i][3];
        	int e=individuals[i][4];
        	particle[i]=new Particle (a,b,c,d,e);
        }

        double oldEval = bestEval;
        System.out.println("--------------------------EXECUTING-------------------------");
        System.out.println("Global Best Evaluation (Epoch " + 0 + "):\t"  + bestEval);

        for (int i = 0; i < epochs; i++) {

            if (bestEval < oldEval) {
                System.out.println("Global Best Evaluation (Epoch " + (i + 1) + "):\t" + bestEval);
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

        System.out.println("---------------------------RESULT---------------------------");
        System.out.println("x = " + bestPosition.getA());
        
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
