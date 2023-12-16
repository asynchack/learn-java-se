import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class DemoReflector {
    public static void main(String[] args) throws Exception {
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Class cls = harry.getClass(); // 描述Employee的Class实例
        Field f = cls.getDeclaredField("name"); // 得到描述Employee的name字段的Filed实例
//        Object v = f.get(harry); // 得到harry对象的，name字段的值，这里就是"Harry Hacker"
//        String res = (String) v;
//        System.out.println(res); // 不可访问 ，java安全机制 Exception in thread "main" java.lang.IllegalAccessException: Class DemoReflector can not access a member of class Employee with modifiers "private"

        f.setAccessible(true); // 设置允许访问私有字段，Fileds的父类AccessibleObject的方法
        Object v = f.get(harry); // get针对类类型可以，针对基本类型比如double，有getDouble（）方法，会自动包装为Double
        String res = (String) v;
        System.out.println(res); // 可以访问了

        // 也可以设置了
        f.set(harry, "Tom");
        System.out.println(harry); // Employee[name=Tom,salary=50000.0,hireDay=1989-10-01] 可以修改harry的name字段的值


    }
//    public static void main(String[] args) throws Exception {
////        // method1
////        Random r = new Random();
////        Class cls = r.getClass();
////        String name = cls.getName();
////        System.out.println(name);
////
////        // method2
////
////        String className = "java.util.Random";
////        Class cls2 = Class.forName(className);
////        System.out.println(cls2.getName());
////
////
////        // method2
////        Class cl3 = Random.class;
////        Class cl4 = int.class; // 基本类型
////        Class cl5 = Double[].class;
////        System.out.println(cl3.getName());
////        System.out.println(cl4.getName());
////        System.out.println(cl5.getName());
////
////        // 根据Class对象，构造类的对象
////
////        Object m = Class.forName("java.util.Random").newInstance(); // m 是一个Random的实例（调用无参数构造器具，生成的）如果没有无参构造器，就报错，需要有有参数构造，就使用Constructor类
////
//
//        String name;
//        if (args.length > 0) name = args[0];
//        else {
//            Scanner in = new Scanner(System.in);
//            System.out.println("Enter class name(e.g. java.util.Random):");
//            name = in.next();
//
//        }
//
//        try {
//
//            // 根据字符串名称获取类的描述信息，即它的Class类的实例（描述类类的元信息）
//            Class cl = Class.forName(name);
//            System.out.println(cl.getName()); // 类的全名
//            Class supercl = cl.getSuperclass(); // 父类的类描述对象
//
//            //
//            String modifiers = Modifier.toString(cl.getModifiers()); // 判断类的范围：public private
//
//            if (modifiers.length() > 0) System.out.println(modifiers + " ");
//
//            System.out.println("class " + name);
//
//            if (supercl != null && supercl != Object.class) { // 不是Object类的直接子类
//                System.out.println("extends from " + supercl.getName());
//            }
//            System.out.println("\n{\n");
//            printconstructor(cl);
//            System.out.println("--all methods");
//            printMethods(cl);
//            System.out.println("--all fileds");
//            printFields(cl);
//
//            System.out.println("}");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods(); // 某个类的所有方法的列表，每一项，都描述类类的一个方法、
        for (Method method : methods) {
            Class retType = method.getReturnType();
            String name = method.getName();

            System.out.println(" ");
            String modifiers = Modifier.toString(method.getModifiers()); // 方法的修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            Class[] paramTypes = method.getParameterTypes(); // 方法的所有参数，每一项也是一个Class实例
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0 ) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl) {
        Field[] fields = cl.getFields();
        for (Field f: fields) {
            Class type = f.getType(); // 每个字段的类型，返回也是一个Class实例
            String name = f.getName(); // 字段的名称
            System.out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers()); // 字段的修饰符
            if (modifiers.length() > 0 ) System.out.print(modifiers + " ");
            System.out.print(type.getName() + " " + name);
            System.out.println(");");
        }
    }

    public static void printconstructor(Class cl) {
        Constructor[] constructors = cl.getConstructors(); // 某个类的所有构造器的列表，每一项，都描述类类的一个构造方法（它们属于Constructor类）

        for (Constructor c : constructors) {
            String name = c.getName(); // 方法名
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers()); // 构造器的修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // print parameter types ;参数自然是一个个的类型，内置的或自定义的
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }

    }
}

class Employee  {
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
