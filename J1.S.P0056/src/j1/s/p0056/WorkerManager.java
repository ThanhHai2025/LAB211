package j1.s.p0056;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * WorkerManager class manages worker information, salary adjustments, and
 * history tracking.
 *
 * @version 13/11/2026
 * @author HaiNT
 */
public class WorkerManager {

    /**
     * List to store all workers in the system.
     */
    private ArrayList<Worker> listWorker = new ArrayList<>();

    /**
     * List to store the history of salary adjustments for workers.
     */
    private ArrayList<SalaryHistory> listHistory = new ArrayList<>();

    /**
     * Finds the index of a worker in the list by their identification code.
     *
     * @param id the worker identification code to search for
     * @return the index of the worker if found, or -1 otherwise
     */
    private int getIndexWorker(String id) {
        for (int i = 0; i < listWorker.size(); i++) {

            // Check if the current worker's ID matches the search ID
            if (listWorker.get(i).getId().trim().equalsIgnoreCase(id.trim())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds a new worker to the database after validating constraints.
     *
     * @param worker the worker object to be added
     * @throws Exception if the id is null, already exists, age is out of range
     * 18-50, or salary is <= 0
     */
    public void addWorker(Worker worker) throws Exception {

        // Check if the worker ID is null
        if (worker.getId() == null) {
            throw new Exception("Worker id is null");
        }

        int constainWorker = getIndexWorker(worker.getId());

        // Check if the worker ID already exists in the DB
        if (constainWorker != -1) {
            throw new Exception("Existed worker in DB");
        }

        listWorker.add(worker);
        System.out.println("Add success");
    }

    /**
     * Increases the salary of a specified worker and saves the history.
     *
     * @param id the identification code of the worker
     * @param newSalary the amount of money to increase
     * @throws Exception if the worker does not exist or the amount is <= 0
     */
    public void increaseSalary(String id, int newSalary) throws Exception {
        int indexWorker = getIndexWorker(id);

        // Check if the worker does not exist in the DB
        if (indexWorker == -1) {
            throw new Exception("Not existed worker in DB");

            // Check if the increase amount is less than or equal to 0
        } else if (newSalary <= 0) {
            throw new Exception("Salary of worker must be greater than 0");
        }

        Worker worker = listWorker.get(indexWorker);
        worker.setSalary(worker.getSalary() + newSalary);
        saveSalaryHistory(worker, "UP");
        System.out.println("Increase salary success");
    }

    /**
     * Decreases the salary of a specified worker and saves the history.
     *
     * @param id the identification code of the worker
     * @param newSalary the amount of money to cut
     * @throws Exception if the worker does not exist, the amount is <= 0, or
     * exceeds current salary
     */
    public void decreaseSalary(String id, int newSalary) throws Exception {
        int indexWorker = getIndexWorker(id);

        // Check if the worker does not exist in the DB
        if (indexWorker == -1) {
            throw new Exception("Not existed worker in DB");

            // Check if the cut amount is less than or equal to 0    
        } else if (newSalary <= 0) {
            throw new Exception("Salary of worker must be greater than 0");
        }

        Worker worker = listWorker.get(indexWorker);
        // Check if the cut amount is greater than or equal to the current salary
        if (newSalary >= worker.getSalary()) {
            throw new Exception("Amount of money to cut must be less than current salary");
        }

        worker.setSalary(worker.getSalary() - newSalary);
        saveSalaryHistory(worker, "DOWN");
        System.out.println("Decrease salary success");
    }

    /**
     * Saves a record of the salary adjustment to the history list.
     *
     * @param worker the worker whose salary was modified
     * @param status the adjustment status ("UP" or "DOWN")
     */
    private void saveSalaryHistory(Worker worker, String status) {
        String id = worker.getId();
        String name = worker.getName();
        int age = worker.getAge();
        int salary = worker.getSalary();
        String workLocation = worker.getWorkLocation();

        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        SalaryHistory salaryHis = new SalaryHistory(id, name, age, salary, worker.getWorkLocation(), status, today.format(fmt));
        listHistory.add(salaryHis);
    }

    /**
     * Displays the sorted salary adjustment history of all workers in a table
     * format.
     */
    public void displaySalaryHistory() {
        System.out.printf("%-6s %-20s %-12s %-12s %-12s %-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        sortSalaryHistory();
        for (SalaryHistory workerSalary : listHistory) {
            System.out.println(workerSalary);
        }
    }

    /**
     * Sorts the salary history records alphabetically by worker code using
     * Bubble Sort.
     */
    private void sortSalaryHistory() {
        for (int i = 0; i < listHistory.size() - 1; i++) {
            boolean isChange = false;
            for (int j = 0; j < listHistory.size() - i - 1; j++) {
                SalaryHistory salaryA = listHistory.get(j);
                SalaryHistory salaryB = listHistory.get(j + 1);

                // Compare two codes alphabetically
                if (salaryA.getId().compareToIgnoreCase(salaryB.getId()) > 0) {
                    SalaryHistory temp = salaryA;
                    listHistory.set(j, salaryB);
                    listHistory.set(j + 1, temp);
                    isChange = true;
                }
            }
            // Break loop early if no swaps occurred
            if (!isChange) {
                break;
            }
        }
    }
}
