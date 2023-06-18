import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HomeworkTask1 {
    public static void sqlQuery() {
        /*
         * Дана строка sql-запроса "select * from students where ".
         * Сформируйте часть WHERE этого запроса, используя StringBuilder.
         * Данные для фильтрации приведены ниже в виде json-строки.
         * Если значение null, то параметр не должен попадать в запрос.
         * Параметры для фильтрации:
         * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
         */

        StringBuilder sb = new StringBuilder();
        String filePath = "test.txt";
        String text = readFile(filePath);
        String[] pairsWords = text.split(",");
        sb.append("select * from students where ");

        for (int i = 0; i < pairsWords.length; i++) {
            String[] world = pairsWords[i].split(":");
            if (world[1].replace("\"", "") != "null") {
                sb.append(world[0] + " = " + world[1]);
            }
        }

        System.out.println(sb);
    }

    private static String readFile(String filePath) {
        String line, result = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length >= 2) {

                    String key = parts[0].replaceAll("\"", "");
                    String value = parts[1];
                    result += key + ":" + value;
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
