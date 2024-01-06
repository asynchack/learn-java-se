
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};

        Pair<String> mm = ArrayAlg.minMax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

        // generic method
        String middle = ArrayAlg.<String>getMiddle("John", "Q", "public");
        System.out.println(middle);
        String middle2 = ArrayAlg.getMiddle("John", "Q", "public"); // 同上，自动推倒
        System.out.println(middle2);

        // 多类型自动推导
        double middle3 = ArrayAlg.getMiddle(3.14, 19.28, 0);  // 会找到int和double的公共父类、或接口，推导为这个类型
        System.out.println(middle3);
    }
}

class ArrayAlg {
    public static Pair<String>  minMax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);

    }

    @SafeVarargs
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
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


