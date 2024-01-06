import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<String> sorter = new TreeSet<>();
        sorter.add("bob");
        sorter.add("amy");
        sorter.add("carl");
        for (String s : sorter) {
            System.out.println(s);
        }
    }
}