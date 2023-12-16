import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Good g = new Student();
        System.out.println(g.good());
    }
}


 class Student implements Good {
    public String good() {
        return "stu";
    }
}
interface Good {
    String good();

   default String bad() { return "default"; } // 新增的方法定义，定义为default即可
}