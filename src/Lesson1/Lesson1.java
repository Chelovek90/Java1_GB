package Lesson1;

public class Lesson1 {
    public static void main(String[] args) {
//        System.out.println(first(1, 2, 3, 4));
//        System.out.println(second(10, 1));
        third(2);
        fourth("Иван");
        fifth(2020);
    }

    public static float first(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean second(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void third(int a) {
        if (a < 0) {
            System.out.println("number " + a + "is negative");
        } else {
            System.out.println("number " + a + " is positive");
        }
    }
    public static void fourth (String name){
        System.out.println("Привет, " + name + "!");
    }
    public static void fifth (int year) {
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) {
            System.out.println("А год-то невисокосный");
        } else {
            System.out.println("А год-то високосный");
        }
    }
}
