
public class StringDemo {
    public static void main(String[] args) {
        String e = "";  // 空字符串
        System.out.println(e);

        String e1 = "Java\u2122"; // 本质是unicode字符序列，
        for (char c : e1.toCharArray()) {
            System.out.println(c);
        }

        //
        String sub = e1.substring(0, 2);
        System.out.println(sub);

        //
        String expletive = "expletive";
        String PG13 = "deleted";
        String message = expletive + PG13;
        System.out.println(message);

        //
        String all = String.join("/", "S", "M", "L");
        System.out.println(all);

        // 字符串不可变的！修改字符串其实是生成了一个新的字符串（在内存），然后变更字符串变量的指向地址，此外！那么复制字符串，也只是创建了一个新的字符串变量引用同一个内存地址

        all = all.substring(0, 3) + "good!"; // all 指向更新了，原来的内存的s/m/l还在，只是没有变量在引用它了！
        System.out.println(all);

        // 判断字符串的相等，一定用equals（）方法，而不是== ，后者是比较内存地址，是否是同一个块
        String hello = "hello";
        "hello".equals(hello);


        // null值和空串
        String s = null;
        String s1 = "";
        if (s1.equals("")) {
            System.out.println("空串");
        }

        if (s1.length() == 0) {
            System.out.println("空串");
        }
//        if (s.length() == 0) { // Exception in thread "main" java.lang.NullPointerException
//            System.out.println("空串");
//        }


        if (s != null && s.length() != 0) { // 一般调用对象方法前，先判断是否为null，避免空指针异常
            System.out.println("非空串");
        }

         String gre = "hello中文橛\u1D546";

        int n = gre.length();
        System.out.println(n);

        int cpCount = gre.codePointCount(0, gre.length());
        System.out.println(cpCount);

        char first = gre.charAt(0);
        char last  = gre.charAt(gre.length() - 1);
        System.out.println(first);
        System.out.printf("%c%n", last);

        String gre1 = "\u1D546"; // 2个代码单元
        char ch = gre1.charAt(1);
        System.out.println(ch);

        // codePoints 方法
        int[] codePoints = gre.codePoints().toArray(); // 目前理解：有的字符串是占用多个char单元，用codePoints（）方法会根据头部的特征数字，判断这个单元应该包含后面几个字节，（否则就是按照固定字节读取，那么编码就乱了）
        System.out.println(java.util.Arrays.toString(codePoints)); // [104, 101, 108, 108, 111, 20013, 25991, 27227, 7508, 54]

        String str = new String(codePoints, 0, codePoints.length);
        System.out.println(str); // TODO


        String hello1 = "hello";

        int compare = hello1.compareTo("hellz");
        System.out.println(compare);

        //
        StringBuilder builder = new StringBuilder(); // 频繁解释比如键盘的单词，组成字符串，每按一下就拼接，效率低，此时适合用StringBuilder，类似缓存接收，最终一次性构建一个String对象
        builder.append("hello").append("p9");
        String res1 = builder.toString();
        System.out.println(res1);

    }
}