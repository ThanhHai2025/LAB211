package model;

/**
 * Subclass representing an Experience Candidate.
 *
 * @version 02/11/2026
 * @author HaiNT
 */
public class Experience extends Candidate {

    /**
     * Year of experiences (0 - 100).
     */
    private int expInYear;

    /**
     * Professional skill description.
     */
    private String proSkill;

    /**
     * Default constructor.
     */
    public Experience() {
        super();
    }
    

    /**
     * Constructor all parameter for Experience Candidate.
     *
     * @param candidateId Candidate ID
     * @param firstName First name
     * @param lastName Last name
     * @param birthDate Birth year
     * @param address Address
     * @param phone Phone number
     * @param email Email address
     * @param candidateType Candidate type (0 for Experience)
     * @param expInYear Year of experience
     * @param proSkill Professional skill
     */
    public Experience(String candidateId, String firstName, String lastName,
            int birthDate, String address, String phone, String email,
            int candidateType, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    /**
     * Get the year of experience.
     *
     * @return year of experience integer
     */
    public int getExpInYear() {
        return expInYear;
    }

    /**
     * Get the professional skill.
     *
     * @return professional skill string
     */
    public String getProSkill() {
        return proSkill;
    }

    /**
     * Set the year of experience.
     *
     * @param expInYear year of experience to set
     */
    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    /**
     * Set the professional skill.
     *
     * @param proSkill professional skill to set
     */
    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

}
