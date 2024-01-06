import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Scanner;

public class StackTraceTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter n:");
        int n = in.nextInt();
        factorial(n);

//        Throwable t = new Throwable();
//        StringWriter out = new StringWriter();
//        t.printStackTrace(new PrintWriter(out));
//        String desc = out.toString();
//        System.out.println(desc);
//        Throwable t = new Throwable();

        //
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Thread t : map.keySet()) {
            StackTraceElement[] frames = map.get(t);
            for (StackTraceElement f : frames) {
                System.out.println(f);
            }
        }

    }

    public static int factorial(int n) {
        System.out.println("factorial(" + n + ")");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames) {
            System.out.println(f);
        }
        int r;
        if (n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;

    }
}