package ru.gb.homeWork7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public boolean getSatiety() {
        return satiety;
    }


    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
    }


}
