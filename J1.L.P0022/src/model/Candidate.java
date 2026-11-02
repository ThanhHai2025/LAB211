package model;

/**
 * Abstract superclass presenting a general Candidate in the system.
 *
 * @version 02/11/2026
 * @author HaiNT
 */
public abstract class Candidate {

    /**
     * Candidate unique Id.
     */
    private String candidateId;

    /**
     * Candidate First Name.
     */
    private String firstName;

    /**
     * Candidate Last Name.
     */
    private String lastName;

    /**
     * Birth Year(4 digits, from 1900 to current year).
     */
    private int birthDate;

    /**
     * Candidate contact address.
     */
    private String address;

    /**
     * Phone number(10 digits).
     */
    private String phone;

    /**
     * Email address.
     */
    private String email;

    /**
     * Candidate Type (0: Experience, 1: Fresher, 2: Internship).
     */
    private int candidateType;

    /**
     * Default constructor.
     */
    public Candidate() {
    }

    /**
     * Constructor to initialize all common candidate attributes.
     *
     * @param candidateId Candidate Id
     * @param firstName First Name
     * @param lastName Last Name
     * @param birthDate Birth Year
     * @param address Address
     * @param phone Phone number
     * @param email Email address
     * @param candidateType Candidate type code
     */
    public Candidate(String candidateId, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    /**
     * Get the candidate ID.
     *
     * @return candidate ID string
     */
    public String getCandidateId() {
        return candidateId;
    }

    /**
     * Get the candidate first name.
     *
     * @return first name string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the candidate last name.
     *
     * @return last name string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the candidate birth year.
     *
     * @return birth year integer.
     */
    public int getBirthDate() {
        return birthDate;
    }

    /**
     * Get the candidate address.
     *
     * @return address string
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the candidate phone number.
     *
     * @return phone number string
     */
    public String getPhone() {
        return phone;
    }

    /**
     * get the candidate email address.
     *
     * @return email string
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the candidate type.
     *
     * @return candidate type integer
     */
    public int getCandidateType() {
        return candidateType;
    }

    /**
     * Set the candidate ID.
     *
     * @param candidateId candidate ID to set
     */
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    /**
     * Set the candidate first name.
     *
     * @param firstName first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the candidate last name.
     *
     * @param lastName last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the candidate birth year.
     *
     * @param birthDate birth year to set
     */
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Set the candidate address.
     *
     * @param address address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the candidate phone number.
     *
     * @param phone phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set the candidate email address.
     *
     * @param email email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the candidate type.
     *
     * @param candidateType candidate type to set
     */
    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }
}
