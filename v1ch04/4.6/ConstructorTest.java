import java.util.*;

public class ConstructorTest {
    public static void main(String[] args) {

        Employee[] staff = new Employee[3];
        staff[0] = new Employee("harry", 4000); // 101
        staff[1] = new Employee(6000); // 102
        staff[2] = new Employee(); // 103


        for (Employee e : staff) {
            System.out.println("id = " + e.getId() + ",name=" + e.getName() + ",salary=" + e.getSalary());
        }

        /*
        id = 153,name=harry,salary=4000.0
        id = 154,name=Employee #154,salary=6000.0
        id = 155,name=,salary=0.0

         */

    }
}


class Employee {
    private int id;
    private String name = ""; // 所有对象实例化时，name先都为“”
    private double salary;

    private static int nexId;

    static {
        // 类的，静态域，初始化块
        Random random = new Random();
        nexId = random.nextInt(1000);

    }

    {
        // 实例对象的初始化
        id = nexId;
        nexId++;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(double s) {
        this("Employee #" + nexId, s); // 说明了，实例构造器，在对象的初始化之前执行！

    }

    public Employee() {

    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

}