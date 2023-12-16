import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileParser {

    public static void main(String[] args) {

        String filePath = "./on_duty.txt"; // 替换为你的文件路径

        try {
            Map<String, Map<String, List<String>>> data = parseFile(filePath);


            StringBuilder respContent = new StringBuilder();
            respContent.append("{\"text\":\"本周值班人员:\\n ");


            System.out.println("---");

            // 输出解析后的数据
            for (Map.Entry<String, Map<String, List<String>>> entry : data.entrySet()) {
                System.out.println(entry.getKey());
                Map<String, List<String>> values = entry.getValue();
                for (Map.Entry<String, List<String>> valueEntry : values.entrySet()) {
                    System.out.println(valueEntry.getKey() + ": " + valueEntry.getValue());
                }
            }
            System.out.println("---");
            for (Map.Entry<String, Map<String, List<String>>> entry : data.entrySet()) {
                respContent.append(entry.getKey() + "\\n "); // such as studio

                Map<String, List<String>> values = entry.getValue();
                productOnDutyLine(respContent, "master", values);
                productOnDutyLine(respContent, "slave", values);

            }


            respContent.append("\"}");

            System.out.println(respContent);
            System.out.println(respContent.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Map<String, List<String>>> parseFile(String filePath) throws IOException {
        Map<String, Map<String, List<String>>> result = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // 跳过空行
                }

                String[] parts = line.split("\\s+");
                String key = parts[0];
                String masterValue = parts[2]; // master|ou_9b92da89f6db474ae334a,ou_9b92da89f6db473c64ae3
                String slaveValue = parts[3]; // slave|ou_188366a4840e68c552808c41f0ed75e4,ou_xxx
                Map<String, List<String>> master = parseLine(masterValue);
                Map<String, List<String>> slave = parseLine(slaveValue);

                Map<String, List<String>> tmpMap = new HashMap<>();
                tmpMap.put("master", master.get("master"));
                tmpMap.put("slave", slave.get("slave"));

                result.put(key, tmpMap);
            }
        }
        return result;
    }

    private static Map<String, List<String>> parseLine(String line) {
        Map<String, List<String>> result = new HashMap<>();
        String[] parts = line.split("\\|");
        String key = parts[0];
        String values = parts[1];
        String[] valueParts = values.split(",");
        result.put(key, Arrays.asList(valueParts));
        return result;
    }

    private static  String productAtString(String userId) {
        return "<at user_id=\\\"" + userId + "\\\"></at>";

    }

    private static String convert2ZhCN(String str) {
        switch (str)
        {
            case "master":
                return "主值班";
            case "slave":
                return "副值班";
            default:
                return str;
        }
    }

    private static void productOnDutyLine(StringBuilder sb, String postion, Map<String, List<String>> values) {

        sb.append(convert2ZhCN(postion) + ": ");
        for (String uid : values.get(postion)) {
            sb.append(productAtString(uid));
        }
        sb.append("\\n ");
    }
}
