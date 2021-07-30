package ru.gb.homeWork7;
// commit change
public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food - n >= 0) {
            food = food - n;
            return true;
        } else {
            System.out.println("low food level");
            return false;
        }
    }

    public void addFood(int food) {
        this.food = this.food + food;
    }

    public void info() {
        System.out.println("plate : " + food);
    }


}
