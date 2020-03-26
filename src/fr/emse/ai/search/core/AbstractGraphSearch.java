package fr.emse.ai.search.core;

import java.util.ArrayList;
import java.util.Collection;


import fr.emse.ai.search.exo7.SimpleState;

/**
 * Created with IntelliJ IDEA.
 * User: picard (picard@emse.fr)
 * Date: 09/09/15
 * Time: 15:41
 */
public abstract class AbstractGraphSearch implements Search {

    Collection<Node> frontier;
    // arraylist to store the visisted states
    ArrayList<Object> visited = new ArrayList<Object>();

    public Node solve(Problem problem) {
        // multiple added system.out.print useful for debugging
    	
    	// initialize fringe
        System.out.println("Solving...");
        
        frontier = initFrontier();
        frontier.addAll(expand(new Node(problem.getInitialState()), problem));
        
        //first visited state is the initial state
        visited.add(problem.getInitialState());
        
        System.out.println("Starting frontier is " + frontier);
        
        boolean done = false;
        Node solution = null;
        while (!done) {
            if (frontier.isEmpty()) {
                System.out.println("No more nodes in frontier => FAILURE");
                done = true;
            } else {
                Node node = chooseLeafNode(frontier, problem);
                // getting the current state apart in the variable "etat"
                Object etat = node.getState();
                
                System.out.println("\n Visited states are " + visited);
                System.out.println("state of current node is " + etat);
                
                //two conditions to verify: if state is not visited and if state is not forbidden
                if (!visited.contains(etat) && !((SimpleState) etat).interdit) {
                	visited.add(etat);
                	
                	System.out.println("Inspecting node " + node);
                	System.out.println("test " + node.getState());
                    
                	if (problem.isGoal(node.getState())) {
                        System.out.println("Goal node reached => SUCCESS");
                        solution = node;
                        done = true;
                    } else {
                        frontier.addAll(expand(node, problem));
                        System.out.printf("Expanding node, frontier is " + frontier);
                    }
                }
            }
        }
        return solution;
    }

    public Collection<Node> expand(Node node, Problem problem) {
        Collection<Node> nodes = new ArrayList<Node>();
        Collection<Object> actions = problem.getActions(node.getState());
        
        System.out.printf("actions " + actions + "\n");
        
        for (Object action : actions) {
            Object next = problem.getNextState(node.getState(), action);
            // System.out.printf("\n next " + next); 
            nodes.add(new Node(next, node, action, problem.getStepCost(node.getState(), action, next)));
        }
        return nodes;
    }

    public abstract Collection<Node> initFrontier();

    public abstract Node chooseLeafNode(Collection<Node> frontier, Problem problem);
}
