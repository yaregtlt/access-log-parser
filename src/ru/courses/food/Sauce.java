package ru.courses.food;

public class Sauce {
    private String name;
    private Spiciness spiciness;

    // Конструктор класса
    public Sauce(String name, Spiciness spiciness) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название должно быть задано.");
        }
        this.name = name;
        this.spiciness = spiciness;
    }

    // Метод для возврата текстового представления соуса
    @Override
    public String toString() {
        return "Соус " + name + ": " + spiciness.toString();
    }
}
