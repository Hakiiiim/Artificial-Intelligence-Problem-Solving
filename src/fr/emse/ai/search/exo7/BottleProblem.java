package fr.emse.ai.search.exo7;

import fr.emse.ai.search.core.Problem;
import fr.emse.ai.search.exo7.SimpleState;

import java.util.ArrayList;
import java.util.Collection;

public class BottleProblem implements Problem {

    SimpleState initialState = new SimpleState(12,3);
    SimpleState finalState = new SimpleState(0,5);

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
        
    	// Store the volumes of the two cans at this state
    	int A = ((SimpleState) state).A;
    	int B = ((SimpleState) state).B;       
        
    	// Actions that could be done in all cases 
    	actions.add("empty A");
    	actions.add("empty B");
    	
    	// if a bottle has space, it can be filled with the other
        if (A < SimpleState.CAP_A) {
        	actions.add("fill A with B");
        }
        
        if (B < SimpleState.CAP_B) {
        	actions.add("fill B with A");
        }
        
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
    	
    	int A = ((SimpleState) state).A;
    	int B = ((SimpleState) state).B;
    	
    	// empty actions just turn the volume of the corresponding can to 0
    	if (action.equals("empty A")) return new SimpleState(0,B);
    	if (action.equals("empty B")) return new SimpleState(A,0);
    	
    	// filling a bottle with the other has to check if this will empty the filling can or not
    	// in order to deal with negative values when writing A-(SimpleState.CAP_B-B)
    	
    	if (A <= (SimpleState.CAP_B-B)) {
    		if (action.equals("fill B with A")) return new SimpleState(0,B+A);
    	} else {
    		if (action.equals("fill B with A")) return new SimpleState(A-(SimpleState.CAP_B-B),SimpleState.CAP_B);
    	}
    	
    	// same here
    	if (B < (SimpleState.CAP_A-A)) {
    		if (action.equals("fill A with B")) return new SimpleState(A+B,0);
    	} else {
    		if (action.equals("fill A with B")) return new SimpleState(SimpleState.CAP_A,B-(SimpleState.CAP_A-A));
    	}
    	
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
