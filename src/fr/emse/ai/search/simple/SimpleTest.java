package fr.emse.ai.search.simple;

import fr.emse.ai.search.solver.DepthFirstTreeSearch;
import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
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
    	
        SimpleNotOrientedGraphProblem p2 = new SimpleNotOrientedGraphProblem();
        System.out.println("Solution to problem using depth first : ");
        
        System.out.println(new DepthFirstGraphSearch().solve(p2).pathToString());
        
        System.out.println(new BreadthFirstGraphSearch().solve(p2).pathToString());
    }
}

