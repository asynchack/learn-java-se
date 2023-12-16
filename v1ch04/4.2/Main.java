
import java.time.*;
import java.util.Date;

/**
 * @author bo
 *
 */
public class Main {
    public static void main(String[] args) {

//        Date now = new Date();
//        String s = now.toString();
//
//        System.out.println(s);
//
//
//        // 声明Date对象的变量（将来引用一个Date对象的地址）
//
//        Date deadLine;
//        deadLine  = now;
//
//        System.out.println(deadLine.toString());
//
//        // LocalDate
//
//        LocalDate newYear = LocalDate.of(2022, 12, 31);
//        System.out.println(newYear);
//        int year = newYear.getYear();
//        int month = newYear.getMonthValue();
//        int day = newYear.getDayOfMonth();
//
//
//        LocalDate yearAfter1000 = newYear.plusDays(1000); // ! 这个方法调用，没有改变newYear对象，而是生成了一个新的对象，将引用赋值给了yearAfter1000；这种叫做访问器方法，如果有更改原来的对象，这种叫更改器方法！
//
//        System.out.println(yearAfter1000);
//        int year1000 = yearAfter1000.getYear();
//        System.out.println(year1000);



        LocalDate date = LocalDate.now();

        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today -1); // start of month

        DayOfWeek dayOfWeek = date.getDayOfWeek(); // 本月1号是星期几

        int value = dayOfWeek.getValue(); // 1-7

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        for (int i = 1; i < value ; i++) {

            System.out.print("    ");
        }


        while (date.getMonthValue() == month) {

            System.out.printf("%3d", date.getDayOfMonth());

            if (date.getDayOfMonth() == today) {
                System.out.print("*");

            } else {
                System.out.print(" ");
            }

            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }


        }






    }
}