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

   1. 支持配置一段代码（具备一定功能）然后在未来某个时间点，或者时间到了之后执行

2. 函数式接口

   1. what？很多方法行参，需要接收一个接口类型的实例，正常情况下，就是需要一个类实现该接口所有方法，然后根据该类实例化一个对象，将其作为方法所需的实参，
   2. java提供了一个简单的方法，直接给这个位置，传递一个函数定义即可，**java不支持传递一个代码片段作为变量**，猜测：应该是给讲给定的函数包装为了一个匿名类里面，且给它实例化出来一个，作为参数传递，那么**这个函数片段就需要是符合接口中所需要的方法定义，且一般该接口只有一个方法定义，且用@FunctionalInterface注解标识，这样的接口叫做函数式接口

   ```java
   import java.util.Comparator;
   import java.util.function.IntConsumer;
   
   public class IntConsumerTest {
       public static void  main(String[] args) {
   
           Comparator
           repeat(10, i -> System.out.println("cont" + (9-i)));
   
       }
       public static void repeat(int n, IntConsumer action) {
           for (int i = 0; i < n ; i++ ) {
               action.accept(i);
           }
       }
   }
   # i -> System.out.println("cont" + (9-i)) 就是符合void accept(int value)定义，所以是实现了该接口
     
   # IntConsumer的接口定义
     /*
    * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
    * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
    *
    * This code is free software; you can redistribute it and/or modify it
    * under the terms of the GNU General Public License version 2 only, as
    * published by the Free Software Foundation.  Oracle designates this
    * particular file as subject to the "Classpath" exception as provided
    * by Oracle in the LICENSE file that accompanied this code.
    *
    * This code is distributed in the hope that it will be useful, but WITHOUT
    * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
    * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
    * version 2 for more details (a copy is included in the LICENSE file that
    * accompanied this code).
    *
    * You should have received a copy of the GNU General Public License version
    * 2 along with this work; if not, write to the Free Software Foundation,
    * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
    *
    * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
    * or visit www.oracle.com if you need additional information or have any
    * questions.
    */
   package java.util.function;
   
   import java.util.Objects;
   
   /**
    * Represents an operation that accepts a single {@code int}-valued argument and
    * returns no result.  This is the primitive type specialization of
    * {@link Consumer} for {@code int}.  Unlike most other functional interfaces,
    * {@code IntConsumer} is expected to operate via side-effects.
    *
    * <p>This is a <a href="package-summary.html">functional interface</a>
    * whose functional method is {@link #accept(int)}.
    *
    * @see Consumer
    * @since 1.8
    */
   @FunctionalInterface
   public interface IntConsumer {
   
       /**
        * Performs this operation on the given argument.
        *
        * @param value the input argument
        */
       void accept(int value);
   
       /**
        * Returns a composed {@code IntConsumer} that performs, in sequence, this
        * operation followed by the {@code after} operation. If performing either
        * operation throws an exception, it is relayed to the caller of the
        * composed operation.  If performing this operation throws an exception,
        * the {@code after} operation will not be performed.
        *
        * @param after the operation to perform after this operation
        * @return a composed {@code IntConsumer} that performs in sequence this
        * operation followed by the {@code after} operation
        * @throws NullPointerException if {@code after} is null
        */
       default IntConsumer andThen(IntConsumer after) {
           Objects.requireNonNull(after);
           return (int t) -> { accept(t); after.accept(t); };
       }
   }
   
   ```

   

3. 方法引用

   1. Class::静态方法名
   2. Object:instanceMethod
   3. Class:instanceMethod

4. 构造器引用

   1. Person::new()

   ```java
   Stream<Person> stream = names.stream().map(Person::new)
   ```

   

5. 变量作用域（闭包）

   1. 在lamda表达式引用外部作用域的变量，就是闭包（python也有）

6. 内部类

   1. 内部类，实例化时，隐式的被添加了一个引用，指向自己所属的外部类的实例
   2. 局部内部类：如果只有一个外部类方法用的内部类，那么可以定在在这个方法内部（外部类其他方法也看不到）
   3. 静态内部类：没有被隐式的添加指向外部类实例的引用，

   ```java
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.ActionEvent;
   import java.awt.event.ActionListener;
   import java.util.Date;
   
   public class InnerClassTest {
       public static void main(String[] args) {
   
           TalkingClock clock = new TalkingClock(1000, true);
           clock.start();
   
       }
   }
   
   
   class TalkingClock {
       private int interval;
       private boolean beep;
   
       public TalkingClock(int  interval, boolean beep) {
           this.interval = interval;
           this.beep = beep;
       }
   
       public void start() {
           ActionListener listener = new TimePrinter(); // 构造时，自动添加了new TimePrinter(this)把自己的引用传入内部类实例，使其可以访问外部类的数据
           Timer t = new Timer(interval, listener);
           t.start();
       }
   
       // inner class
   
       private class TimePrinter implements ActionListener {
           public void actionPerformed(ActionEvent event) {
               System.out.println("at the tone, the time is " + new Date());
               if (beep) Toolkit.getDefaultToolkit().beep(); // if (beep)是内部类访问的自己所属于的外部类示例的beep域，（隐式的，java给TimePrinter每个实例加了一个引用（指向自己所属于的TalkingClock的实例，所以才能访问它的数据）
   
           }
       }
   }
   
   ```

   



# 代理

1. 代理可以声称自己实现了哪些接口，然后给调用方使用，实际上，是讲请求转发到了实际实现了这些接口的类的，实例上，代理层还可以做一些增强、检测、审计等功能（类似python的包装器？）

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        for (int i = 0; i < elements.length; i++) {
            Integer value = i +1;
            InvocationHandler handler = new TraceHandler(val

                    ue); // 1000个Intger的，1000个代理类实例

            Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length) +1;
        int result = Arrays.binarySearch(elements, key);

        if (result >= 0) {
            System.out.println(elements[result]);
        }


    }
}

class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object target) {
        this.target = target; // 要代理的obj

    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.print(this.target);

        System.out.println("." + m.getName() + "(");

        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
                if (i < args.length - 1) System.out.println(", ");

            }
        }
        System.out.println(")");

        return m.invoke(target, args); // 调用方法：传参为方法要操作的实例，以及方法所需参数

    }
}
```

