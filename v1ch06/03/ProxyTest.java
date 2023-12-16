import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        for (int i = 0; i < elements.length; i++) {
            Integer value = i +1;
            InvocationHandler handler = new TraceHandler(val

                    ue); // 1000个Intger的，1000个代理类实例

            Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length) +1;
        int result = Arrays.binarySearch(elements, key);

        if (result >= 0) {
            System.out.println(elements[result]);
        }


    }
}

class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object target) {
        this.target = target; // 要代理的obj

    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.print(this.target);

        System.out.println("." + m.getName() + "(");

        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
                if (i < args.length - 1) System.out.println(", ");

            }
        }
        System.out.println(")");

        return m.invoke(target, args); // 调用方法：传参为方法要操作的实例，以及方法所需参数

    }
}