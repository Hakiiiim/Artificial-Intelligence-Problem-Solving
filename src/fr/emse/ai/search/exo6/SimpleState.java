package fr.emse.ai.search.exo6;

public class SimpleState {

    public String value;
    
    public boolean interdit = false;
    
    //state is a list of three numbers : (cannibals, missionaries, boat)
    // they tell the number of cannibals and missionaries in the eastern side of the river (initial side)
    // boat is a boolean which means boat is on eastern side when true and the opposite when false
    //initial state is (3,3,true)
    //final state is (0,0,false)
    
    public Integer cannibals;
    public Integer missionaries;
    public boolean boat;

    public SimpleState(Integer cannibals,Integer missionaries, boolean boat) {
        this.cannibals = cannibals;
        this.missionaries = missionaries;
        this.boat = boat;
        
        //signature of the state
        this.value = String.valueOf(cannibals) + String.valueOf(missionaries) + String.valueOf(boat);
        
        //condition of a forbidden state : cannibals outnumber missionaries
        
        if (missionaries > 0) {
        	if ((cannibals > missionaries)) {
            	this.interdit = true;
            }
        }
        
        if ((3-missionaries) > 0) {
        	if ((3-cannibals) > (3-missionaries)) {
            	this.interdit = true;
            }
        }
        
    }
    


    public boolean equals(Object o) {
        if (o instanceof SimpleState) {
            return ((SimpleState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }

}
