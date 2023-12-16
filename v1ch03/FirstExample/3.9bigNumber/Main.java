
import java.math.*;

public class Main {
    public static void main(String[] args) {

            BigInteger a = BigInteger.valueOf(100);
            BigInteger b = BigInteger.valueOf(200);

            BigInteger c = a.add(b);

            BigInteger d = c.multiply(b);


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}