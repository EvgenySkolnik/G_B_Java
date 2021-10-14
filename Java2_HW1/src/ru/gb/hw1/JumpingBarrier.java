package ru.gb.hw1;

public class JumpingBarrier implements Obstacles {
    static int height = 2;
    @Override
    public void overcoming(Members m) {
        m.jump();
    }
}
