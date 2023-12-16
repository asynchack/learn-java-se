import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyof(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"tom", "dick", "harry"};
        b = (String[]) goodCopyof(b, 10);
        System.out.println(Arrays.toString(b));
    }

    public static Object goodCopyof(Object a , int newLength) {

        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class conponentType = cl.getComponentType(); // 得到数组的元素类型
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(conponentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}


