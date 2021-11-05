package ru.gb.java2.hw6;

public class MyClientException extends RuntimeException {
    public MyClientException(String message) {
        super(message);
    }
    public MyClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
