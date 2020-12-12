package calculator.program;

import calculator.math.ConcreteEvaluator;
import calculator.math.Evaluator;

public class EvaluatorTester {
  public static void main(String[] args) {

    Evaluator ev = new ConcreteEvaluator();
    String exp = " (6 +3) * ( 7 + 2) " ;
    int x = ev.eval(exp);
    System.out.println(x);
    
    
   
}


}
