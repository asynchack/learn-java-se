
public class StaticTest {
    public static void main(String[] args) {
        System.out.println("test for employee");

    }
}


class Employee {

    private String name;
    private int age;

    private static int nextId = 1;


    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    private static int getNextId() {
        return nextId;
    }

    public static void main(String[] args) {
        // 这个类的main方法，用于类的单元测试
        Employee e = new Employee("Harry Hacker", 50000);
        System.out.println(e.name);
    }

}