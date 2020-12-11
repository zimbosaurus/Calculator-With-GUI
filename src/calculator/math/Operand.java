package calculator.math;

public class Operand {

    private int value;
    private String token;

    public Operand(String token) {

        this.token = token;
        setvalue(Integer.parseInt(token));

    }

    public Operand(int value) {

        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public void setvalue(int value) {

        this.value = value;

    }

    public static boolean check(String token) {

        try {
            Integer.parseInt(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
