package Solution;

import java.util.Scanner;
import java.util.Random;

public class HomeworkTask1 {
    /*
     * Реализовать алгоритм сортировки слиянием(метод взять из Интернета)
     */
    static Scanner iScanner = new Scanner(System.in);

    public static void SortArray() {

        int[] parametersArray = fillingArrayParameters(); /*
                                                           * 0 - array length
                                                           * 1 - the minimum value of the array
                                                           * 2 - the maximum value of the array
                                                           */
        int[] array = new int[parametersArray[0]];
        if (parametersArray[1] < parametersArray[2]) {
            array = createArray(parametersArray);
        } else {
            System.out.print("The minimum number is greater than the maximum");
        }

        printText("new array: " + array);
        int[] sortArray = sortPermutationArray(array);
        printText("sort array: " + sortArray);
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

    // The method creates an array of numbers, from the minimum to the maximum
    // number
    private static int[] createArray(int[] parametersArray) {
        Random rnd = new Random();
        int[] result = new int[parametersArray[0]];
        int choise = 0;

        for (int i = 0; i < result.length; i++) {
            if ((choise = rnd.nextInt(parametersArray[2]) + 1) > parametersArray[1] - 1) {
                result[i] = choise;
            } else {
                i--;
            }

        }

        return result;
    }

    // Displays text on the screen
    private static void printText(String text) {

        System.out.println(text);
    }

    // Sorting an array by permutation method
    public static int[] sortPermutationArray(int[] array) {
        if (array == null) {
            return null;
        }
        int length_arr = array.length / 2;

        if (array.length < 2) {
            return array;
        }
        if (array.length % 2 != 0) {
            length_arr += 1;
        }
        int[] arrayR = new int[length_arr];
        int[] arrayL = new int[array.length / 2];
        // System.out.print("\n");
        // System.out.print("Left arr: ");
        for (int i = 0; i < array.length / 2; i++) {
            arrayL[i] = array[i];
            // System.out.print(arrayL[i] + " ");
        }
        // System.out.print("\n");
        // System.out.print("Right arr: ");
        for (int i = array.length / 2; i < array.length; i++) {
            arrayR[i - array.length / 2] = array[i];
            // System.out.print(arrayR[i - array.length / 2] + " ");
        }
        arrayL = sortPermutationArray(arrayL);
        arrayR = sortPermutationArray(arrayR);

        // System.out.print("\n");
        return mergeArray(arrayL, arrayR);
    }

    // A method that combines two arrays together
    public static int[] mergeArray(int[] arrayL, int[] arrayR) {

        int[] arrayC = new int[arrayL.length + arrayR.length];
        int posL = 0, posR = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (posL < arrayL.length && posR < arrayR.length) {
                if (arrayL[posL] < arrayR[posR]) {
                    arrayC[i] = arrayL[posL];
                    posL++;
                } else {
                    arrayC[i] = arrayR[posR];
                    posR++;
                }
            } else if (posL == arrayL.length && posR < arrayR.length) {
                arrayC[i] = arrayR[posR];
                posR++;
            } else if (posL < arrayL.length && posR == arrayR.length) {
                arrayC[i] = arrayL[posL];
                posL++;
            } else {
                arrayC[i] = 0;
            }
        }
        return arrayC;
    }
}
