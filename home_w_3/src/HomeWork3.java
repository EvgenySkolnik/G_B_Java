
//changes to commit


public class HomeWork3 {
    public static void main(String[] args) {

        doTask1();
        doTask2();
        doTask3();
        doTask4();
        doTask5(5,18);
        doTask6();
        System.out.println( doTask7(arr1));
        doTask8(arr2,2);


    }


    /*      1. Задать целочисленный массив, состоящий из элементов 0 и 1.
             Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить
             0 на 1, 1 на 0;
*/
    private static void doTask1() {
       int [] arr = {0,0,1,0,1,1,0} ;
       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] +" - original  ");

           if (arr[i] ==0)
               arr[i] = 1;
           else
               arr[i] =0;

           System.out.println(arr[i] +" - invert");
       }
    }

    /*2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
         значениями 1 2 3 4 5 6 7 8 … 100;*/
    private static void doTask2() {
        int arr[] = new int[100];

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] = i+1);
    }

    /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    и числа меньшие 6 умножить на 2;*/
    private static void doTask3() {
        int arr[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int num =0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 6)
                System.out.println( arr[i] + " - old num < 6; " + " - new num = " + (num = arr[i] * 2));
            else System.out.println(arr[i] + " - old num >=6 ");
        }
    }
    /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
            одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
            (можно только одну из диагоналей, если обе сложно). Определить элементы одной из
    диагоналей можно по следующему принципу: индексы таких элементов равны, то
    есть [0][0], [1][1], [2][2], …, [n][n];*/
    private static void doTask4() {
        int cou =1;
        int [][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j)
                    arr[i][j] = 1;

            System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
    /*5. Написать метод, принимающий на вход два аргумента: len и initialValue,
    и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна
    initialValue; */
    private static void doTask5(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] = initialValue);
        }
        return;
    }

    /* Задать одномерный массив и найти в нем минимальный и максимальный элементы ; */
    private static void doTask6() {
        int max = 0 ;
        int min = 100;
        int[] arr = {10, 3, 18, 6, 22, 5, 12, 7};
        for (int i = 0; i < arr.length; i++ ) {
            if (arr[i] > max)
                max = arr[i];
            else if (arr[i] < min)
                min = arr[i];
        }
        System.out.println("max = " + max + " min = " + min);
    }

    /*Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
    части массива равны */
       static int [] arr1 = {3,3,3,3,3,3};
    private static boolean doTask7(int[] arr1) {
        int len = arr1.length;
        int rSum;
        int lSum;
        for (int i = 0; i < len -1; i++) {
            rSum = 0;
            lSum = 0;
            for (int j = 0; j <= i; j++) {
                lSum +=arr1[j];
            }
            for (int l = i +1; l < len; l++) {
                rSum += arr1[l];
            }
            if (lSum == rSum)
                return true;
        }
        return false;
    }

    /*8. *** Написать метод, которому на вход подается одномерный массив и число n
            (может быть положительным, или отрицательным), при этом метод должен сместить все
    элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи
    нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на
    один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) ->
            [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    */
    static int[] arr2 = {1,2,3};
    private static void doTask8(int[] arr2, int n) {
        // Пока выше моего понимания !!!!
    }

}
