# Artificial-Intelligence-Problem-Solving
The goal of this work is to understand how to model problems, to solve and implement the search algorithms.

Course given by: Gauthier PICARD, Professor. PhD. HDR at the Ecole des Mines de Saint-étienne.

Here is his statement of the problem: https://www.emse.fr/~picard/cours/ai/search/index.html

The source files were written by Pr. Gauthier PICARD, then completed by us following the exercices presented in the previous link.
The three following problems were modelised and solved by me and my colleague Younes Gueddari.

## 1st Problem: The Farmer's Problem
The farmer wants to get his goat, wolf and cabbage to the other side of the river. His boat isn't very big and it can only carry him and either his goat, his wolf or his cabbage. Now…..if he leaves the goat alone with the cabbage, the goat will gobble up the cabbage. If he leaves the wolf alone with the goat, the wolf will gobble up the goat. When the farmer is present, the goat and cabbage are safe from being gobbled up by their predators.

How does the farmer manage to get everything safely to the other side of the river?

* States: a state consists of an ordered sequence of four boolean variables (farmer,goat,cabbage,wolf). _true_ means that the corresponding item has moved to the other side of the river. Thus, the start state is (false,false,false,false). States have an additional boolean attribute _interdit_ which is false by default, and is set to true if the state is forbidden (goat and cabbage or goat and wolf left alone).
* Actions: 4 possible actions _"Farmer moves alone"_, _"Farmer moves goat"_, _"Farmer moves cabbage"_ and _"Farmer moves wolf"_. Every action will return a state with the negation of the sequence's elements which items has been moved.
* Goal state: (true,true,true,true).
* Path cost: unit cost, all actions are considered of a cost equal to 1.
