package fr.emse.ai.search.exo5;

import fr.emse.ai.search.core.Problem;
import fr.emse.ai.search.exo5.SimpleState;

import java.util.ArrayList;
import java.util.Collection;

public class FarmerProblem implements Problem {

    SimpleState initialState = new SimpleState(false,false,false,false);
    SimpleState finalState = new SimpleState(true,true,true,true);

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
    	boolean farmer = ((SimpleState) state).farmer;
    	boolean goat = ((SimpleState) state).goat;
    	boolean cabbage = ((SimpleState) state).cabbage;
    	boolean wolf = ((SimpleState) state).wolf;
    	
    	//four possible actions :
    	// Farmer moves alone
    	// Farmer moves goat
    	// Farmer moves cabbage
    	// Farmer moves wolf
        
    	// always possible action
        actions.add("Farmer moves alone");
        
        // Farmer will be able to move the items on his side
        if (farmer == true) {
        	if (goat == true) {
        		actions.add("Farmer moves goat");
            }
        	if (cabbage == true) {
        		actions.add("Farmer moves cabbage");
            }
        	if (wolf == true) {
        		actions.add("Farmer moves wolf");
            }
        }
        
        //same for the other side
        if (farmer == false) {
        	if (goat == false) {
        		actions.add("Farmer moves goat");
            }
        	if (cabbage == false) {
        		actions.add("Farmer moves cabbage");
            }
        	if (wolf == false) {
        		actions.add("Farmer moves wolf");
            }
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
    	
    	//current side
    	boolean farmer = ((SimpleState) state).farmer;
    	boolean goat = ((SimpleState) state).goat;
    	boolean cabbage = ((SimpleState) state).cabbage;
    	boolean wolf = ((SimpleState) state).wolf;
        
    	//negative of the ancient values for the moved items (Farmer + one other)
    	if (action.equals("Farmer moves alone")) return new SimpleState(!farmer,goat,cabbage,wolf);
    	if (action.equals("Farmer moves goat")) return new SimpleState(!farmer,!goat,cabbage,wolf);
        if (action.equals("Farmer moves cabbage")) return new SimpleState(!farmer,goat,!cabbage,wolf);
        if (action.equals("Farmer moves wolf")) return new SimpleState(!farmer,goat,cabbage,!wolf);
    	
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
