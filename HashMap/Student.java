import java.util.List;
import java.util.ArrayList;

public class Student {
    private final String ID;
    private final String name;
    private final List<Integer> grades;

    public Student(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Grades: " + grades;
    }
}
