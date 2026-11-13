package j1.s.p0056;

/**
 * Worker class represents a worker with personal detail and work information.
 *
 * @version 05/11/2026
 * @author HaiNT
 */
public class Worker {

    /**
     * The unique identification id of the worker.
     */
    private String id;

    /**
     * The name of worker.
     */
    private String name;

    /**
     * The age of worker.
     */
    private int age;

    /**
     * The current salary of worker
     */
    private int salary;

    /**
     * The working location assigned to the worker.
     */
    private String workLocation;

    /**
     * Default constructor.
     */
    public Worker() {
    }

    /**
     * Constructor to initialize Worker object with specific details.
     *
     * @param id The worker id
     * @param name The name of worker
     * @param age The age of worker
     * @param salary The salary of worker
     * @param workLocation The location where worker is assigned
     */
    public Worker(String id, String name, int age, int salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    /**
     * Get the worker's identification id.
     *
     * @return the worker ID
     */
    public String getId() {
        return id;
    }

    /**
     * Get the name of worker.
     *
     * @return the worker name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the age of worker.
     *
     * @return the worker's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the salary of worker.
     *
     * @return the worker's salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Get the work location
     *
     * @return the work location
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * Set the worker id.
     *
     * @param id the worker id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the name of worker.
     *
     * @param name the worker's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the age of worker.
     *
     * @param age the worker's age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Set the salary of worker.
     *
     * @param salary the worker's salary to set.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Set the work location.
     *
     * @param workLocation the work location to set
     */
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
}
