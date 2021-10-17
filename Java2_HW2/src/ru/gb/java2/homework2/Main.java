package ru.gb.java2.homework2;

/*
    1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче
        массива другого размера необходимо бросить исключение MyArraySizeException.
    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
        текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в
        какой именно ячейке лежат неверные данные.
     3. В методе main() вызвать полученный метод, обработать возможные исключения
        MySizeArrayException и MyArrayDataException, и вывести результат расчета.
*/

public class Main {
    public static void main(String[] args) {

        String[][] mass = new String [4][4];
        mass[0]=new String[]{"1", "2", "3", "4"};
        mass[1]=new String[]{"5", "6", "7", "8"};
        mass[2]=new String[]{"9", "1", "1", "2"};
        mass[3]=new String[]{"3", "4", "2", "4"};


        try {
            try {
                int res = comparison_method(mass);
                System.out.println(res);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка в ячейке: " + (e.i+1) + " x " + (e.j+1));
        }

    }

    private static int comparison_method(String[][] mass) throws MyArraySizeException, MyArrayDataException {
        int con = 0;
        if (mass.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < mass.length; i++) {
            if (mass[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < mass[i].length; j++) {
                try {
                    con = con + Integer.parseInt(mass[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return con;
    }

}
