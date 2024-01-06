import java.util.*;

public class DemoQueue {
    public static void main(String[] args) {
//
//        Queue;
//        LinkedList;
//        AbstractQueue;
//        Collection;
//        AbstractCollection;
//        Iterable;
//        NavigableSet;
//        Deque;
//        NavigableMap;
//        RandomAccess;
//        TreeSet;
//        TreeMap;
//        AbstractCollection;
//        AbstractList;
//        AbstractSet;
//        AbstractQueue;

        List<String> staff = new LinkedList<>();
        staff.add("Carl Cracker");
        staff.add("bob Cracker");
        staff.add("Harry Hacker");
        Iterator<String> it = staff.iterator();
        String first = it.next();
        String second = it.next();
        System.out.println(first);
        System.out.println(second);
        it.remove(); // remove last element that visited! 这里是bo Cracker

        System.out.println("after remove");
        ListIterator<String> lit = staff.listIterator();
        for (String s : staff) {
            System.out.println(s);
            /*
            Carl Cracker
            bob Cracker
            after remove
            Carl Cracker
            Harry Hacker

             */
        }


        System.out.println("interator add test:");
        List<String> staff2 = new LinkedList<>();
        staff2.add("amy");
        staff2.add("bob");
        staff2.add("clarl");
        ListIterator<String> iter = staff2.listIterator();
        iter.next(); // skip past first ele
        iter.add("julime");
        iter.add("wang");
        iter.add("bo");
        // show be: amy julime wang bo  bob clarl
        for(String s: staff2){
            System.out.println(s);
        }
        System.out.println("next test:");
        List<String> staff3 = new LinkedList<>();
        staff3.add("amy");
        staff3.add("bob");
        staff3.add("clarl");
        ListIterator<String> iter3 = staff3.listIterator();
        iter3.next(); // after amy
        iter3.previous();
        iter3.remove(); // remote amy
        for(String s: staff3){
            System.out.println(s);
        }
        System.out.println("test 4:");
        List<String> staff4 = new LinkedList<>();
        staff4.add("amy");
        staff4.add("good");
        ListIterator<String> iter4 = staff4.listIterator();
        iter4.next(); // after amy
        iter4.set("amy goood");
        for (String s : staff4) {
            System.out.println(s);
        }
        System.out.println("test 5:");
        List<String> staff5 = new LinkedList<>();
        staff5.add("amy");
        staff5.add("good");
        ListIterator<String> iter5 = staff5.listIterator();
        ListIterator<String> iter51 = staff5.listIterator();
        System.out.println(iter5.nextIndex());
        System.out.println(iter5.previousIndex());
        iter5.next();
        iter5.remove(); // remove first ele
//        iter51.next(); // should be amy , but not found~
        System.out.println(staff5.contains("amy"));
        System.out.println(staff5.get(0));

    }
}