package Lesson5;

public class Dog extends Animal{
    private static final int maxRun = 500;
    private static final double maxJump = 0.5;
    private static final int maxSwim = 10;

    public Dog (String name) {
        super(name, maxRun, maxJump, maxSwim);
    }
}
