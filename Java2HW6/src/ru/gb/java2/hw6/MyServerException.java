package ru.gb.java2.hw6;

public class MyServerException extends RuntimeException {
    public MyServerException(String message) {
        super(message);
    }
    public MyServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
