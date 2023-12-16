import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class DemoArrayList {
    public static void main(String[] args) {

//        ArrayList<Employee> staff = new ArrayList<Employee>();
        ArrayList<Employee> staff = new ArrayList<>(); // 简写，<>省略类型
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
        for (Employee e : staff) {
            System.out.println("name is " + e.getName() + " salary is " + e.getSalary());
        }

        staff.ensureCapacity(3);
        staff.trimToSize();
        Employee[] a = new Employee[staff.size()];
        staff.toArray(a);
        //
        ArrayList<Employee> staff2 = new ArrayList<>(100);
        System.out.println(staff2.size());

    }
}

abstract class Person {
    private String name;

    public String getName() {
        return this.name;
    }

    public abstract String getDesc();
}

class Employee extends Person {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return "employee";
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireDay() {
        return this.hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }


    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true; // 内存地址相等，指向同一个对象一定等


        }
        if (otherObject == null) {
            return false; // 一个为null，一个方法可以调用肯定不为null，肯定不等
        }
        if (this.getClass() != otherObject.getClass()) {
            return false; // 不是同一种类，一定不等
        }
        // now we know是，同一个类，且不为null
        Employee tmp = (Employee) otherObject;
//        return this.name.equals(tmp.name) && this.salary == tmp.salary && this.hireDay.equals(tmp.hireDay);
        return Objects.equals(this.name, tmp.name) && this.salary == tmp.salary && Objects.equals(this.hireDay, tmp.hireDay); // 考虑name和hirday对象对象，可能为空，才有Object的equals方法（会处理其中任何一方为null的情况）


    }
    @Override
    public String toString() {
        return this.getClass().getName() + "[name=" + this.name + ",salary=" + this.salary + ",hireDay=" + this.hireDay + "]";
    }
}

//final class Manager extends Employee { // extends 继承
class Manager extends Employee { // extends 继承

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day); // super不是对象引用，只是关键字，让虚拟机去调用父类的构造方法、或方法
        this.bonus = 0;
    }

    public double getSalary() {
//        return this.getSalary() + this.bonus; // 会调用自己的getSalary无限调用自己，直到崩溃
        return super.getSalary() + this.bonus;
    }
//
//    public final void setBonus(double bonus) {
//        this.bonus = bonus;
//    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus=" + this.bonus + "]";
    }
}


class CEO extends Manager { // ManagerTest.java:78: 错误: 无法从最终Manager进行继承 final修饰Manager后不可被继承
    public CEO(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    public void setBonus(double bonus) { // ManagerTest.java:83: 错误: CEO中的setBonus(double)无法覆盖Manager中的setBonus(double)
        super.setBonus(bonus);
    }
}

