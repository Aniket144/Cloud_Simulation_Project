# Cloud Simulation Project
> The project is based on a 2017 Research Paper by Ahmad M. Manasrah and Hanan Ba Ali, titled "WorkFlow Scheduling Using Hybrid GA-PSO Algorithm".

We implemented the proposed algorithm in Java in Eclipse IDE using cloudsim framework to simulate Tasks as Cloudlets and Processors as Virtual Machines. Basic Outline of the main algorithm is as follows.

- Initialize Population
- Apply Genetic Algorithm over population till half the maximum total iterations.
  - Selection, Crossover, Mutation.
- Apply Particle Swarm Optimization over GA generated Population till remaining number of iterations.
  - Calculate best velocity & position & update according to it.
- Return the best solution with minimum fitness value.

