package SolutionTask4;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Homework2 {

    static LinkedList<Integer> invertedList = new LinkedList<>();
    static Random rnd = new Random();
    static Scanner iScanner = new Scanner(System.in);

    public static void main() {
        /*
         * Реализуйте очередь с помощью LinkedList со следующими методами:
         * enqueue() - помещает элемент в конец очереди,
         * dequeue() - возвращает первый элемент из очереди и удаляет его,
         * first() - возвращает первый элемент из очереди, не удаляя.
         */

        int[] parametersArray = fillingArrayParameters();
        createLinkedList(parametersArray);

        System.out.println("The original array: \n"
                + invertedList);

        enqueue(parametersArray);
        
        System.out.println("Puts an item at the end of the queue: "
                + invertedList);

        System.out
                .println("Returns the first item from the queue and deletes it: \n"
                        + dequeue()
                        + " : "
                        + invertedList);
        System.out
                .println("Returns the first item from the queue without deleting it: \n"
                        + first()
                        + " : "
                        + invertedList);
    }

    private static void enqueue(int[] parametersArray) {
        invertedList.add(randomNumber(parametersArray));
    }

    private static int dequeue() {
        return invertedList.peekFirst();
    }

    private static int first() {
        return invertedList.pop();

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
    private static int[] fillingArrayParameters() {

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
