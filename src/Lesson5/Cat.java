package Lesson5;

public class Cat extends Animal{
    private static final int maxRun = 200;
    private static final double maxJump = 2;
    private static final int maxSwim=1;

    public Cat (String name) {
        super(name, maxRun, maxJump, maxSwim);
    }


    @Override
    public void swim(int distanseSwim) {
        System.out.println("I can't swim");
    }
}
