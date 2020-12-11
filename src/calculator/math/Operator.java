package calculator.math;

/**
 *
 * @author ferasalazzeh
 */
public interface Operator {

    int priority();

    Operand execute(Operand op1, Operand op2);

    Operand execute(Operand op1);

    static boolean check(String token) {

        return token.matches("[-+/*^() ]");

    }

}
