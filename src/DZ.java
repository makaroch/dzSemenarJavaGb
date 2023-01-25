import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DZ {
    public static void main(String[] args) {
        // System.out.println(task1());
        // System.out.println(task2());
        // System.out.println(2%);
        // task3(1000);

        /* начало 4 задачки */
        // {
        // double x = getNumberDouble("Введите число");
        // double y = getNumberDouble("Введите число");
        // String symbol = getChar("введите действие");
        // System.out.println(task4(x, y, symbol));
        // }
        /* конец 4 задачки */

        /* начало 5 задачки */
        {// ?5 + ?1?? = 56
         // ["?5?","+","?1??","=","5555"]

            String strPrimer = task5Viem();
            ArrayList<Integer> indexes = new ArrayList<Integer>();

            for (int i = 0; i < strPrimer.length(); i++) {// добабим все элементы где есть вопросы в лист
                if (strPrimer.charAt(i) == '?') {
                    indexes.add(i);
                }
            }
            if (indexes.size() == 0) {
                System.out.println("в веденом примере нет знака ?");
                return;
            }

            // ? = 4; 10000 001 002 9999
            int lengthFor = (int) Math.pow(10, indexes.size());

            String res = "";
            // System.out.println(lengthFor);

            for (int i = 0; i < lengthFor; i++) {// i = 0
                res = task5FindSolution(strPrimer, indexes, i);
                if (res != "") {
                    System.out.println("решение: " + res);
                    return;
                }
            }
            System.out.println("решений нет");
        }
        /* конец 5 задачки */

    }

    static String task5FindSolution(String primerStr, ArrayList list, int num) {
        String numStr = Integer.toString(num);
        while (numStr.length() < list.size()) {
            numStr = "0" + numStr;
        } // ? = 3 0 ; 021

        for (int i = 0; i < numStr.length(); i++) {
            StringBuilder sb = new StringBuilder(primerStr);

            int index = (int) list.get(i);
            char ch = numStr.charAt(i);

            sb.setCharAt(index, ch);
            primerStr = sb.toString();
        }

        String[] arrStr = primerStr.split(" ");
        int[] arrInt = new int[3];

        arrInt[0] = Integer.parseInt(arrStr[0]); // 20
        arrInt[1] = Integer.parseInt(arrStr[2]); // 30
        arrInt[2] = Integer.parseInt(arrStr[4]); // 56

        if (arrInt[2] == task4(arrInt[0], arrInt[1], arrStr[1])) {
            return primerStr;
        }

        return "";
    }

    static String task5Viem() {
        Scanner scan = new Scanner(System.in);
        System.out.println("введи пример");
        String s = scan.nextLine();
        scan.close();
        return s;
    }

    static double task4(double num1, double num2, String symbol) {
        return switch (symbol) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> num1 / num2;
        };

    }

    static void task3(int num) {
        // Вывести все простые числа от 1 до 1000
        boolean flag = true;
        for (int i = 1; i < num; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.print("Число " + i + " простое, ");
            flag = true;

        }
    }

    static int task2() {
        // Вычислить n! (произведение чисел от 1 до n)
        int num = getNumberInt("Введите число");
        int mult = 1;
        for (int i = 1; i <= num; i++) {
            mult *= i;
        }
        return mult;
    }

    static int task1() {
        // (сумма чисел от 1 до n)
        int num = getNumberInt("Введите число");
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

    static int getNumberInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt())
            return scanner.nextInt();
        else
            return getNumberInt("Всетаки нужно ввести число");

    }

    static double getNumberDouble(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt())
            return scanner.nextInt();
        else
            return getNumberDouble("Всетаки нужно ввести число");

    }

    static String getChar(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String symb = scanner.next();
        if (symb.equals("+") || symb.equals("-") || symb.equals("*") || symb.equals("/"))
            return symb;
        else
            return getChar(message);

    }

}
