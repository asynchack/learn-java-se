import java.time.LocalDate;
import java.util.Locale;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        System.out.println("hello");

        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(2014, 3, 18));
        pq.add(LocalDate.of(1815, 12, 25));
        pq.add(LocalDate.of(1903, 12, 25));
        pq.add(LocalDate.of(1815, 12, 25));
        System.out.println("iterating ");
        for (LocalDate date : pq) {
            System.out.println(date);
        }

        System.out.println("removing elements ");
        while (! pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}