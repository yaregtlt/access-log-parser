package ru.courses.crm;

public class Employee {
    private final String name;
    private Department department;

    Employee(String name) {
        this.name = name;
    }

    void setDepartment(Department department) {
        this.department = department;
    }

    Department getDepartment() {
        return department;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (isHead()) {
            return name + " начальник отдела " + department.getTitle();
        } else {
            return name + " работает в отделе " + department.getTitle()
                    + ", начальник которого " + department.getHead().getName();
        }
    }

    boolean isHead() {
        return department != null && department.getHead() == this;
    }
}