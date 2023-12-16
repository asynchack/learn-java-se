
import java.util.*;
import java.io.*;
import java.nio.file.*;
public class Main {
    public static void main(String[] args) throws Exception {


//        Scanner in = new Scanner(System.in);
//
//        System.out.println("name");
//        String name = in.nextLine();
//
//
//        System.out.println("age:");
//        int age = in.nextInt();
//
//        System.out.println("hello: " + name + " your age is : " + age );
//
//
//       Console cs = System.console();
//        String username = cs.readLine("name");
//        char[] password = cs.readPassword("password");
//
//        //
//        System.out.printf("hell %s, age is  %d %n", username, age); // %s可以打印任何对象（实现了Formattable接口的对象，或者有toString（）方法的对象
//
//        String mesage = String.format("hell %s, age is  %d %n", username, age); // %s可以打印任何对象
//        System.out.println(mesage);
//
//        System.out.printf("%tc", new Date());


        Scanner in = new Scanner(Paths.get("myfile.txt"), "UTF-8");
        String name = in.nextLine();
        System.out.println(name);

        Scanner in2 = new Scanner("good");
        String name2 = in2.nextLine();
        System.out.println(name2);

        String dir = System.getProperty("user.dir");
        System.out.println(dir);

    }
}
