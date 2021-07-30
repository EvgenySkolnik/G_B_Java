package ru.gb.homeWork7;
// commit change
public class MainClass {

    public static void main(String[] args) {
        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Barsik", 5);
        cat[1] = new Cat("Murzik", 5);
        cat[2] = new Cat("Begimot", 5);
        Plate plate = new Plate(10);

        System.out.println("Наши три кота " + cat[0].getName() + ", " + cat[1].getName() + ", " + cat[2].getName() + ", ");
        plate.info();
        for (int i = 0; i < 3; i++) {
            cat[i].eat(plate);
            if (cat[i].getSatiety()) {
                System.out.println("Кот " + cat[i].getName() + " Сыт");
            } else {
                System.out.println("Кот " + cat[i].getName() + " Остался голодный.");
                System.out.println("Наполним тарелку");
                plate.addFood(15);
            }
        }

        plate.info();
    }
}
