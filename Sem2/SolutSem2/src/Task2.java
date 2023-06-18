
public class Task2 {
    public static String compressLineWithoutLoss(String line) {

        /*
         * Напишите метод, который сжимает строку.
         * Пример: вход aaaabbbcdd.
         */

        StringBuilder sb = new StringBuilder();

        char sbl = line.charAt(0);
        int count = 0;

        for (int i = 0; i < line.length(); i++) {
            if ((sbl != line.charAt(i))) {
                sb.append(sbl);
                sb.append(count);
                sbl = line.charAt(i);
                count = 0;
            }
            if (sbl == line.charAt(i)) {
                count++;
            }
            if (i == line.length() - 1) {
                if (sbl == line.charAt(i)) {
                    sb.append(sbl);
                    sb.append(count);
                }
                if (sbl != line.charAt(i)) {
                    sbl = line.charAt(i);
                    count = 1;
                    sb.append(sbl);
                    sb.append(count);
                }
            }
        }

        return sb.toString();
    }
}
