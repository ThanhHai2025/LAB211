package model;

/**
 * Subclass representing an Intern Candidate.
 *
 * @version 02/11/2026
 * @author HaiNT
 */
public class Intern extends Candidate {

    /**
     * Major field of study.
     */
    private String majors;

    /**
     * Current semester.
     */
    private String semester;

    /**
     * University name.
     */
    private String universityName;

    /**
     * Default constructor.
     */
    public Intern() {
        super();
    }

    /**
     * Constructor all parameter for Intern Candidate.
     *
     * @param candidateId Candidate ID
     * @param firstName First name
     * @param lastName Last name
     * @param birthDate Birth year
     * @param address Address
     * @param phone Phone number
     * @param email Email address
     * @param candidateType Candidate type (3 for Intern)
     * @param majors Major field of study
     * @param semester Current semester
     * @param universityName University name
     */
    public Intern(String candidateId, String firstName, String lastName, int birthDate,
            String address, String phone, String email, int candidateType,
            String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    /**
     * Get the major field of study.
     *
     * @return major string
     */
    public String getMajors() {
        return majors;
    }

    /**
     * Get the current semester.
     *
     * @return semester string
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Get the university name.
     *
     * @return university name string
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * Set the major field of study.
     *
     * @param majors majors to set
     */
    public void setMajors(String majors) {
        this.majors = majors;
    }

    /**
     * Set the current semester.
     *
     * @param semester semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Set the university name.
     *
     * @param universityName university name to set
     */
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
