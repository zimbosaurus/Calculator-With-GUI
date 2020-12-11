package calculator.math.operators;

import calculator.math.Operand;
import calculator.math.Operator;

public class Mult implements Operator {

   
    public int priority() {
        
     return 3;
     
    }

   
    public Operand execute(Operand op1, Operand op2) {
        
      int sum;
      sum = op1.getValue() * op2.getValue();
      Operand solution = new Operand(sum);
      return solution;
        
    }

    
    public Operand execute(Operand op1) {
       return op1;
    }
    
}
