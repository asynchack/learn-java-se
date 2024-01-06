import java.time.LocalDate;
import java.time.*;


public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager cfo = new Manager("Harry Hacker", 50000, 1989, 10, 1);

        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddisies(buddies);

        ceo.setBonus(10000);
        cfo.setBonus(5000);
        Manager[] managers = {ceo, cfo};

        Pair<Employee> result = new Pair<>();
        minMaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + " second: " + result.getSecond().getName());

        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + " second: " + result.getSecond().getName());




    }

    public static  void maxminBonus(Manager[] a, Pair<? super  Manager> result) {
        minMaxBonus(a, result);
        PairAlg.swaphelper(result);
    }

    public static void minMaxBonus(Manager[] a, Pair<? super Manager> result) { // result，泛型类，? super Manater 代表，是Manager的父类，比如Employee（范围大，内部操作操作的是Manager，那么更大范围的Employee就可以接收Manager）

        // 直观地讲，带有超类型限定的通配符可以向泛型对象写人，带有子类型限定的通配符可 以从泛型对象读取。

        if (a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min); // 写入！
        result.setSecond(max);
    }
    public static void printBuddisies(Pair<? extends Employee> p) { // ？ extend Employee 代表是Employee的子类，那么就可以当作Emloyee处理，首先父类类型一定可以接收子类类型，且操作的方法和域，一定不会超过子类具有的能力
        Employee first = p.getFirst(); // 读取！父类接收
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }
}

class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) {
        swaphelper(p);

    }

    public static <T> void swaphelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }
    public void setSecond(T second) {
        this.second = second;
    }
}

class Employee
{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}



 class Manager extends Employee
{
    private double bonus;

    /**
     @param name the employee's name
     @param salary the salary
     @param year the hire year
     @param month the hire month
     @param day the hire day
     */
    public Manager(String name, double salary, int year, int month, int day)
    {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double b)
    {
        bonus = b;
    }

    public double getBonus()
    {
        return bonus;
    }
}