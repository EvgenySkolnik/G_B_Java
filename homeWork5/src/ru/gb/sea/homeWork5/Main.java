package ru.gb.sea.homeWork5;
//commit up
public class Main {
    public static void main(String[] args) {


        Colleague[] persArr = new Colleague[5];
        persArr[0] = new Colleague("Иван Иванов", "Генеральный директор", "ivanov@mail.ru","+79996661111", 1700, 50);
        persArr[1] = new Colleague("Иван Петров", "Водитель", "petrov@mail.ru","+79996662222", 700, 53);
        persArr[2] = new Colleague("Петр Иванов", "Заместитель директора", "ivanovm@mail.ru","+79996663333", 1000, 23);
        persArr[3] = new Colleague("Лора Петрова", "Бухгалтер", "petrova@mail.ru","+79996664444", 1200, 45);
        persArr[4] = new Colleague("Лиза Иванова", "Снабженец", "ivanova@mail.ru","+79996665555", 900, 25);


        for (int i = 0; i < persArr.length; i++) {
            if (persArr[i].getAge() >=40 ) {
                persArr[i].showInfo();
            }
        }
    }



}
