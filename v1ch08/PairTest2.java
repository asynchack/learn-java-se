import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Supplier;

public class PairTest2 {
    public static void main(String[] args) {

        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1910, 6, 22)
        };
        Pair<LocalDate> mm = ArrayAlg.<LocalDate>minMax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

        Serializable;
        Supplier
    }
}

class ArrayAlg {


    @SuppressWarnings("unchecked")
    public static <T extends Comparable> Pair<T> minMax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min  = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];

        }
        return new Pair<>(min, max);
    }
}

class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public T getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
