package ru.bg.java3.hw4;

public class ABCCreator {

    char curLetter = 'A';

    synchronized void printA()  {
        for (int i = 0; i < 3; i++) {
            while (curLetter != 'A') {
                doWait();
            }
            System.out.print(curLetter);
            curLetter = 'B';
            notifyAll();

        }
    }
    synchronized void printB()  {
        for (int i = 0; i < 3; i++) {
            while (curLetter != 'B') {
                doWait();
            }
            System.out.print(curLetter);
            curLetter = 'C';
            notifyAll();

        }

    }
    synchronized void printC()  {
        for (int i = 0; i < 3; i++) {
            while (curLetter != 'C') {
                doWait();
            }
            System.out.print(curLetter + " ");
            curLetter = 'A';
            notifyAll();

        }

    }

    synchronized void doWait() {
        try {
            wait();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ABCCreator creator = new ABCCreator();
        new Thread(creator::printA).start();
        new Thread(creator::printB).start();
        new Thread(creator::printC).start();

    }
}
