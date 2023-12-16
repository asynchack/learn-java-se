import java.util.Arrays;

public class Main {
    public static void main(String[] args) {




        int n = 10;

        int[] a = new int[n]; // 数组大小可以是变量n

        for (int  i = 0 ; i < 10; i++) {
            a[i] = i;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        // 数组大小不可更改！但是数组内每个元素可以更改（更改引用地址即可，或者直接改值）
        // 数组大小需要更改的，用array list！

        for (int i : a) {
            System.out.println(i);
        }

        System.out.println(Arrays.toString(a));

        int[] b = new int[] {1, 2, 3};
        System.out.println(Arrays.toString(b));

        // array copy


        int[] c = a; // 数组拷贝，复制的引用地址，
        c[0] = 100;
        System.out.println(a[0]); // 100

        // 深拷贝
        int[] aCopy = Arrays.copyOf(a, a.length);
        aCopy[0] = 200;
        System.out.println(a[0]);

        int[] aCopy2 = Arrays.copyOf(a, a.length * 2);
        System.out.println(aCopy2.length);

        // 命令行参数
        if (args.length == 0 || args[0].equals("-h")) {
            System.out.println("hello.");
        } else if (args[0].equals("-g")) {
            System.out.println("good.");
        }

        for (int i = 1; i < args.length; i++) {
            System.out.print(" " + args[i]);
        }
        System.out.println("!");

        // sort 数组排序
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        // 比较
        int[] a1 = new int[] {1, 2, 3};
        int[] a2 = new int[] {1,3, 2};
        System.out.println(Arrays.equals(a1, a2));

        Arrays.fill(a1, 3);
        System.out.println(Arrays.toString(a1));


        // 二维数组
        int[][] magic = {
                {1,2, 3},
                {4, 5, 6},
                {7,8, 9}
        };

         for (int[] row : magic) {
//             System.out.println(Arrays.toString(row));
             for (int i : row) {
                 System.out.println(i);
             }
         }

        System.out.println(Arrays.deepToString(magic));

         // 多维数组，java中其实只有一组数据，所谓多维，就是把一组数据的元素，作为一个新的一维数组（存储的是它的引用），这样就可以无限嵌套；

    }
}