package model;

/**
 * Subclass representing a Fresher Candidate.
 *
 * @version 02/11/2026
 * @author HaiNT
 */
public class Fresher extends Candidate {

    /**
     * Graduation time/date
     */
    private String graduationDate;

    /**
     * Rank of graduation (Excellence, Good, Fair, Poor)
     */
    private String graduationRank;

    /**
     * University where candidate graduated.
     */
    private String education;

    /**
     * Default constructor
     */
    public Fresher() {
        super();
    }

    /**
     * Constructor all parameter for Fresher Candidate.
     *
     * @param candidateId Candidate ID
     * @param firstName First name
     * @param lastName Last name
     * @param birthDate Birth year
     * @param address Address
     * @param phone Phone number
     * @param email Email address
     * @param candidateType Candidate type (1 for Fresher)
     * @param graduationDate Graduation time/date
     * @param graduationRank Rank of graduation
     * @param education University name
     */
    public Fresher(String candidateId, String firstName, String lastName,
            int birthDate, String address, String phone, String email, int candidateType,
            String graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    /**
     * Get the graduation date.
     *
     * @return graduation date string
     */
    public String getGraduationDate() {
        return graduationDate;
    }

    /**
     * Get the rank of graduation.
     *
     * @return graduation rank string
     */
    public String getGraduationRank() {
        return graduationRank;
    }

    /**
     * Get the university/education background.
     *
     * @return education string
     */
    public String getEducation() {
        return education;
    }

    /**
     * Set the graduation date.
     *
     * @param graduationDate graduation to set
     */
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    /**
     * Set the rank of graduation.
     *
     * @param graduationRank graduation rank to set
     */
    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    /**
     * Set the university/education background.
     *
     * @param education education to set
     */
    public void setEducation(String education) {
        this.education = education;
    }
}
