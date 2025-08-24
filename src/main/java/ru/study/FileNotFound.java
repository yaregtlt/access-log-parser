package ru.study;

import java.io.FileNotFoundException;

public class FileNotFound extends FileNotFoundException{
    public FileNotFound() {
    }

    @Override
    public String getMessage() {
        return "Файл не существует";
    }
}
