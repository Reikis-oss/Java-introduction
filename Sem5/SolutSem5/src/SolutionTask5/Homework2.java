package SolutionTask5;

import java.util.Random;
import java.util.Scanner;

public class Homework2 {

    static Scanner iScanner = new Scanner(System.in);
    static Random rnd = new Random();
    static int[] arr = createArray(fillingArrayParameters());

    public static void main() {

        System.out.println("Изначальный массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        heapSort(arr);
        System.out.println();
        System.out.println("Сортированный массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    // Метод создающий массив с случайными числами
    private static int[] createArray(int[] parametersArray) {
        int[] result = new int[parametersArray[0]];
        for (int i = 0; i < result.length; i++) {
            result[i] = randomNumber(parametersArray);
        }

        return result;
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

    private static void heapSort(int[] arr) {
        // длина массива
        int n = arr.length;

        // создаём дерево, построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);

        // Делаем сортировку массива, уже отсортированного дерева,
        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {

            // Перемещаем текущий корень в конец
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, 0, i);
        }

    }

    /**
     * Главный метод в котором будет меняться структура данных
     * так чтоб родитель был максимальны элементом по сравнению
     * со своими детьми в дереве
     * 
     * @param arr
     * @param i
     * @param n
     */
    private static void heapify(int[] arr, int i, int n) {
        // левый ребёнок
        int l = i * 2 + 1;

        // правый ребёнок
        int r = i * 2 + 2;

        // Инициализируем наибольший элемент как корень
        int largest = i;

        // Проверка чтоб дети не стали больше чем родители
        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше,
        // чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если, ребёнок оказался больше родителя, то делаем обмен,
        // ребёнка с родителем. Если самый большой элемент не корень
        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Проверяем ещё раз чтоб дети были меньше чем родители,
            // если, вдруг у детей есть свои дети
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, largest, n);
        }
    }

}
