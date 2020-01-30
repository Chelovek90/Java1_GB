package Lesson5;

public class Main {
    public static void main(String[] args) {
        Horse h = new Horse("Bucefal");
        Horse h1 = new Horse("Mustang");
        Bird b = new Bird("Karkysha");
        Dog d = new Dog("Sharik");
        Cat c = new Cat("Myrka");
        Cat c1 = new Cat("Ryaba");


        Animal[] zoo = {h, h1, b, d, c, c1};
        for (int i = 0; i < zoo.length; i++) {
            System.out.println();
            zoo[i].run(100);
            zoo[i].swim(20);
            zoo[i].jamp(0.2);
            System.out.println("---------------------------------------------------------------");
        }
    }
}
