package model;

/**
 * The Student class store student information such as id, student name,
 * semester and course name.
 *
 * @version 16/11/2026
 * @author HaiNT
 */
public class Student implements Comparable<Student> {

    /**
     * The student ID.
     */
    private String id;

    /**
     * The student name.
     */
    private String studentName;

    /**
     * The student semester.
     */
    private int semester;

    /**
     * The student course name.
     */
    private String courseName;

    /**
     * Constructor a Student object.
     *
     * @param id The student ID
     * @param studentName The student name
     * @param semester The student semester
     * @param courseName the student course name
     */
    public Student(String id, String studentName, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * Get the student ID.
     *
     * @return student ID string
     */
    public String getId() {
        return id;
    }

    /**
     * Set the student ID.
     *
     * @param id student ID to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the student name.
     *
     * @return student name string
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Set the student name.
     *
     * @param studentName student name to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Get the student semester.
     *
     * @return semester integer
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Set the student semester.
     *
     * @param semester semester to set
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Get the student course name.
     *
     * @return course name string
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Set the student course name.
     *
     * @param courseName course name to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Compare two students by their name.
     *
     * @param o other the student to compare
     * @return a negative integer, zero, or a positive integer
     */
    @Override
    public int compareTo(Student o) {
        return this.studentName.compareToIgnoreCase(o.studentName);
    }

    /**
     * Return student information as a format string.
     *
     * @return student information
     */
    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10d %-10s", id, studentName, semester, courseName);
    }
}
