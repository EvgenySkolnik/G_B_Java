package ru.gb.java3.hw7;

import java.lang.reflect.*;
import java.util.*;

/* Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов с аннотациями @Test.
 Для этого у него должен быть статический метод start(), которому в качестве параметра передается или объект типа Class, или
 имя класса. Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется, далее
 запущены методы с аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite. К каждому тесту
 необходимо также добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет выбираться порядок их
 выполнения, если приоритет одинаковый, то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite
 должны присутствовать в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
 */

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        start(Test.class);
        System.out.println();
        start(Test1.class);
        System.out.println();
        start("ru.geekbrains.java3.dz.dz7.morozalexander.Test3");
        System.out.println();
        //start("ru.geekbrains.java3.dz.dz7.morozalexander.Test4"); // exception
    }

    public static void start(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = c.getDeclaredMethods();
        int bsCount = 0, asCount = 0;
        List<Method> tests = new ArrayList<>();

        // check on uniqueness for BEFORE & AFTER SUITES. Adding TESTS to ArrayList
        for (Method o : methods) {
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
            if (type.equals("BeforeSuite")) {
                bsCount++;
                if (bsCount > 1) throw new RuntimeException("You can use only 1 before annotation.");
            } else if (type.equals("AfterSuite")) {
                asCount++;
                if (asCount > 1) throw new RuntimeException("You can use only 1 after annotation.");
            } else if (type.equals("Test")) {
                tests.add(o);
            }
        }

        // Sort TESTS list by VALUE
        tests.sort((o1, o2) -> o1.getAnnotation(Test.class).value() - o2.getAnnotation(Test.class).value());

        // Add BEFORE SUITE to begin of TESTS & AFTER SUITE to the end.
        for (Method o : methods) {
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
            if (type.equals("BeforeSuite")) {
                tests.add(0, o);
            }
            if (type.equals("AfterSuite")) {
                tests.add(o);
            }
        }

        // Show info. Run TESTS
        for (Method i : tests) {
            try {
                System.out.print("(" + i.getDeclaredAnnotation(Test.class).value() + ") ");
            } catch (NullPointerException e) {

            }
            i.invoke(c.newInstance(), null);
        }
    }


    public static void start(String className) {
        try {
            Class<?> c = Class.forName(className);
            Constructor<?> constructor = c.getConstructor(null);
            start(c);
        } catch (InvocationTargetException | InstantiationException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
