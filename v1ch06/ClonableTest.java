import javax.swing.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClonableTest {
    public static void main(String[] args) {
        Employee harry = new Employee("Harry Hacker", 50000);
        Employee clone = null;
        try {
            clone = harry.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone.raiseSalary(100);
        clone.setHireDay(1990, 1, 1);
        clone.setName("wang");
        System.out.println(clone);
        System.out.println(harry);

        System.out.println();
    }
}
class Employee implements Cloneable {

    private String name;
    private double salary;

    private Date hireDay;

    public void setName(String name) {
        this.name = name;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }

    public Employee clone() throws  CloneNotSupportedException {
        Employee cloned = (Employee) super.clone(); // 浅克隆
        cloned.hireDay = (Date) hireDay.clone(); // 引用类型且可变的需要单独克隆一下（String因为不可变所以安全）
        return cloned;

    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        this.hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}