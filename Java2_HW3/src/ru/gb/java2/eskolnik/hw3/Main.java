package ru.gb.java2.eskolnik.hw3;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
 уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое
 слово.
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
 номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае
  однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять
 еще дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
  Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add()
   и get().
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1
        Map<String, Integer> qal = new HashMap<>();
        String[] arr = {"gold", "silver", "random", "man", "boy", "man", "silver", "gold", "sleep", "sheep"};

        for (int i = 0; i < arr.length; i++) {
            if (qal.containsKey(arr[i]))
                qal.put(arr[i], qal.get(arr[i]) + 1);
            else
                qal.put(arr[i], 1);
        }
        System.out.println(qal);

        // Tusk 2
        Phonebook phonebook = new Phonebook();
        phonebook.add("Sokolov", "910912");
        phonebook.add("Ignatov", "914919");
        phonebook.add("Sokolov", "910815");
        phonebook.add("Sidorov", "910923");
        phonebook.add("Sidorov", "910954");

        System.out.println(phonebook.get("Ignatov"));
    }

}
