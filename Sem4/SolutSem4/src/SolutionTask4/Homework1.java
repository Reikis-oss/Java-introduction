package SolutionTask4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Homework1 {

    static LinkedList<Integer> invertedList = new LinkedList<>();
    static Random rnd = new Random();
    static Scanner iScanner = new Scanner(System.in);

    // Метод переворачивающий массив
    public static void main() {
        /*
         * Пусть дан LinkedList с несколькими элементами.
         * Реализуйте метод, который вернет “перевернутый” список.
         */

        int[] parametersArray = fillingArrayParameters(); /*
                                                           * 0 - array length
                                                           * 1 - the minimum value of the array
                                                           * 2 - the maximum value of the array
                                                           */
        createLinkedList(parametersArray);
        System.out.println(invertedList);

        // переворот массива
        Collections.reverse(invertedList);

        System.out.println(invertedList);

    }

    // Метод создающий лист с случайными числами
    private static void createLinkedList(int[] parametersArray) {

        for (int i = 0; i < parametersArray[0]; i++) {
            invertedList.add(randomNumber(parametersArray));
        }
    }

    // Метод создающий рандомное число
    private static int randomNumber(int[] parametersArray) {
        int res = 0, choise = 0;

        for (int i = 0; i < 2; i++) {
            if ((choise = rnd.nextInt(parametersArray[2]) + 1) > parametersArray[1] - 1) {
                res = choise;
                break;
            } else {
                i--;
            }
        }

        return res;
    }

    // This method creates an array of numbers that contains the length, minimum and
    // maximum values for creating arrays
    public static int[] fillingArrayParameters() {

        int[] result = new int[3];
        int index = 0;
        boolean flag = true;
        while (flag) {
            try {
                String text = "";
                switch (index) {
                    case 0:
                        System.out.print("Enter the length of the array: ");
                        text = iScanner.next();
                        result[index] = Integer.parseInt(text);
                        index++;
                    case 1:
                        System.out.print("Enter the min of the array: ");
                        text = iScanner.next();
                        result[index] = Integer.parseInt(text);
                        index++;
                    case 2:
                        System.out.print("Enter the max of the array: ");
                        text = iScanner.next();
                        result[index] = Integer.parseInt(text);
                        index++;
                    default:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Try again");
            }
        }

        return result;
    }

}
