import java.util.Scanner;

public class DemoEnum {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("enter a size: (SMALL, MEDIUM, LARGE) ");
        String s = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, s);
        System.out.println("size = " + size);
        System.out.println(size.getDescription());
        System.out.println(size.toString());
        Size[] values = size.values();
        for (Size value : values) {
            System.out.println(value);
        }

        System.out.println(size.ordinal());
        System.out.println(size.compareTo(Size.MEDIUM));
    }
}


enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L");

    private String description;
    public String getDescription() {
        return this.description;
    }

    private Size(String description) {
        this.description = description;
    }


}