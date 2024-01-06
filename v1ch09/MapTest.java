import java.time.DayOfWeek;
import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> staff = new HashMap<>();
        staff.put("Carl Cracker", 75000);
        staff.put("Harry Hacker", 50000);
        staff.put("Tony Tester", 40000);
        staff.forEach((k, v) -> System.out.println(k + " " + v));

        Set<String> keys = staff.keySet();
        keys.remove("Carl Cracker");
        for (String key : keys) {
            System.out.println(key);
        }

        Collection<Integer> values = staff.values();
        values.remove(40000);
        for (Integer value : values) {
            System.out.println(value);
        }

        for (Map.Entry<String, Integer> entry : staff.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + v);

        }
        // new way
        System.out.println("res");
        staff.forEach((String, Integer) -> System.out.println(String + Integer));
        //
        EnumSet<DayOfWeek> always = EnumSet.allOf(DayOfWeek.class);
        for (DayOfWeek day : always) {
            System.out.println(day);
        }
        EnumMap<DayOfWeek, Integer> days = new EnumMap<>(DayOfWeek.class);
    }
}