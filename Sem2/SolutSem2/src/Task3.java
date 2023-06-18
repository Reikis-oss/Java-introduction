public class Task3 {
    public static boolean сheckPolydrome(String line) {
        /*
         * Напишите метод, который принимает на вход строку (String) и
         * определяет является ли строка палиндромом (возвращает
         * boolean значение).
         */

        boolean result = false;
        char[] order = line.toCharArray();

        for (int i = 0; i < line.length() / 2; i++) {
            if (order[i] == order[order.length - i - 1]) {
                result = true;
            }
        }

        return result;
    }
}
