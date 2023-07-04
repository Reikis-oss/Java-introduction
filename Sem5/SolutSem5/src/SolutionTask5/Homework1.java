package SolutionTask5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Homework1 {

    static Map<String, List<String>> phoneBook = new HashMap<>();
    static Scanner iScanner = new Scanner(System.in);

    public static void main() {
        
        addPhoneBook();
        findPhoneBook(choosingString("Введите имя которое хотите найти в телефонной книге: "));

    }

    // Создаёт имена для телефонной книги
    private static void addPhoneBook() {
        boolean flag = true;

        while (flag) {
            phoneBook.put(choosingString("Введите имя контакта: "), choosingList("Вы хотите добавить ещё номер?"));
            flag = sequel("Вы хотите добавить ещё контакт?");
            System.out.println();
        }
    }

    // Ищет нужного человека в телефонной книге и если находит выводит его в консоль
    // В name передаётся искомое имя
    private static void findPhoneBook(String name) {
        try {
            List<String> list = phoneBook.get(name);
            if (list.size() > 0) {
                System.out.println("Имя" + "\tТелефоны");
                System.out.print(name + ":\t");
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + ", ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Такого человека нет в списке контактов.");
        }

    }

    // Передаёт введеную пользователем строку
    // В text передаётся фраза для понимания что нужно вводить пользователю
    private static String choosingString(String text) {
        System.out.print(text);
        String result = iScanner.nextLine();

        return result;
    }

    // Создаёт List заполненный строками 
    // В text пеердаётся фраза которая выводит из бесконечного цикла
    private static List<String> choosingList(String text) {
        LinkedList<String> phone = new LinkedList<String>();
        Boolean flag = true;

        while (flag) {
            System.out.print("Введите номер телефона: ");
            phone.add(iScanner.nextLine());
            flag = sequel(text);
            System.out.println();
        }
        return phone;
    }

    // Выбор продолжать ли цикл 
    // В text пеердаётся фраза которая выводит из бесконечного цикла
    private static boolean sequel(String text) {
        boolean flag = true, result = true;
        String choise;

        while (flag) {
            System.out.print(text
                    + "\n 1. Да"
                    + "\n 2. Нет"
                    + "\n Выбор: ");
            choise = iScanner.nextLine();
            switch (choise) {
                case "1":
                    result = true;
                    flag = false;
                    break;
                case "2":
                    result = false;
                    flag = false;
                    break;
                default:
                    System.out.println("Введено неправильное число попробуйте снова: ");
                    break;
            }
            System.out.println();
        }

        return result;
    }


}
