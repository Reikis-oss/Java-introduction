import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HomeworkTask2 {
    public static int[] bubbleSort(int[] sortArr) {
        String filePath = "Sem2HomeworkTask2.txt";
        String lineWrite = "", line = "";
        int countLine = 1;

        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;

                }
                lineWrite = lineForWrite(sortArr, countLine);
                countLine++;
                try {
                    FileWriter writer = new FileWriter(filePath);
                    BufferedReader reader = new BufferedReader(new FileReader(filePath));
                    if (reader.readLine() != null) {
                        line = reader.readLine();
                        line += lineWrite;
                        writer.write(line);
                        writer.flush();
                    }
                    if (reader.readLine() == null) {
                        line += lineWrite;
                        writer.write(line);
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sortArr;
    }

    public static int[] createArray(int len) {
        int[] result = new int[len];
        Random rnd = new Random();
        for (int i = 0; i < len; i++) {
            result[i] = rnd.nextInt(100);
        }
        return result;
    }

    public static void printArray(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print("\t" + sortArr[i]);
        }
    }

    private static String lineForWrite(int[] array, int line) {
        String result = "iteration " + line + ":\t";

        for (int i = 0; i < array.length; i++) {
            result += array[i] + " ";
        }
        result += "\n";
        return result;
    }
}
