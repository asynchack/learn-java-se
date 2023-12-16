import java.time.LocalDate;
import java.util.*;
import java.time.*;



public class ManagerTest {

    public static void main(String[] args) {

        int a = 1;
        long b = a;
        System.out.println(a);
        System.out.println(b);

        int c = (int) b; // 高精度到低精度
        System.out.println(c);


        Manager ming = new Manager("ming", 10000, 1987, 12, 15);
        Employee li = new Manager("li", 10000, 1987, 12, 15);

        Employee ming2 = ming; // 子类转为父类，自动：因：拿到ming2后会对它进行操作，那么它无论什么操作，子类都有，无风险！

        Manager li2 = (Manager) li; // 父类转为子类 ，需要强制类型转换！子类（方法、域更多）那么得到li2后，就会把它当作Manager对象，进行操作，那么有可能操作子类特有的方法，比如setBonus（）父类没有，那不久g了，所以需要
        // 显式类型转换，且转换前提一定是li本来指向就是一个Manager对象（只是由Employee类型的变量引用接收了，因为父类的对象引用可以引用子类的对象，如line：20）

        // 总结：强制类型转换就是会出现在精度丢失、访问越界的时候，这时候就需要使用强制类型转换

        Manager boss = new Manager("Calvin", 10000, 1987, 12, 15);
        boss.setBonus(10000);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Harry", 10000, 1989, 10, 1);
        staff[2] = new Employee("Tom", 10000, 1990, 3, 15);

        for (Employee e : staff) {
            if (e instanceof Manager) {
                System.out.println("is manager");
            }
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary()); //变量e可以指向多种实际类型（这特性叫做多态）e.getSalary会根据e指向的具体对象调用不同的方法，针对Manager对象就是调用它的方法，，定位到不同方法的过程叫动态binding

        }
        staff[1] = new Manager("Harry", 10000, 1989, 10, 1);
//        staff[1].setBonus(10000); // 不存在，将子类引用赋给一个声明类型为父类的是可以的，但是如果是在数组中，那么一但调用子类独有方法，那么就会访问不属于它的内存，不对！
        // 需要转为Manager类型且成功后，才可以使用setBonus（）
        if (staff[1] instanceof Manager) {
            System.out.println("yes can operate manager method!");
            Manager tmp = (Manager) staff[1];
            tmp.setBonus(1);
            System.out.println(tmp.getSalary());
        }

        Employee e = new Manager("Harry", 10000, 1989, 10, 1);

        Person p = new Employee("lu", 100, 1999, 12, 20);
        System.out.println(p.getDesc());

        Employee wang = new Employee("wang", 1000000, 1996, 12, 20);
        Employee wang2 = new Employee("wang", 1000000, 1996, 12, 20);
        System.out.println(wang.equals(wang2));

        System.out.println("demo: toString()");
        System.out.println(e);
        System.out.println(wang);
        /* Object的默认实现
        Manager@2a139a55
        Employee@15db9742

         */

        int[] LuckyNumbers = {1, 3, 7, 9, 9 , 9};
        System.out.println("" + LuckyNumbers);
        // improved way
        System.out.println("" + Arrays.toString(LuckyNumbers));
//        Arrays.deepToString() // 多维数组
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

