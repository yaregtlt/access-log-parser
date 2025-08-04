import java.util.Arrays;

public class Student {
    private final String name;
    private int[] grades = new int[0];

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int... initialGrades) {
        this(name);
        addGrades(initialGrades);
    }

    public void addGrade(int grade) {
        if (grade >= 2 && grade <= 5) {
            int[] temp = new int[grades.length + 1];
            System.arraycopy(grades, 0, temp, 0, grades.length);
            temp[temp.length - 1] = grade;
            grades = temp;
        } else {
            throw new IllegalArgumentException("Оценка должна быть между 2 и 5");
        }
    }

    public void addGrades(int... newGrades) {
        for (int g : newGrades) {
            addGrade(g);
        }
    }

    public String getGrades() {
        return Arrays.toString(grades);
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                ", Оценки: " + Arrays.toString(grades);
    }

}
