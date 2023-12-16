
public class CallbyValue {
    public static void main(String[] args) {

        int a = 200;
        int b = 300;


        System.out.println(a);
        System.out.println(b);

        addOne(a);
        addOne(b);

        System.out.println("after call by value");
        System.out.println(a);
        System.out.println(b);


        // object
        Person wang = new Person("wang", 18);
        System.out.println(wang.getAge());

        callGrowth(wang);
        System.out.println(wang.getAge());


        //
        Person yan = new Person("yan", 19);

        System.out.println(wang.getName());
        System.out.println(yan.getName());
        swap(wang, yan);
        System.out.println(wang.getName());
        System.out.println(yan.getName());
    }



    public static void addOne(int num) {
        num = num + 1;
    }

    public static void callGrowth(Person p) {
        p.growth();
    }
    public static void swap(Person a, Person b) {
        Person tmp = a;
        a = b;
        b = tmp;
    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public int getAge()     {
        return this.age;
    }

    public void growth() {
        this.age += 1;
    }
}