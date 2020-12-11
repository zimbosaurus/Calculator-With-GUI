package calculator.math.operators;

import calculator.math.Operator;

import java.util.HashMap;

public class Hash {

    public static HashMap<String, Operator> hash = new HashMap<>();

    public static Operator FindHash(String Token) {

        Operator newOp = hash.get(Token);
        return newOp;

    }

    static {

        hash.put("+", new Add());
        hash.put("-", new Minus());
        hash.put("*", new Mult());
        hash.put("/", new Div());
        hash.put("^", new Bang());
        hash.put("#", new Pound()); // I made the Pound operator value = to -1, This made handeling parethenis super efficent and easy
        hash.put(")", new ExclamationOperator());  // this is the ")" token  and has priorty of 1
        hash.put("(", new OpenP()); // this is new I added its for the open parethensis and I made its priortiy 0, "(" token

    }

}
