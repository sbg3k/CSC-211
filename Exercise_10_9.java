import java.lang.Cloneable;

public class Course implements Cloneable {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {

        if (numberOfStudents >= students.length) {
            String[] newStudents = new String[students.length + 1];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            students = newStudents;
        }
        students[numberOfStudents++] = student;
    }

    public String[] getStudents() {

        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < students.length; i++) {
            if (student.equalsIgnoreCase(students[i])) {
                students[i] = null;
                numberOfStudents--;
                while (i < numberOfStudents) {
                    students[i] = students[i + 1];
                    i++;
                }
                break;
            }
        }
    }

    public void clear(){
        students = new String[10];
        numberOfStudents = 0;
    }

    public Object clone() {
        Course course = null;
        try {
            course = (Course)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        course.students = students.clone();
        course.courseName = new String(courseName);
        return course;
    }
}

public class opStudent {

    public static void main(String[] args) {

        Course course = new Course("Maths");

        //adds 3
        for (int i = 0; i < 3; i++) {
            course.addStudent("Number " + (i + 1));
        }

        
        //removes one
        for (int i = 0; i < 1; i++) {
            course.dropStudent("Student " + (i));
        }

        String[] all = course.getStudents();
        System.out.println("Students in course " + course.courseName);
        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.printf(all[i]);
        }
        System.out.println("Total number of students is " + course.getNumberOfStudents());

    }
}
