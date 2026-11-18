package controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Report;
import model.Student;
import util.Validation;

/**
 * The StudentManager class manage student records and handle student
 * operations.
 *
 * @version 17/11/206
 * @author HaiNT
 */
public class StudentManager {

    /**
     * List to store all students in the system.
     */
    private ArrayList<Student> studentList;

    /**
     * Validation utility instance for input handling.
     */
    private Validation validation;

    /**
     * Construct a Manager object.
     *
     * @param validation object used to validate user input
     */
    public StudentManager(Validation validation) {
        studentList = new ArrayList<>();
        this.validation = validation;
    }

    /**
     * Create student records.
     */
    public void createStudent() {
        int count = 0;
        while (true) {
            System.out.println("\nCreate Student");
            String id = validation.getString("Enter student ID: ");
            String name = validation.getString("Enter student name: ");
            int semester = validation.getInt("Enter semester: ", 1, Integer.MAX_VALUE);
            String courseName = validation.getCourse("Enter course name (Java, .Net or C/C++): ");

            Student student = new Student(id, name, semester, courseName);
            if (checkIdDifferentName(id, name)) {
                System.err.println("This ID belongs to another student!");
                continue;
            }
            if (isStudentExist(id, semester, courseName, null)) {
                System.err.println("This student is exist!");
                continue;
            }
            studentList.add(student);
            count++;
            System.out.println("Student added successfully!");
            if (count >= 10) {
                boolean answer = validation.getYN("Do you want to continue (Y/N)?: ");
                if (!answer) {
                    break;
                }
            }
        }
    }

    /**
     * Finds students by name and sorts the result.
     */
    public void findAndSort() {
        //Ask whether list student is empty.
        if (studentList.isEmpty()) {
            System.err.println("Student list is empty");
            return;
        }

        String name = validation.getString("Enter student name: ");
        ArrayList<Student> result = new ArrayList<>();

        //Find students whose names contain the entered keyword.
        for (Student student : studentList) {
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(student);
            }
        }
        if (result.isEmpty()) {
            System.err.println("No student found!");
            return;
        }

        //Sort student by name using Compareable.
        Collections.sort(result);
        System.out.printf("%-10s %-15s %-10s %-10s%n", "ID", "Student Name", "Semester", "Course");
        for (Student student : result) {
            System.out.println(student);
        }
    }

    /**
     * Finds a student by ID and allows the user to update or delete a record.
     */
    public void updateOrDelete() {
        //Ask whether list student is empty.
        if (studentList.isEmpty()) {
            System.err.println("Student list is empty");
            return;
        }
        String id = validation.getString("Enter student ID: ");
        ArrayList<Student> result = getListStudentById(id);
        if (result.isEmpty()) {
            System.err.println("No student found!");
            return;
        }

        Student selected;
        //Select a registration when the student has multiple records.
        if (result.size() == 1) {
            selected = result.get(0);
        } else {
            System.out.println("Student has multiple registrations:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((i + 1) + ". " + result.get(i));
            }
            int choice = validation.getInt("Choose a record: ", 1, result.size());
            selected = result.get(choice - 1);
        }

        boolean update = validation.getUD("Do you want to update (U) or delete (D)?: ");
        if (update) {
            //Updates the selected student's information.
            updateStudent(selected);
        } else {
            //Delete student.
            studentList.remove(selected);
            System.out.println("Student record deleted successfully.");
        }
    }

    /**
     * Checks whether an ID belongs to a different student name.
     *
     * @param id student ID to check
     * @param name student name to compare
     * @return true if the ID belongs to a different name
     */
    private boolean checkIdDifferentName(String id, String name) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)
                    && !student.getStudentName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the student already exists.
     *
     * @param id student ID
     * @param semester student semester
     * @param courseName student course
     * @param excluded record excluded from the comparison
     * @return true if a student exists
     */
    private boolean isStudentExist(String id, int semester, String courseName, Student excluded) {
        for (Student student : studentList) {
            if (student != excluded
                    && student.getId().equalsIgnoreCase(id)
                    && student.getSemester() == semester
                    && student.getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets all student records matching the given ID.
     *
     * @param id student ID to search for
     * @return list of matching student records
     */
    private ArrayList<Student> getListStudentById(String id) {
        ArrayList<Student> result = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                result.add(student);
            }
        }
        return result;
    }

    /**
     * Updates the selected student's information.
     *
     * @param selected student record to update
     */
    private void updateStudent(Student selected) {
        String oldId = selected.getId();

        System.out.println("\nEnter new student information:");

        String newId = validation.getString("Enter new ID: ");
        String newName = validation.getString("Enter new name: ");
        int newSemester = validation.getInt("Enter new semester: ", 1,
                Integer.MAX_VALUE);
        String newCourse = validation.getCourse("Enter new course name: ");

        if (checkIdDifferentName(newId, newName)
                && !newId.equalsIgnoreCase(oldId)) {
            System.out.println("This ID belongs to another student.");
            return;
        }

        if (isStudentExist(newId, newSemester, newCourse, selected)) {
            System.out.println("This student registration already exists.");
            return;
        }

        // Update ID and name for all records belonging to this student.
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(oldId)) {
                student.setId(newId);
                student.setStudentName(newName);
            }
        }

        // Update semester and course for the selected registration.
        selected.setSemester(newSemester);
        selected.setCourseName(newCourse);

        System.out.println("Student updated successfully.");
    }

    /**
     * Creates and displays a report grouped by student ID and course name.
     */
    public void report() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }
        ArrayList<Report> reportList = new ArrayList<>();

        // Count registrations for each student and course.
        for (Student student : studentList) {
            int index = findReport(reportList, student.getId(), student.getCourseName());

            if (index == -1) {
                Report report = new Report(student.getId(), student.getStudentName(), student.getCourseName(), 1);
                reportList.add(report);
            } else {
                Report oldReport = reportList.get(index);
                Report newReport = new Report(oldReport.getStudentId(), oldReport.getStudentName(), oldReport.getCourseName(), oldReport.getTotalCourse() + 1);
                reportList.set(index, newReport);
            }
        }
        System.out.printf("%-15s %-15s %-15s%n", "Student Name", "Course", "Total Course");
        for (Report report : reportList) {
            System.out.printf("%-15s %-15s %-15d%n", report.getStudentName(), report.getCourseName(), report.getTotalCourse());
        }
    }

    /**
     * Finds a report by student ID and course name.
     *
     * @param reportList list of reports
     * @param id student ID
     * @param courseName course name
     * @return index of the matching report, or -1 if not found
     */
    private int findReport(ArrayList<Report> reportList, String id, String courseName) {
        for (int i = 0; i < reportList.size(); i++) {
            Report report = reportList.get(i);
            if (report.getStudentId().equalsIgnoreCase(id)
                    && report.getCourseName().equalsIgnoreCase(courseName)) {
                return i;
            }
        }
        return -1;
    }
}
