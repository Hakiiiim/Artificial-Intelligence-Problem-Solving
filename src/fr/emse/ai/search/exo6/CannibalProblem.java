package fr.emse.ai.search.exo6;

import fr.emse.ai.search.core.Problem;
import fr.emse.ai.search.exo6.SimpleState;

import java.util.ArrayList;
import java.util.Collection;

public class CannibalProblem implements Problem {

    SimpleState initialState = new SimpleState(3,3,true);
    SimpleState finalState = new SimpleState(0,0,false);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return state.equals(finalState);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        
    	ArrayList<Object> actions = new ArrayList<Object>();
        
    	//current state
    	Integer cannibals = ((SimpleState) state).cannibals;
    	Integer missionaries = ((SimpleState) state).missionaries;
    	boolean boat = ((SimpleState) state).boat;
        
        // five actions to take depending on the number of cannibals and missionaries at the side of the boat
    	// Move one cannibal
    	// Move two cannibals
    	// Move one missionary
    	// Move two cannibals
    	// Move one cannibal and one missionary
    	
        if (boat == true) {
        	if (cannibals >= 1) {
        		actions.add("Move one cannibal");
        		if (missionaries >= 1) {
            		actions.add("Move one missionary");
            		actions.add("Move one missionary and one cannibal");
                }
            } else {
                if (missionaries >= 1) {
            		actions.add("Move one missionary");
                }
            }
        	if (missionaries >= 2) {
        		actions.add("Move two missionaries");
            }
        	if (cannibals >= 2) {
        		actions.add("Move two cannibals");
            }
        }
        
        // when the boat is on the other side
        if (boat == false) {
        	if ((3-cannibals) >= 1) {
        		actions.add("Move one cannibal");
        		if ((3-missionaries) >= 1) {
            		actions.add("Move one missionary");
            		actions.add("Move one missionary and one cannibal");
                }
            } else {
                if ((3-missionaries) >= 1) {
            		actions.add("Move one missionary");
                }
            }
        	if ((3-missionaries) >= 2) {
        		actions.add("Move two missionaries");
            }
        	if ((3-cannibals) >= 2) {
        		actions.add("Move two cannibals");
            }
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
    	
    	//current side
    	Integer cannibals = ((SimpleState) state).cannibals;
    	Integer missionaries = ((SimpleState) state).missionaries;
    	boolean boat = ((SimpleState) state).boat;
    	
    	//when boat goes from east to west we substract the number of transfered individuals from their categories
    	if (boat == true) {
    		if (action.equals("Move one cannibal")) return new SimpleState(cannibals-1,missionaries,!boat);
        	if (action.equals("Move two cannibals")) return new SimpleState(cannibals-2,missionaries,!boat);
            if (action.equals("Move one missionary")) return new SimpleState(cannibals,missionaries-1,!boat);
            if (action.equals("Move two missionaries")) return new SimpleState(cannibals,missionaries-2,!boat);
            if (action.equals("Move one missionary and one cannibal")) return new SimpleState(cannibals-1,missionaries-1,!boat);
        }
        
    	//when boat comes back to eastern side we add the number of transfered individuals to their categories
    	if (boat == false) {
    		if (action.equals("Move one cannibal")) return new SimpleState(cannibals+1,missionaries,!boat);
        	if (action.equals("Move two cannibals")) return new SimpleState(cannibals+2,missionaries,!boat);
            if (action.equals("Move one missionary")) return new SimpleState(cannibals,missionaries+1,!boat);
            if (action.equals("Move two missionaries")) return new SimpleState(cannibals,missionaries+2,!boat);
            if (action.equals("Move one missionary and one cannibal")) return new SimpleState(cannibals+1,missionaries+1,!boat);
        }
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
