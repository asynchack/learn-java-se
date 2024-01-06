import java.util.*;

public class CollectionWrapper {
    public static void main(String[] args) {
        String[] s1 = new String[10];
        List<String> sList = Arrays.asList(s1);
        System.out.println(sList.size());
        System.out.println(sList.get(0));
        System.out.println(sList.set(0, "hello"));
        System.out.println(sList.get(0)); // 返回的是一个视图对象，操作的是原有的数组
//        sList.add("world");

//        //
//
//        List<String> names = Arrays.asList("bob", "carl", "david");
//        System.out.println(names);
//
//        //
//        System.out.println(Collections.nCopies(10, "hello"));
//
//        //
//        Set<String> a = Collections.singleton("hello");
//        System.out.println(a);
//
//        //
//        Set<String> deepThougths = Collections.emptySet();
//        System.out.println(deepThougths);
//
//        //
//        List<String> subList = sList.subList(0, 3);
//        System.out.println(subList );
//        //
//
//        SortedSet<String> ss = new TreeSet<>();
//        ss.subSet();
//        ss.headSet();
//        ss.tailSet();
//        NavigableSet<String> ns = new TreeSet<>();
//        ns.subSet();
//        ns.headSet();
//        //
//        Collections.unmodifiableCollection();
//        Collections.unmodifiableSet();
//        Collections.unmodifiableList();
//        Collections.unmodifiableMap();        //
//
//        List<String> names = Arrays.asList("bob", "carl", "david");
//        System.out.println(names);
//
//        //
//        System.out.println(Collections.nCopies(10, "hello"));
//
//        //
//        Set<String> a = Collections.singleton("hello");
//        System.out.println(a);
//
//        //
//        Set<String> deepThougths = Collections.emptySet();
//        System.out.println(deepThougths);
//
//        //
//        List<String> subList = sList.subList(0, 3);
//        System.out.println(subList );
//        //
//
//        SortedSet<String> ss = new TreeSet<>();
//        ss.subSet();
//        ss.headSet();
//        ss.tailSet();
//        NavigableSet<String> ns = new TreeSet<>();
//        ns.subSet();
//        ns.headSet();
//        //
//        Collections.unmodifiableCollection();
//        Collections.unmodifiableSet();
//        Collections.unmodifiableList();
//        Collections.unmodifiableMap();

        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<String, Integer>()); // 借助视图机制，对原始的Map包了一层，里面有锁，使得所有对包装后的map调用，变成同步的，即所有线程都是同步操作（一个接着一个）
        System.out.println(map);

//        ArrayList<String> list = new ArrayList<>();
//        ArrayList raw = list;
////        raw.add(new Date());
//        List<String> strings = new ArrayList<>();
//        List<String> safeStrings = Collections.checkedList(strings, String.class);
//        List<String> raw = safeStrings;
//        raw.add(new Date());

        ArrayList<String> list = new ArrayList<>();
        list.removeIf(s -> s.length() > 10);
        list.replaceAll();

        //
        String[] values = new String[10];
        HashSet<String> staff = new HashSet<>(Arrays.asList(values));
        Object[] objects = staff.toArray();


    }
}