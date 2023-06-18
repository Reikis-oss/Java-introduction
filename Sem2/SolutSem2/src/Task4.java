import java.io.FileWriter;
import java.io.IOException;

public class Task4 {

    public static void writLineToDoc(String line) throws IOException {

        try (FileWriter writer = new FileWriter("Sem2Task4.txt", false)) {
            String text = hundredWords(line);

            writer.write(text);
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static String hundredWords(String line) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            sb.append(line);
        }

        return sb.toString();
    }
}
