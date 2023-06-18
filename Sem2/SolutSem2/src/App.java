import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // lesson();
        homework();

    }

    private static void lesson() {
        // Task1.execute();
        // task2();
        // task3();
        // task4();
        // task5();

    }

    private static void homework() {

        // homeworkTask1();
        homeworkTask2();

    }

    private static void task2() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите последовательность символов: ");
        String line = iScanner.nextLine();
        if (line.isEmpty()) {
            System.out.println("Введена пустая строка!");
        } else {
            String result = Task2.compressLineWithoutLoss(line);
            System.out.println(result);
        }
    }

    private static void task3() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String line = iScanner.nextLine();
        if (line.length() > 0) {
            boolean result = Task3.сheckPolydrome(line);
            System.out.println(result);
        } else {
            System.out.println("Введена пустая строка!");
        }
    }

    private static void task4() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String line = iScanner.nextLine();
        if (line.length() > 0) {
            try {
                Task4.writLineToDoc(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Введена пустая строка!");
        }

    }

    private static void task5() {
        try {
            String[] fldrCnt = Task5.getCrntFldrCnts();
            Task5.wrtArrToFile(fldrCnt, "filenames.txt");
            Task5.dtrmFileExts(fldrCnt);
        } catch (IOException e) {
            Task5.wrtExcptToLogFile(e, "log.txt");
        }
    }

    private static void homeworkTask1() {
        HomeworkTask1.sqlQuery();
    }

    private static void homeworkTask2() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int[] sortArr = new int[iScanner.nextInt()];
        boolean flag = true;

        while (flag) {
            System.out.print("1. test\n" +
                    "2. random\n" +
                    "Выберите как будете проходить задание: ");

            String choice = iScanner.next();
            switch (choice) {
                case "1":
                    for (int i = 0; i < sortArr.length; i++) {
                        sortArr[i] = sortArr.length - i;
                    }
                    flag = false;
                    break;
                case "2":
                    sortArr = HomeworkTask2.createArray(sortArr.length);
                    flag = false;
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }

        System.out.print("Изначальный массив: ");
        HomeworkTask2.printArray(sortArr);

        System.out.println();

        System.out.print("Сортированный массив: ");
        sortArr = HomeworkTask2.bubbleSort(sortArr);
        HomeworkTask2.printArray(sortArr);

    }
}
