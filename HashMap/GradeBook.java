import java.util.HashMap;
import java.util.Map;

public class GradeBook {
    private final Map<String, Student> students;

    public GradeBook() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getID(), student);
        System.out.println("Student " + student.getName() + " is added.");
    }

    public void removeStudent(String ID) {
        Student removed = students.remove(ID);
        if (removed != null) {
            System.out.println("Student " + removed.getName() + " is removed.");
        } else {
            System.out.println("Student with ID = " + ID + " is not found. ");
        }
    }

    public Student findStudent(String ID) {
        return students.get(ID);
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students.values()) {
                System.out.println(student);
            }
        }
    }
}
