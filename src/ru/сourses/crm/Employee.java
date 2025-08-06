package ru.сourses.crm;

public class Employee {
    private final String name;
    private Department department;

    public Employee(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
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

    private boolean isHead() {
        return department != null && department.getHead() == this;
    }
}