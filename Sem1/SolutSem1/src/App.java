import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class App {
    public static void main(String[] args) throws Exception {

        // lesson();
        homework();
    }

    public static void lesson() {

        // task1();
        // task2();

    }

    public static void homework() {

        // homeworkTask1();
        // homeworkTask2(); // Почему то он ломается после 127
        // homeworkTask3();
        // task5();
        // task8();
        // task9();

    }

    public static void task1() {

        /*
         * В консоли запросить имя пользователя.
         * В зависимости от текущего времени, вывести приветствие вида:
         * "Доброе утро, <Имя>!", если время от 05:00 до 11:59
         * "Добрый день, <Имя>!", если время от 12:00 до 17:59;
         * "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
         * "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
         */

        Scanner iScanner = new Scanner(System.in);

        System.out.printf("Enter you name: ");
        String name = iScanner.nextLine();

        Integer hour = LocalTime.now().getHour();

        if ((hour >= 5) && (hour < 12))
            System.out.println("Good morning, " + name);
        if ((hour >= 12) && (hour < 18))
            System.out.println("Good afternoon, " + name);
        if ((hour >= 18) && (hour < 23))
            System.out.println("Good evening, " + name);
        if ((hour >= 23) && (hour < 5))
            System.out.println("Good night, " + name);

    }

    public static void task2() {

        /*
         * Дан массив двоичных чисел, например [1,1,0,1,1,1],
         * вывести максимальное количество подряд идущих 1.
         */

        Scanner iScanner = new Scanner(System.in);

        System.out.printf("Enter the number of numbers in the array: ");
        Integer count = iScanner.nextInt();
        int[] array = new int[count];
        Integer countOneInArray = 0;
        Integer maxCountOneInArray = 0;

        Random random = new Random();

        for (Integer i = 0; i < array.length; i++) {
            array[i] = random.nextInt(2);

        }

        for (Integer i = 0; i < array.length; i++) {
            System.out.printf("%s\t", array[i]);
        }

        for (Integer i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                countOneInArray++;
            }

            if ((array[i] == 0) || (i == array.length - 1)) {
                if (maxCountOneInArray < countOneInArray) {
                    maxCountOneInArray = countOneInArray;
                }
                countOneInArray = 0;
            }
        }

        System.out.println("\n" + maxCountOneInArray);
    }

    public static void task5() {

        /*
         * Задание №5 (доп)
         * Во фразе "Добро пожаловать на курс по Java"
         * переставить слова в обратном порядке.
         */

        String welcome = "Добро пожаловать на курс по Java";
        String[] world = new String[welcome.split(" ").length];
        world = welcome.split(" ");
        String buf;

        System.out.println("Original text: " + welcome);

        for (Integer i = 0; i < world.length / 2; i++) {

            buf = world[i];
            world[i] = world[world.length - i - 1];
            world[world.length - i - 1] = buf;
        }

        System.out.print("Modified tex: ");

        for (Integer i = 0; i < world.length; i++) {
            System.out.print(world[i] + " ");
        }

    }

    public static void task8() {

        /*
         * Задание №8 (доп)
         * Задан массив, например, nums = [1,7,3,6,5,6].
         * Написать программу, которая найдет индекс i для этого массива такой,
         * что сумма элементов с индексами < i равна сумме элементов с индексами > i.
         */
        Scanner iScanner = new Scanner(System.in);
        boolean banner = true;
        int[] array = new int[1];

        while (banner) {
            System.out.print("1. Randomly\n" +
                    "2. For the correctness test\n" +
                    "Choose how you will complete the task: ");
            Integer choice = iScanner.nextInt();

            switch (choice) {
                case 1:
                    array = randomlyTask8();
                    banner = false;
                    break;
                case 2:
                    array = testTask8();
                    banner = false;
                    break;
                default:
                    System.out.println("Incorrect number entered, try again.");
                    break;
            }
        }

        arrayOutputTask8(array);

        Integer sum = 0, leftSum = 0, rightSum = 0, flag = 0;

        for (Integer i = 1; i < array.length - 1; i++) {
            for (Integer j = 0; j < array.length; j++) {
                if (j == i) {
                    leftSum = sum;
                    sum = 0;
                    continue;
                }
                sum += array[j];
            }
            rightSum = sum;
            sum = 0;
            if (rightSum == leftSum) {
                flag = i;
                break;
            }
        }

        if (flag > 0) {
            System.out.println("Index:  " + flag +
                    "\nDivides the array so that the sum of the elements " +
                    "with indexes on the left is equal to the sum of the " +
                    "elements on the right");
        } else {
            System.out.println("Sum on the right NOT equal sum from the left!");
        }

    }

    public static int[] randomlyTask8() {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Enter the number of numbers in the array: ");
        Integer count = iScanner.nextInt();
        int[] array = new int[count];
        Random random = new Random();

        for (Integer i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;

        }

        return array;
    }

    public static int[] testTask8() {
        int[] test = { 1, 7, 3, 6, 5, 6 };
        return test;
    }

    public static void arrayOutputTask8(int[] array) {

        for (Integer i = 0; i < array.length; i++) {
            System.out.print(i + "\t");
        }

        System.out.println();

        for (Integer i = 0; i < array.length - 1; i++) {
            System.out.print("--------");
        }

        System.out.println("--");

        for (Integer i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }

        System.out.println();
    }

    public static void task9() {

        /*
         * Задание №9 (доп)
         * Записать в файл следующие данные:
         * Name Surname Age
         * Kate Smith 20
         * Paul Green 25
         * Mike Black 23
         */

        try (FileWriter writer = new FileWriter("Sem1Task9.txt", false)) {
            String text = "Name \t Surname \t Age \r\n" +
                    "Kate \t Smith \t\t 20 \r\n" +
                    "Paul \t Green \t\t 25 \r\n" +
                    "Mike \t Black \t\t 23 \r\n";
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    public static void homeworkTask1() {

        /*
         * 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
         * (произведение чисел от 1 до n)
         */

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Select the extreme number: ");
        Integer numer = iScanner.nextInt();
        Integer sum = 0;

        for (Integer i = 1; i <= numer; i++) {
            for (Integer j = 1; j <= i; j++) {
                sum += j;
            }
            System.out.println("The sum in a Triangular number on line " + i + " is equal to: " + sum);
            sum = 0;
        }
    }

    public static void homeworkTask2() {

        /*
         * 2. Вывести все простые числа от 1 до 1000
         */

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Select the extreme number: ");
        Integer numer = iScanner.nextInt();

        for (Integer i = 128; i <= numer; i++) {
            for (Integer j = 2; j <= i; j++) {
                if (j == i) {
                    System.out.println(i);
                }
                if (i % j == 0) {
                    break;
                }

            }
        }
    }

    public static void homeworkTask3() {

        /*
         * 3) Реализовать простой калькулятор
         */

        Scanner iScanner = new Scanner(System.in);

        System.out.print("Enter the first number of the equation: ");
        Integer numer1 = iScanner.nextInt();
        Integer action = 0, result = 0;
        boolean flag = true;

        while (flag) {
            System.out.print("1. +\n" +
                    "2. -\n" +
                    "3. *\n" +
                    "4. /\n" +
                    "Select an action: ");
            Integer сhoice = iScanner.nextInt();
            switch (сhoice) {
                case 1:
                    action = 1;
                    flag = false;
                    break;
                case 2:
                    action = 2;
                    flag = false;
                    break;
                case 3:
                    action = 3;
                    flag = false;
                    break;
                case 4:
                    action = 4;
                    flag = false;
                    break;
                default:
                    System.out.println("Incorrect number entered, try again.");
            }
        }

        System.out.print("Enter the second number of the equation: ");
        Integer numer2 = iScanner.nextInt();

        switch (action) {
            case 1:
                System.out.println(numer1 + " + " + numer2 + " = " + (numer1 + numer2));
                break;
            case 2:
                System.out.println(numer1 + " - " + numer2 + " = " + (numer1 - numer2));
                break;
            case 3:
                System.out.println(numer1 + " * " + numer2 + " = " + (numer1 * numer2));
                break;
            case 4:
                System.out.println(numer1 + " / " + numer2 + " = " + (numer1 / numer2));
                break;
        }

    }

}
