package ru.gb.hw1;

public class Man implements Members {
    int endurans = 1500;
    int jamping = 2;
    @Override
    public void run() {
        if (endurans >= RunRoad.distance) {
            System.out.println("Man is running !");
        } else {
            System.out.println("Man couldn`t run the distance : " + RunRoad.distance + "m");
        }
    }
    @Override
    public void jump() {
        if (jamping >= JumpingBarrier.height) {
            System.out.println("Man is jumping !");
        } else {
            System.out.println("Man couldn`t jump the barrier : " + JumpingBarrier.height + "m");
        }
    }

}
