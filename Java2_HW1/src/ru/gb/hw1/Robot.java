package ru.gb.hw1;

public class Robot implements Members {
    int endurans = 3000;
    int jamping = 0;
    @Override
    public void run() {
        if (endurans >= RunRoad.distance) {
            System.out.println("Robot is running !");
        } else {
            System.out.println("Robot couldn`t run the distance : " + RunRoad.distance + "m");
        }
    }
    @Override
    public void jump() {
        if (jamping >= JumpingBarrier.height) {
            System.out.println("Robot is jumping !");
        } else {
            System.out.println("Robot couldn`t jump the barrier : " + JumpingBarrier.height + "m");
        }
    }
}
