package ru.gb.hw1;

public class Cat implements Members {
    int endurans = 200;
    int jamping = 3;
    @Override
    public void run() {
        if (endurans >= RunRoad.distance) {
            System.out.println("Cat is running !");
        } else {
            System.out.println("Cat couldn`t run the distance : " + RunRoad.distance + "m");
        }
    }
    @Override
    public void jump() {
        if (jamping >= JumpingBarrier.height) {
            System.out.println("Cat is jumping !");
        } else {
            System.out.println("Cat couldn`t jump the barrier : " + JumpingBarrier.height + "m");
        }
    }
}
