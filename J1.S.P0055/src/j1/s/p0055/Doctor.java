package j1.s.p0055;

/**
 * The Doctor class storing information such as doctor code, name,
 * specialization, and availability.
 *
 * @version 29/10/2026
 * @author HaiNT
 */
public class Doctor {

    /**
     * The code of the doctor.
     */
    private String code;

    /**
     * The name of the doctor.
     */
    private String name;

    /**
     * The Medical specialization of the doctor
     */
    private String specialization;

    /**
     * Number of available working hours
     */
    private int availability;

    /**
     * Constructor with full parameters.
     *
     * @param code The code of the doctor.
     * @param name The name of the doctor.
     * @param specialization The Medical specialization of the doctor
     * @param availability Number of available working hours
     */
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * gets the doctor code.
     *
     * @return doctor code.
     */
    public String getCode() {
        return code;
    }

    /**
     * set the d
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * sets the doctor name
     *
     * @param name of doctor.
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * This methods is formatted string of the doctor.
     *
     * @return formatted doctor information.
     */
    @Override
    public String toString() {
        return String.format("%-6s %-15s %-20s %7d",
                code, name, specialization, availability);
    }
}
