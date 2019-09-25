# MV-TSP Heuristic Applications

The standard TSP is described as follows: given a number _n_ of cities, we seek to minimize the total distance/cost of a tour that goes 
through each city and comes back to the original one. If the distances between two cities satisfy the triangle inequality (i.e. the metric 
case), then we go through each city exactly once and we are therefore seeking the Hamiltonian circuit of minimum distance of the country.

We focus here on the general case of the TSP where we attach to each city _v_ a number _k(v)_ called the multiplicity of _v_. This number 
represents the exact number of times that we have to go through _v_ in our tour. This variant of the problem is often referred to as the 
Many Visits TSP (MV-TSP) or the high multiplicity TSP.

This repertory represents a collection of different heuristics solving the MV-TSP before getting improved using stochastic methods 
described in [Stochastic improvement of deterministic algorithms for MV-TSP](https://github.com/Donshel/mv-tsp). It is currently composed
of two algorithms based respectively on the [Nearest Neighbour Algorithm](https://en.wikipedia.org/wiki/Nearest_neighbour_algorithm) and
on [Christofides' 3/2-approximation algorithm for TSP](https://en.wikipedia.org/wiki/Christofides_algorithm) transformed into algorithms
for the MV-TSP by solving a modified version of the [Hitchcock Transportation Problem](https://link.springer.com/chapter/10.1007/978-3-642-51713-6_11).


## Language

* Computations have been made using [Java](https://java.com) and the CPLEX12.8 package for LP and ILP

## Authors

* **François Rozet** - [Donshel](https://github.com/Donshel)
* **Pedro José Correia Duarte** - [pedrojcd](https://github.com/pedrojcd)
