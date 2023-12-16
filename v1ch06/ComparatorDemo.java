import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        String s = "good";
        if (!"good1".equals(s)) {
            System.out.println("yes");
        }
        String s1 = null;

        if (!"good".equals(s1)) {
            System.out.println("no");
        }
        Comparator<String> cp = new LengComparator();
        if (cp.compare("123", "23") > 0) {
            System.out.println("longer");
        }
        String podName = "aa";
        String k8sNamespace = "bb";
        String maxWaitSecondsforContainerRuning = "10";
        String status = String.format("Pod %s/%s isNotReady-in%sSec-PendingOrContainerStartSlow", podName, k8sNamespace, maxWaitSecondsforContainerRuning);
        System.out.println(status);
    }
}

class LengComparator implements Comparator<String> {
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}