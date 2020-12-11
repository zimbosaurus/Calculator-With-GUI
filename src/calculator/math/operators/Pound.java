package calculator.math.operators;

import calculator.math.Operand;
import calculator.math.Operator;

public class Pound implements Operator {


    public int priority() {
    return -1;
    }


    public Operand execute(Operand op1, Operand op2) {
       
        return null;
    }

   
    public Operand execute(Operand op1) {
        return null;
    }
    
    
    
    
    
}
