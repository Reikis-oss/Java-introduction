import java.util.Scanner;

public class Task1 {
    public static void execute() {

        /*
         * Дано четное число N (>0) и символы c1 и c2.
         * Написать метод, который вернет строку длины N, которая
         * состоит из чередующихся символов c1 и c2, начиная с c1.
         */

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите четное число для предела: ");
        Integer N = iScanner.nextInt();
        System.out.print("Введите первый символ: ");
        String c1 = iScanner.next();

        System.out.print("Введите второй символ: ");
        String c2 = iScanner.next();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                result.append(c1);
            }
            if (i % 2 != 0) {
                result.append(c2);
            }
        }
        System.out.println(result.toString());

    }
}
