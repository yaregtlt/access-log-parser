package ru.study;

public class LineTooLongException extends RuntimeException {
    public LineTooLongException() {
    }

    @Override
    public String getMessage() {
        return "Строка длиннее 1024 символов";
    }
}