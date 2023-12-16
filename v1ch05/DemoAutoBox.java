import java.util.ArrayList;

public class DemoAutoBox {

    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(Integer.valueOf(3));
        // 2者相等，隐式自动装箱

        int i = list.get(0);
        System.out.println(i);
        int i2 = list.get(0).intValue();
        System.out.println(i2);
        // 自动拆箱


        Integer n = 3;
        n++; // 自动拆箱，++后，再装箱

        int x = Integer.parseInt("10");
        System.out.println(x);

        String s = Integer.toString(10);
        System.out.println(s);
    }
}