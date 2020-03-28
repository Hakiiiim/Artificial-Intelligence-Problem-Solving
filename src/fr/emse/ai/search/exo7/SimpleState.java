package fr.emse.ai.search.exo7;

public class SimpleState {

    public String value;
    
    // no forbidden states so value kept to false
    public boolean interdit = false;
    
    //capacity of the two cans
    public final static int CAP_A = 15;
    public final static int CAP_B = 5;
    
    //volumes at the actual state
    public int A;
    public int B;


    public SimpleState(int A,int B) {
        this.A = A;
        this.B = B;
        
        // signature of the state
        this.value = String.valueOf(A) + "_" + String.valueOf(B);
        
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
