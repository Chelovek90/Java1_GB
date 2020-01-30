package Lesson5;

public class Bird extends Animal{

    private static final int maxRun = 5;
    private static final double maxJump = 0.2;
    private static final int maxSwim=1;

    public Bird (String name) {
        super(name, maxRun, maxJump, maxSwim);
    }


    @Override
    public void swim(int distanseSwim) {
        System.out.println("I can't swim");
    }
}
