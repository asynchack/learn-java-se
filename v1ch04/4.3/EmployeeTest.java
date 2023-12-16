
import java.time.LocalDate;
import java.util.Date;


public class EmployeeTest {
    public static void main(String[] args) {

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);


        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            System.out.println("name is " + e.getName() + " salary is " + e.getSalary());
        }


        // test
        System.out.println(staff[0].getHireDay());
        LocalDate d = staff[0].getHireDay();
        d = d.minusDays(365);
        System.out.println(d);
        System.out.println(staff[0].getHireDay());
    }
}


class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;
//    final private String nickName;  // 53: 错误: 可能尚未初始化变量nickName
//    final private String nickName = "default";
//    final private String nickName;
    public boolean sameName(Employee other) {

        return this.name.equals(other.name);

        // 调用时，harry.sameName(boss) ，方法就会访问到boos的私有数据域，name，是合理的
    }

    public Employee( String name, double salary, int year, int month, int day) {
//        this.nickName = nickName; // 必需给final类型的赋值
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);

    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireDay () {
        return this.hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent /100;
        this.salary += raise;
    }
}