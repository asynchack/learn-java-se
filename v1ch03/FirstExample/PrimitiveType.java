import java.lang.Math;

enum Size  {SMALL, MEDIUM, LARGE, EXTRA_LARGE}

public class PrimitiveType {

    public final static int A = 200; // 静态常量，即类常量，无需类实例和即可使用



    public static void main(String[] args) { // 静态方法，即类方法

        // 8 种基本类型
        /*
        byte
        short
        int
        long

        float 4字节
        double  8字节

        char

        boolean
         */


//        byte b = 1; // 1字节
//
//        short s = 1; // 2字节
//
//        int i = 1; // 4字节
//
//        long l = 1L; // 8字节 8*8 64位
//        long l2 = 1l;

        /*
            二进制0b 0B开头
            8进制0 0开头
            16进制0x 0X开头
            long长整形 L或l后缀
         */

        byte b = -127;
        System.out.printf("byte: %d%n", b);

        short s = 32767;
        System.out.printf("short: %d%n", s);

        int i = -2147483647;
        System.out.printf("int: %d%n", i);

        long l = 9223372036854775807L;
        System.out.printf("long: %d%n", l);

        float f = 1.23456789f;
        System.out.printf("float: %f%n", f);

        double d = 1.2345678901234567d;
        System.out.printf("double: %f%n", d);
        double d2 = 1.2345678901234567;


        char c = 'a';
        System.out.printf("char: %c%n", c);

        boolean bool = true;
        System.out.printf("boolean: %b%n", bool);

        // 进制
        byte i2 = 0b1010;
        int i8 = 012;
        long i16 = 0xA;
        System.out.printf("i2: %d%n", i2);
        System.out.printf("i8: %d%n", i8);
        System.out.printf("i16: %d%n", i16);


        System.out.println("#char:");
        // char 字母量用单引号 '' 包起来，字符串才用 ""包起来
        // 'A' 是 char基本类型，"A" 就是字符串类型了
        // char 是2字节，16bit位，可以表示65536个点位（对应的unicode字符）
        char c1 = '\u03c0';
        System.out.printf("%c%n", c1);
        char c2 = '\u0041'; // A 16进制，转为十进制是65，对应A
        System.out.printf("%c%n", c2);
        char c3 = '\u0040';
        System.out.printf("%c%n", c3); // 64 对应@符号


        char c4 = '\u738B';
        System.out.printf("%c%n", c4);
        char c5 = '\u535A';
        System.out.printf("%c%n", c5);
        char c6 = '中';
        System.out.printf("%c%n", c6);

        // 类型转换
        float tmp = (float) d2; // 高精度到低精度，需要强制类型转换
        double tmp2 = tmp; // 反之不需要
        /*
        PrimitiveType.java:57: 错误: 不兼容的类型: 从double转换到float可能会有损失
        float tmp = d2;
         */

        // 3.4 变量

        double salary;
//        System.out.printf("%d%n", salary); // PrimitiveType.java:104: 错误: 可能尚未初始化变量salary 用之前需要显式初始化
        salary = 100000000;
        System.out.printf("%f%n", salary);

        // 3.4.2 常量

        final int constDemo = 100;
        System.out.printf("%d%n", constDemo);
//        constDemo = 200;

        System.out.println(A);

        // 3.5 运算符
        System.out.println("---3.5 运算符");

        System.out.printf("%d%n", 15 / 2); // 7

        System.out.printf("%f%n", 15 / 2.0); // 7.5

        System.out.printf("%d%n", 15 % 2); // 1 取余

        double x = 4;
        double y = Math.sqrt(x);
        System.out.println(y);

        double z = Math.pow(2, 3);
        System.out.println(z);
        double z2 = 9.197;
        int nx = (int) Math.round(z2);
        System.out.println(nx);

        int z3 = 3;
        z3 += 3.5; // 类型不同，强制转为=左边的类型
        System.out.printf("%d%n", z3);

        // 3.5.6 关系和boolean运算符
        System.out.println("---3.5.6 关系和boolean运算符");
        if (3 == 3) {
            System.out.println("3 == 3");
        }
        if (3 != 4) {
            System.out.println(" 3 != 4");
        }

        int a = 0;
        int bb = 0;
        int res = a == bb ? 1 : 0;
        System.out.println(res);

        // 3.5.9 枚举 enum
        System.out.println("---3.5.9 枚举 enum");
        Size ss = Size.SMALL;
        System.out.println(s);




    }
}