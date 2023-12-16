import java.lang.reflect.*;

import java.lang.Math;

public class MethodTableTest {
    public static void main(String[] args) throws Exception{

        Method square = Math.class.getMethod("sqrt", double.class); // 获得sqrt的方法引用，即方法指针

        double res = (Double) square.invoke(null, 9.0); // sqrt 是静态，第一个表示实例对象的参数为null
        System.out.printf("%.4f\n", res);
//        Math.sqrt()
    }

    public static void printTable(double from, double to, int n, Method f) {
        System.out.println(f);

    }
}