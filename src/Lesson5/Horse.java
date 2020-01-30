package Lesson5;

import java.util.Random;

public class Horse extends Animal {

    private static final int maxRun = 1500;
    private static final double maxJump = 3;
    private static final int maxSwim = 100;

    public Horse (String name) {
        super(name, maxRun, maxJump, maxSwim);
    }

}
