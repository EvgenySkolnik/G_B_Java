package ru.gb.sea.homeWork5;
// commit up
public class Colleague {
    private String name;
    private String post;
    private String email;
    private String phone;
    private int wages;
    private int age;

    public int getAge() {
        return age;
    }


    public Colleague(String name, String post, String email, String phone, int wages, int age) {
       this.name = name;
       this.post = post;
       this.email = email;
       this.phone = phone;
       this.wages = wages;
       this.age = age;

    }

    public void showInfo() {
        /* System.out.println("Full name - " + name);
        System.out.println("Post - " + post);
        System.out.println("Email - " + email);
        System.out.println("phone - " + phone);
        System.out.println("Wages - " + wages);
        System.out.println("Age - " + age);
        */

        System.out.printf("Имя: %s \tДолжность: %s \nEmail: %s \t Номер телефона: %s \n Зарплата: %d \t Возраст: %d \n",
                name, post, email, phone, wages, age);
    }

}
