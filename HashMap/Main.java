public class Main {
    public static void main(String[] args) {

        GradeBook studentsGradeBook = new GradeBook();

        Student student1 = new Student("S001", "Sherlock Holmes");
        student1.addGrade(95);
        student1.addGrade(80);
        student1.addGrade(85);

        Student student2 = new Student("S002", "John Watson");
        student2.addGrade(88);
        student2.addGrade(92);
        student2.addGrade(70);

        Student student3 = new Student("S003", "Irene Adler");
        student3.addGrade(65);
        student3.addGrade(80);
        student3.addGrade(75);

        Student student4 = new Student("S004", "Gregory Lestrade");
        student4.addGrade(82);
        student4.addGrade(78);
        student4.addGrade(89);

        Student student5 = new Student("S005", "James Moriarty");
        student5.addGrade(65);
        student5.addGrade(70);
        student5.addGrade(68);

        studentsGradeBook.addStudent(student1);
        studentsGradeBook.addStudent(student2);
        studentsGradeBook.addStudent(student3);
        studentsGradeBook.addStudent(student4);
        studentsGradeBook.addStudent(student5);

        System.out.println("\nAll students in the grade book:");
        studentsGradeBook.displayAll();

        System.out.println("\nSearching for student with ID S003:");
        Student foundStudent = studentsGradeBook.findStudent("S003");
        if (foundStudent != null) {
            System.out.println("Found: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("\nRemoving student with ID S004:");
        studentsGradeBook.removeStudent("S004");

        System.out.println("\nGrade book after student removal:");
        studentsGradeBook.displayAll();
    }
}
