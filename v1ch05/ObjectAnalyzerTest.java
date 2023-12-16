import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;


public class ObjectAnalyzerTest {

    public static void main(String[] args) {

        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);

        }
        System.out.println(new ObjectAnalyzer().toString(squares));

    }
}

class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {
        if (obj == null ) return "null";
        if (visited.contains(obj)) return "..."; // 避免环路

        visited.add(obj); // 每个记录一下
        Class cl = obj.getClass(); // 得到描述obj类的Class实例
        if (cl == String.class) return (String) obj; // 是String类型，就转后直接返回
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++ ) {
                if (i > 0) r += ",";
                Object val = Array.get(obj, i); // 得到数据第i位的对象
                if (cl.getComponentType().isPrimitive()) r += val; // 基本类型
                else r += toString(val); // 递归实现

            }
            return r + "}";
        }

        String r = cl.getName();
        // 遍历类和父类的所有字段

        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true); // 设置所有字段为可访问

            // get names and values of all fields;
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) { // 非静态
                    {
                        if (!r.endsWith("[")) r += ",";
                        r += f.getName() + "=";
                        try {
                            Class t = f.getType();
                            Object val = f.get(obj); // 得到字段的值
                            if (t.isPrimitive()) r += val; // 基本类型
                            else r += toString(val); // 递归实现
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
            r += "]";
            cl = cl.getSuperclass(); // 找分类的信息

        } while (cl != null); // 没有父类类

        return r;

    }
}