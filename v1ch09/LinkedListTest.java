import java.util.*;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("amy");
        a.add("carl");
        a.add("erica");

        List<String> b = new LinkedList<>();
        b.add("bob");
        b.add("david");
        b.add("frances");
        b.add("gloria");

        // merge the words in b into a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next()); // b多出一个，就末尾追加

        }
        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove(); // remove the last element 每2个删除一个
            }
        }
        System.out.println(b);

        //
        a.removeAll(b); // remove all elements in b from a
        System.out.println(a);
        //
        ArrayList<String> as = new ArrayList<>();
    }
}