
public class Child  extends Parent {
    public static void main(String[] args) {
        System.out.println("child");
       int a =  getNumber();
        System.out.println(a);
    }

    private static int num = 200;

    public static int getNumber() {
        return 200;
    }

}