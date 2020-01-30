package Lesson5;

import java.util.Random;

public abstract class Animal {
    protected String name;
    protected int maxRun;
    protected double maxJump;
    protected int maxSwim;
    public Random dif = new Random();

    public Animal(String name, int maxRun, double maxJump, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun + dif.nextInt(100) - dif.nextInt(100);
        this.maxJump = maxJump+ + dif.nextInt(2) - dif.nextInt(2);
        this.maxSwim = maxSwim + dif.nextInt(10) - dif.nextInt(10);
    }
    public void run(int distanse) {
        if (distanse < maxRun) {
            System.out.println(name + " ran " + maxRun + " meters.");
        } else {
            System.out.println("This is a lot for me");
        }
    }
    public void swim(int distanseSwim) {
        if (distanseSwim < maxSwim){
            System.out.println(name + " swam " + maxSwim + " meters.");
        }else {
            System.out.println("This is a lot for me");
        }
    }
    public void jamp(double height) {
        if (height < maxJump){
            System.out.println(name + " jamped on " + maxJump + " meters.");
        }else {
            System.out.println("This is a lot for me");
        }
    }
}
