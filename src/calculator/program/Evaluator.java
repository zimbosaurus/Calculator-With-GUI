package calculator.program;

import calculator.math.Operand;
import calculator.math.operators.Hash;
import calculator.math.Operator;
import calculator.math.operators.Pound;

import java.util.*;

public class Evaluator {

    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;

    private StringTokenizer tokenizer;                //create a StringTokenizer
    private static final String DELIMITERS = "+-*^/#!() ";

    public Evaluator() {
        operandStack = new Stack<>();     //create 2 stacks
        operatorStack = new Stack<>();
    }

    public int eval(String expression) {
        String token;

        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        operatorStack.push(new Pound());            //add the Pound to the bottem of the stack

        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(token)) {
                    operandStack.push(new Operand(token));

                    System.out.println("The operand stack pushed: " + operandStack.peek().getValue());
                } else {
                    if (!(Operator.check(token))) {
                        System.out.println("*****invalid token******");
                        System.exit(1);
                    }

                    boolean check = true;       //I use this to detect parethesis

                    Operator newOperator = Hash.FindHash(token);
                    /*
                    if (operatorStack.size() == 2 && operandStack.size() == 1 && operatorStack.peek().priority() != 0) {
                        calculator.Operator oldOpr = operatorStack.pop();
                        calculator.math.Operand op2 = operandStack.pop();               //this detects negative numbers for example -5 + 6
                        operandStack.push(oldOpr.execute(op2));         // this will detect negative numbers at the beg of an expression
                    }                                                   // this breaks my code for the parenthises but it handles negatives however when implementing th parenthesis i stopped using this function.
                     */
                    while ((operatorStack.peek().priority() >= newOperator.priority() || newOperator.priority() == 1 && check == true)) {

                        if (operandStack.size() == 1 && operatorStack.peek().priority() == 2 && newOperator.priority() != 0) {
                            Operator oldOpr = operatorStack.pop();
                            Operand op2 = operandStack.pop();       //this is if you have one operand and 1 operator. This is to handle
                            operandStack.push(oldOpr.execute(op2)); //an edge case of +5, or -5 just so it doesnt break the code

                        } else if (newOperator.priority() == 1) {
                            //this detects ")" and instead of pushing it, it solves the
                            // expression until it finds a "(" and than pops it off

                            while (operatorStack.peek().priority() != 0) {
                                Operator oldOpr = operatorStack.pop();
                                Operand op2 = operandStack.pop();
                                Operand op1 = operandStack.pop();
                                operandStack.push(oldOpr.execute(op1, op2));
                            }

                            operatorStack.pop();

                            check = false;
                            break;
                        } else if (newOperator.priority() == 0) {
                            break;                                      //detects "(" and pushes it instead of operating on it
                        } else {
                            Operator oldOpr = operatorStack.pop();
                            Operand op2 = operandStack.pop();           //normal, order of operations
                            Operand op1 = operandStack.pop();
                            operandStack.push(oldOpr.execute(op1, op2));
                        }
                    }

                    if (newOperator.priority() != 1 && check == true) {
                        operatorStack.push(newOperator);
                        System.out.println("The operator stack pushed operator with priority: " + operatorStack.peek().priority());
                    }

                }
            }
        }

        return finalEvalutation();
    }

    public int finalEvalutation() {                 //this function is to evaluate the stacks of operator and operand incase
        //there are still operators / operand in the stacks and return it to eval func.
        while ((!operatorStack.isEmpty()) && operatorStack.peek().priority() != -1) {

            if (operandStack.size() == 1) {
                Operator oper1 = operatorStack.pop();  //this handles the case for whatever reason i have 1 operator and 1 operand
                Operand op1 = operandStack.pop();       // incase you do -(5+3) which will handle this case
                operandStack.push(oper1.execute(op1));

            } else {

                Operator oper1 = operatorStack.pop();
                Operand op2 = operandStack.pop();       //this is normal case
                Operand op1 = operandStack.pop();

                operandStack.push(oper1.execute(op1, op2));
            }
        }

        return operandStack.pop().getValue();
    }

}
