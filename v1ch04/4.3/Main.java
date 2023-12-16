
public class Main {

    public static int nextId = 1;

    public static void main(String[] args) {
        System.out.println(getNextId());
    }

    public  int getNextId() { // 不加static，默认是对象方法，需要实例化一个对象后，用这个对象才能调用，
        return nextId;
    }
}