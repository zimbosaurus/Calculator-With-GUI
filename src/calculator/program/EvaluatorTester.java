package calculator.program;

public class EvaluatorTester {
  public static void main(String[] args) {

    Evaluator ev = new Evaluator();
    String exp = " (6 +3) * ( 7 + 2) " ;
    int x = ev.eval(exp);
    System.out.println(x);
    
    
   
}


}
