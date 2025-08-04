import java.util.Objects;

public class Department {
    private final String title;
    private Employee head;

    public Department(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee employee) throws IllegalStateException {
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