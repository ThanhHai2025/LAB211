package j1.s.p0056;

/**
 * Main class to run WorkerManager program.
 *
 * @version 13/11/2026
 * @author HaiNT
 */
public class Main {

    public static void main(String[] args) {

        //Initialize the validation and mamanger object.
        Validation validation = new Validation();
        WorkerManager manager = new WorkerManager();
        String id;
        String name;
        int age;
        int salary;
        String workLocation;

        boolean running = true;

        // Main application loop
        while (running) {
            System.out.println("======== Worker Management =========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display Information salary");
            System.out.println("5. Exit");

            // Get user menu choice
            int choice = validation.getInt("Enter: ", 1, 5, "Please choose from 1 to 5!");
            switch (choice) {
                // Option 1: Add a new worker
                case 1:
                    System.out.println("--------- Add Worker ----------");
                    while (true) {
                        try {
                            id = validation.getString("Enter Code: ");
                            name = validation.getString("Enter Name: ");
                            age = validation.getInt("Enter age: ", 18, 50, "Workers must be between 18 and 50 years of age.");
                            salary = validation.getInt("Enter Salary: ", 1, Integer.MAX_VALUE, "Salary of worker must be greater than 0.");
                            workLocation = validation.getString("Enter work location: ");

                            manager.addWorker(new Worker(id, name, age, salary, workLocation));
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                // Option 2: Increase worker salary
                case 2:
                    System.out.println("------------ UP -------------");
                    id = validation.getString("Enter Code: ");
                    salary = validation.getInt("Enter Salary: ", 1, Integer.MAX_VALUE, "Salary of worker must be greater than 0.");
                    try {
                        manager.increaseSalary(id, salary);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                // Option 3: Decrease worker salary
                case 3:
                    System.out.println("----------- DOWN ------------");
                    id = validation.getString("Enter Code: ");
                    salary = validation.getInt("Enter Salary: ", 1, Integer.MAX_VALUE, "Salary of worker must be greater than 0.");
                    try {
                        manager.decreaseSalary(id, salary);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                // Option 4: Display salary adjustment history    
                case 4:
                    System.out.println("---------------Display Information Salary------------------");
                    manager.displaySalaryHistory();
                    break;

                // Option 5: Exit the program    
                case 5:
                    running = false;
                    System.out.println("Exited propram");
                    break;
                default:
                    System.out.println("Invalid selection; please try again.");
            }
        }
    }
}
