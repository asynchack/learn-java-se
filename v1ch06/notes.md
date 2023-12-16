# 接口

1. 接口的方法默认都是public修饰

2. 接口不能有域，但可以有常量

3. 接口的默认方法（包含实现）

   1. 接口定义变动时（增加方法定义，为了保持老代码使用老接口的正常运行，一般都需要把新增方法添加为default，否则会报错）

   ```java
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
   
      default String bad() { return "default"; } // 新增的方法定义，定义为default保证，原有代码正常
   }
   ```

   

4. 接口可以定义静态方法（包含实现）

5. 接口与抽象类

   1. 抽象类：和正常类一样，除了有些方法没有实现（可能等待子类继承后实现）需要加上abstract修饰，那么类也成了抽象类
   2. 接口：全部方法都是定义，无实现（如果要实现，就需要加上default、或static修饰），不能有域，只能有常量
   3. **均不可实例化，但是可以持有子类、或者实现类的对象引用**

# lamba表达式

1. 为什么引入lamaba表达式，支持回调，deffer function？
2. 函数式接口
3. 方法引用
4. 构造器引用
5. 变量作用域（闭包）
6. 内部类
   1. 内部类，隐式的被添加了一个引用，指向自己所属的外部类的实例
   2. 局部内部类：如果只有一个外部类方法用的内部类，那么可以定在在这个方法内部（外部类其他方法也看不到）
   3. 静态内部类：没有被隐式的添加指向外部类实例的引用，



# 代理

1. 

