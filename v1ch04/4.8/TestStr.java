import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileParser {

    public static void main(String[] args) {
        String filePath = "your/file/path.txt"; // 替换为你的文件路径

        try {
            Map<String, Map<String, String>> data = parseFile(filePath);

            // 输出解析后的数据
            for (Map.Entry<String, Map<String, String>> entry : data.entrySet()) {
                System.out.println(entry.getKey());
                Map<String, String> values = entry.getValue();
                for (Map.Entry<String, String> valueEntry : values.entrySet()) {
                    System.out.println(valueEntry.getKey() + ": " + valueEntry.getValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Map<String, String>> parseFile(String filePath) throws IOException {
        Map<String, Map<String, String>> result = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String currentKey = null;
            Map<String, String> currentValues = null;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // 跳过空行
                }

                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];

                    if (key.equals("lakehouse") || key.equals("studio")) {
                        currentKey = key;
                        currentValues = new HashMap<>();
                        result.put(currentKey, currentValues);
                    }

                    // 解析 token 和 slave
                    if (currentValues != null) {
                        String[] tokenParts = value.split("\\|");
                        if (tokenParts.length == 2) {
                            String[] masterParts = tokenParts[1].split(",");
                            if (masterParts.length == 2) {
                                currentValues.put("master", masterParts[1]);
                            }
                            String[] slaveParts = tokenParts[0].split(",");
                            if (slaveParts.length == 2) {
                                currentValues.put("slave", slaveParts[1]);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
