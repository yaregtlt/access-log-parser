package ru.courses.crm;

import java.util.Objects;

public class Department {
    private final String title;
    private Employee head;

    Department(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    Employee getHead() {
        return head;
    }

    void setHead(Employee employee) throws IllegalStateException {
        Objects.requireNonNull(employee, "Начальник отдела не может быть пустым.");
        if (!employee.getDepartment().equals(this)) {
            throw new IllegalStateException("Руководитель отдела обязан работать в своём отделе.");
        }

        this.head = employee;
    }

    @Override
    public String toString() {
        return "Отдел '" + title + "', начальник: " + (head != null ? head.getName() : "нет начальника");
    }
}