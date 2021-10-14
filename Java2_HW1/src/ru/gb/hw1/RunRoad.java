package ru.gb.hw1;

public class RunRoad implements Obstacles{
    static int distance = 500;
    @Override
    public void overcoming (Members m) {
        m.run();
    }
}
