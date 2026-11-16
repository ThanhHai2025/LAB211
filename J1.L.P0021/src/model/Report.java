package model;

/**
 * The Report class store the total course count of a student for a specific
 * course.
 *
 * @version 16/11/2026
 * @author HaiNT
 */
public class Report {

    /**
     * The student ID.
     */
    private String studentId;

    /**
     * The student name.
     */
    private String studentName;

    /**
     * The student course name.
     */
    private String courseName;

    /**
     * The total number of course registrations.
     */
    private int totalCourse;

    /**
     * Constructor a Report object.
     *
     * @param studentId The student ID
     * @param studentName The student name
     * @param courseName the student course name
     * @param totalCourse The total number of course registrations
     */
    public Report(String studentId, String studentName, String courseName, int totalCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    /**
     * Get the student ID.
     *
     * @return the studentId string
     */
    public String getStudentId() {
        return studentId;
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
     * Get the student course name.
     *
     * @return course name string
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Get the total number of course registrations.
     *
     * @return total course integer
     */
    public int getTotalCourse() {
        return totalCourse;
    }
}
