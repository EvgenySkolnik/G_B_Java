
/* 1. Написать метод, принимающий на вход два целых числа и проверяющий,
 что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
  в противном случае – false.

2. Написать метод, которому в качестве параметра передается целое число,
 метод должен напечатать в консоль, положительное ли число передали или
  отрицательное. Замечание: ноль считаем положительным числом.

3. Написать метод, которому в качестве параметра передается целое число.
 Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.

4. Написать метод, которому в качестве аргументов передается строка и
 число, метод должен отпечатать в консоль указанную строку, указанное количество раз;

5. * Написать метод, который определяет, является ли год високосным,
 и возвращает boolean (високосный - true, не високосный - false).
  Каждый 4-й год является високосным, кроме каждого 100-го, при этом
   каждый 400-й – високосный.
*/


public class HomeWorkTwo {
    public static void main(String[] args) {
        compareTwoNumbers(15,5);
        plusOrMinus(0);
        minusOrPlus(0);
        stringAndNumber("Hello knowledge", 3);
        System.out.println(leapYear(400));

    }

    private static void compareTwoNumbers (int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 20)
            System.out.println("true");
        else
            System.out.println("false");
    }

    private static void plusOrMinus (int a) {
        if (a >= 0)
            System.out.println("A positive number is entered");
        else
            System.out.println("A negative number is entered");
    }
    private static void minusOrPlus (int a) {
        if (a < 0)
            System.out.println("true");
        else
            System.out.println("false");
    }

    private static void stringAndNumber (String a, int b) {
        for (int i=0; i < b ; i++)
            System.out.println(a);
    }

     static boolean leapYear (int a) {
        if (a%4 ==0 ) {
            if ((a%100 !=0) || (a%400 ==0)) {
                return true;
            }
        }
         return false;
     }



}
