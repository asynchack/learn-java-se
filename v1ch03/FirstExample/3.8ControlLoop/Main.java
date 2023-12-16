import java.util.*;
public class Main {

//    @SuppressWarnings("fallthrough")
    public static void main(String[] args) {

        int n ;
        {
            int k = 0;
//            int n; // can not define
        }
//        System.out.println(k); // not define here ,k


        n = 0;
        while ( n <= 10) {
            System.out.println(n);
            n++;
        }

        int k = 0;
        do {
            System.out.println(k);
            k++;
        } while ( k < 0);

        for (int i = 0; i <= 10 ; i++ ) {
            System.out.println(i);
        }

        Scanner in = new Scanner(System.in);
        int i = in.nextInt();


        switch (i) {
            case 1:
                System.out.println(1);
//                break; !! 应该有break，不然会执行知道遇到下一个break或结束
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println(0);
        }
    }
}