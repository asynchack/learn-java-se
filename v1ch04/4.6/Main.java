
public class Main {
    public static void main(String[] args) {

        Person p = new Person("li");
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.getGood());
        System.out.println(p.getNickName());
    }
}


class Person {
    private String name;
    private int age;

    private String nickName;
    private boolean good;

    public Person(String name) {
        this(18); // 调用另一个构造器，抽离公共部分方便！
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return this.name;
    }
    public  boolean getGood() {
        return this.good;
    }
    public String getNickName() {
        return this.nickName;
    }
}