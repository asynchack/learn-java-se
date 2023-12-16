import static  java.lang.System.*;

import com.wang.learnjava.*;
/**
 * 没有定义package，默认就是default package中，
 */
public class DemoCP {
    public static void main(String[] args) {

        com.wang.learnjava.Person p = new com.wang.learnjava.Person("wang", 18);
        p.getName();
        out.println(p.getName());
    }
}