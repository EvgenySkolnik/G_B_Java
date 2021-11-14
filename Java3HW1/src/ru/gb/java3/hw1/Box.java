package ru.gb.java3.hw1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 3. Большая задача:
 a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в
 одну коробку нельзя сложить и яблоки, и апельсины;
 c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного
 фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую
 подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы
 можем сравнивать с коробками с апельсинами);
 f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про
 сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не
 остается, а в другую перекидываются объекты, которые были в этой коробке;
 g. Не забываем про метод добавления фрукта в коробку.
 */

public class Box<T extends Fruit> {

    private ArrayList<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public Box(T...fruits) {
        this.list = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float mass = 0.0f;
        for (T o : list) {
          mass +=o.getWeight();
        }
        return mass;
    }

    public void pour(Box<T> another) {
        another.list.addAll(list);
        list.clear();
    }

    public void add(T fruit) {
        list.add(fruit);
    }

    public void add(Collection<T> fruit) {
        list.addAll(fruit);
    }

    public boolean compare(Box<?> o) {
        return Math.abs(this.getWeight() - o.getWeight()) < 0.001;
    }


}
