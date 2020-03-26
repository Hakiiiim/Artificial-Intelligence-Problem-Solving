package fr.emse.ai.search.exo6;

import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;

public class SimpleTest {

    public static void main(String[] args) {
        /*
    	SimpleOrientedGraphProblem p1 = new SimpleOrientedGraphProblem();
        System.out.println("Solution to problem using depth first : ");
        
        System.out.println(new DepthFirstTreeSearch().solve(p1).pathToString());
        
        System.out.println(new BreadthFirstTreeSearch().solve(p1).pathToString());
        */
    	
    	CannibalProblem p2 = new CannibalProblem();
        System.out.println("Solution to problem using depth first : ");
        
        System.out.println(new DepthFirstGraphSearch().solve(p2).pathToString());
        
        System.out.println(new BreadthFirstGraphSearch().solve(p2).pathToString());
    }
}

