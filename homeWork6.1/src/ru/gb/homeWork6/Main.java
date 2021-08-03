package ru.gb.homeWork6;
/*      1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается
         длина препятствия.
        Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать,
         собака 10 м.).
        4. * Добавить подсчет созданных котов, собак и животных.

 */
public class Main {
    public static void main(String[] args) {

            Dog dogBoby = new Dog ();
            Cat catStella = new Cat ();

            dogBoby.run(150);
            dogBoby.swim(10);
            catStella.run(100);
            catStella.swim(7);
    }
}

 class Dog extends Animal {
    @Override
      void run(int a) {
        if (a <= 500) {
            System.out.println("the dog run : " + a + " m");
        }
        else System.out.println("the dog run 500 m and got tired");
     }
     @Override
      void swim(int b) {
        if (b <= 10) {
            System.out.println("the dog swim : " + b + " m");
        }
        else System.out.println("the dog swim 10 m and got tired");
     }

 }

class Cat extends Animal {
    @Override
    void run(int a) {
        if (a <= 200) {
            System.out.println("Cat is run : " + a + " m");
        }
        else System.out.println("the cat run 200 m and got tired");
    }
    @Override
    void swim(int b) {
        System.out.println("the cat can`t swim !!!");
    }
}
