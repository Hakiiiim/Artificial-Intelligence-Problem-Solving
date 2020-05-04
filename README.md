# Artificial-Intelligence-Problem-Solving
The goal of this work is to understand how to model problems, to solve and implement the search algorithms.

Course given by: Gauthier PICARD, Professor. PhD. HDR at the Ecole des Mines de Saint-étienne.

Here is his statement of the problem: https://www.emse.fr/~picard/cours/ai/search/index.html

The source files were written by Pr. Gauthier PICARD (inspired from the algorithm provided by AIMA-Java Project), then completed by us following the exercices presented in the previous link.
The three following problems were modelised and solved by me and my colleague Younes Gueddari.

The files are to be found in the src folder of the Java Project. 

_Core_ contains the mother classes (Problem, Node and Search) and the Solvers (AbstractTreeSearch and the one we use next AbstractGraphSearch).

_Solver_ contains the search algorithms ready to use : Depthfirst and Breadthfirst for a graph and a tree search problem (graph in our case).

_Simple_ contains a simple graph and tree example explained in the link above.

_exo5_ corresponds to the first problem : The farmer's problem.

_exo6_ corresponds to the second problem : The cannibal's problem.

_exo7_ corresponds to the third problem : The two cans' problem.

## 1st Problem: The Farmer's Problem
The farmer wants to get his goat, wolf and cabbage to the other side of the river. His boat isn't very big and it can only carry him and either his goat, his wolf or his cabbage. Now…..if he leaves the goat alone with the cabbage, the goat will gobble up the cabbage. If he leaves the wolf alone with the goat, the wolf will gobble up the goat. When the farmer is present, the goat and cabbage are safe from being gobbled up by their predators.

How does the farmer manage to get everything safely to the other side of the river?

* States: a state consists of an ordered sequence of four boolean variables (farmer,goat,cabbage,wolf). _true_ means that the corresponding item has moved to the other side of the river. Thus, the start state is (false,false,false,false). States have an additional boolean attribute _interdit_ which is false by default, and is set to true if the state is forbidden (goat and cabbage or goat and wolf left alone).
* Actions: 4 possible actions _"Farmer moves alone"_, _"Farmer moves goat"_, _"Farmer moves cabbage"_ and _"Farmer moves wolf"_. Every action will return a state with the negation of the sequence's elements which items has been moved.
* Goal state: (true,true,true,true).
* Path cost: unit cost, all actions are considered of a cost equal to 1.

## 2d Problem: The Cannibal's Problem
On one bank of a river are three missionaries and three cannibals. There is one boat available that can hold up to two people and that they would like to use to cross the river. If the cannibals ever outnumber the missionaries on either of the river’s banks, the missionaries will get eaten.

How can the boat be used to safely carry all the missionaries and cannibals across the river?

* States: a state consists of an ordered sequence of two numbers and boolean variable (cannibals,missionaries,boat) respesenting respectively the number of cannibals and missionaries at the initial side of the river and the state of the boat (_true_ for the initial side). Thus, the start state is (3,3,true). States have an additional boolean attribute _interdit_ which is false by default, and is set to true if the state is forbidden (number of cannibals > number of missionaries).
* Actions: 5 possible actions _"Move one cannibal"_, _"Move one missionary"_, _"Move two cannibals"_, _"Move two missionaries"_ and _"Move one missionary and one cannibal"_. Every action will update the number of cannibals and missionaries on the intial side of the river and negate the value of boat.
* Goal state: (0,0,false).
* Path cost: unit cost, all actions are considered of a cost equal to 1.

## 3rd Problem: The Two Cans' Problem
You have 2 cans A and B, each containing a quantity of liquid (initial situation). You can do the following as many times as you wish, and in the order you want:

-> Empty a container to the river,

-> Transfer the liquid from a canister in the other to empty the first or second fill.

-> How to move from an initial situation at a given final position?

For example, you can test your program on the following cases: Can A has a capacity of 15, and can B has a capacity of 5, Initial situation: A contains 12 and B contains 3, Final situation: A contains 0 and B contains 5.

* States: a state consists of two numbers representing the respective volumes of the two cans, the initial state is then (I_a,I_b) which are the initial volumes in the two cans (12 and 3 in the example)
* Actions: 4 possible actions _"empty A"_, _"empty B"_, _"fill B with A"_ and _"fill A with B"_. Every action will update the volumes of the two cans.
* Goal state: (Fa,Fb), (0 and 5 in the example, notice that the final state is not always possible)
* Path cost: unit cost, all actions are considered of a cost equal to 1.
