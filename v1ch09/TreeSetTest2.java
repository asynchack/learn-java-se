import java.util.*;

public class TreeSetTest2 {
    public static void main(String[] args) {

        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("toaster", 123));
        parts.add(new Item("zidget", 1));
        parts.add(new Item("modem", 789));
        System.out.println(parts);

        NavigableSet<Item> sortByDesc = new TreeSet<>(Comparator.comparing(Item::getDesc));
        sortByDesc.addAll(parts);
        System.out.println(sortByDesc);
    }
}
class Item implements Comparable<Item> {
    private String desc;
    private int partNumber;


    public Item(String aDesc, int aPartNumber) {
        this.desc = aDesc;
        this.partNumber = aPartNumber;
    }

    public String getDesc() {
        return desc;
    }
    public String toString() {
        return desc + " " + partNumber;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Item otherObj = (Item) other;
        return Objects.equals(this.desc, otherObj.desc) && this.partNumber == otherObj.partNumber;
    }

    public int hashCode() {
        return Objects.hash(this.desc, this.partNumber);
    }

    public int compareTo(Item other) {
        int diff = Integer.compare(this.partNumber, other.partNumber);
        return diff != 0 ? diff : this.desc.compareTo(other.desc);
    }
}