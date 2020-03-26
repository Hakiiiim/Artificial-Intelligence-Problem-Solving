package fr.emse.ai.search.exo5;

public class SimpleState {

    public String value;
    
    public boolean interdit = false;
    
    //state is a list of four booleans : (farmer,goat,cabbage,wolf)
    // they tell the side of each one of them : false for eastern (initial state) side
    //initial state is (false,false,false,false)
    //final state is (true,true,true,true)
    
    public boolean farmer;
    public boolean goat;
    public boolean cabbage;
    public boolean wolf;

    public SimpleState(boolean farmer,boolean goat, boolean cabbage, boolean wolf) {
        this.farmer = farmer;
        this.goat = goat;
        this.cabbage = cabbage;
        this.wolf = wolf;
        
        //signature of the state
        this.value = String.valueOf(farmer) + String.valueOf(goat) + String.valueOf(cabbage) + String.valueOf(wolf);
        
        // forbidden states: when goat and wolf or goat and cabbage are alone
        if (farmer == true) {
        	if (((goat == false)&&(wolf == false))||((goat == false)&&(cabbage == false))) {
        		this.interdit = true;
            }
        }
        
        if (farmer == false) {
        	if (((goat == true)&&(wolf == true))||((goat == true)&&(cabbage == true))) {
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
