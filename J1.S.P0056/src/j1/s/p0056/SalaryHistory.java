package j1.s.p0056;

/**
 * SalaryHistory class represents the salary history of worker extended by
 * Worker class.
 *
 * @version 05/11/2026
 * @author HaiNT
 */
public class SalaryHistory extends Worker {

    /**
     * The adjustment status (UP or DOWN).
     */
    private String status;

    /**
     * The date when the salary adjustment occurred.
     */
    private String date;

    /**
     * Default constructor.
     */
    public SalaryHistory() {
        super();
    }

    /**
     * Constructor to initialize SalaryHistory object with specific details.
     *
     * @param id the worker's id
     * @param name the worker's name
     * @param age the worker's age
     * @param salary the updated salary
     * @param workLocation The location where worker is assigned
     * @param status the salary adjustment status
     * @param date The date of adjustment
     */
    public SalaryHistory(String id, String name, int age, int salary, String workLocation, String status, String date) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    /**
     * Get the salary adjustment status (UP/DOWN).
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Get the date of the salary adjustment.
     *
     * @return the adjustment date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the salary adjustment status.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Set the date of the salary adjustment.
     *
     * @param date the adjustment date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns a formatted string containing all salary history details for
     * display purposes.
     *
     * @return formatted string of salary history
     */
    @Override
    public String toString() {
        return String.format("%-6s %-20s %-12s %-12d %-12s %-20s", getId(), getName(), getAge(), getSalary(), status, date);
    }
}
