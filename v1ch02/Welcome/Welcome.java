
public class Welcome {

    public static void main(String[] args) {
        String[] greeting = new String[3];

        greeting[0] = "hello";
        greeting[1] = "world";
        greeting[2] = "!";

        for(String s: greeting) {
            System.out.println(s);
        }

        // 1、javac Welcome.java(需要带.java后缀） 编译成Welcome.class文件，默认会输出到当前目录， 然后java Welcome执行（不需要带.class后缀），java会搜索名为Welcome的class文件
        // 2、javac：启动java编译器，将java源码编译为class文件；java 启动java虚拟机运行class文件
        // 3、注意区分大小写
    }
}