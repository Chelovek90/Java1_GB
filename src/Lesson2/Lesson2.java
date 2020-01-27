package Lesson2;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        int[] example1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        first(example1);
        int[] example2 = new int[8];
        second(example2);
        int[] example3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        third(example3);
        fourth(example3);
        int[][] example5 = new int[6][6];
        fifth(example5);
        int[] example6 = {10, 1, 2, 3, 4};
        System.out.println(sixth(example6));


    }

    /*
    1 Задать целочисленный массив, состоящий из элементов 0 и 1.
    Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     */
    public static void first(int[] massive) {
        System.out.println("Задание 1:");
        for (int i = 0; i < massive.length; i++) {
            massive[i] = massive[i] == 0 ? 1 : 0;
        }
        System.out.println(Arrays.toString(massive));
    }

    /*2 Задать пустой целочисленный массив размером 8.
    Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
     */
    public static void second(int[] massive) {
        System.out.println("Задание 2:");
//        massive [0] = 1;
        for (int i = 0, j = 1; i < massive.length; i++) {
            massive[i] = j;
            j += 3;
        }
        System.out.println(Arrays.toString(massive));
    }

    /*3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
     */
    public static void third(int[] massive) {
        System.out.println("Задание 3:");
        for (int i = 0; i < massive.length; i++) {
            massive[i] = massive[i] < 6 ? massive[i] * 2 : massive[i];
        }
        System.out.println(Arrays.toString(massive));
    }

    //
//    /*4 Задать одномерный массив.
//    Написать методы поиска в нём минимального и максимального элемента;
//     */
    public static void fourth(int[] massive) {
        System.out.println("Задание 4:");
        int a = massive[0];
        int b = massive[0];
        for (int value : massive) {
            a = Math.min(value, a);
            b = Math.max(value, b);
        }
        System.out.println("minimum = " + a + ", maximum = " + b);
    }

    /*5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    заполнить его диагональные элементы единицами, используя цикл(ы);
     */
    public static void fifth(int[][] massive) {
        System.out.println("Задание 5:");
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0, len = (massive[i].length); j < massive[i].length; j++) {
                if (i == j || i + j == len - 1)
                    massive[i][j] = 1;
                System.out.print(massive[i][j] + " ");
            }
            System.out.print(" \r\n");
        }
    }

    /*6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
     */
    public static boolean sixth(int[] massive) {
        System.out.println("Задание 6:");
        boolean result = false;
        int left = 0;
        int right = 0;
        for (int i = 0; i < massive.length; i++) {
            left += massive[i];
            right = 0;
            for (int j = massive.length - 1; j > i; j--) {
                right += massive[j];
            }
            if (left==right){
                result = true;
            }

//            System.out.print("left = " + left + ", right = " + right + " ");
//            System.out.print(" \r\n");
        }
        return result;
    }
}
