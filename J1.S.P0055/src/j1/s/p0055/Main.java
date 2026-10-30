package j1.s.p0055;

import java.util.List;

/**
 * Main class to test DoctorManager program.
 *
 * @version 29/10/2026
 * @author HaiNT
 */
public class Main {

    public static void main(String[] args) {

        Validation validator = new Validation();

        //B2: Create DoctorManager Object.
        DoctorManager manager = new DoctorManager();

        while (true) {

            //B3: Display a menu.
            System.out.println("========= Doctor Management =========");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");

            //B4: Enter the choice from user.
            int choice = validator.getInt(
                    "Your choice: ",
                    "Choice must be from 1 to 5.",
                    "Invalid number!",
                    1, 5);

            //B5: Process the choice from input.
            switch (choice) {
                //TH1: Adding the new doctor
                case 1:
                    System.out.println("-------- Add Doctor --------");
                    String code = validator.getString("Enter Code: ", "Invalid code!", "(?i)doc\\s\\d+");
                    String name = validator.getString("Enter Name: ", "Name cannot be empty!", ".+");
                    String spec = validator.getString("Enter Specialization: ", "Specialization cannot be empty!", ".+");
                    int avail = validator.getInt("Enter Availability: ", "Availability must be >= 0",
                            "Invalid number!", 1, Integer.MAX_VALUE);
                    Doctor addDoctorObj = new Doctor(code, name, spec, avail);

                    try {
                        manager.addDoctor(addDoctorObj);
                        System.out.println("Add successful.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //Th2: Update the doctor.
                // Case 2: Update Doctor
                case 2:
                    System.out.println("-------- Update Doctor --------");
                    code = validator.getString("Enter Code: ", "Invalid code!", "(?i)doc\\s\\d+");
                    name = validator.getString("Enter Name: ", "Invalid input!", ".*");
                    spec = validator.getString("Enter Specialization: ", "Invalid input!", ".*");
                    avail = validator.getOptionalInt("Enter Availability: ", "Availability must be >= 0",
                            "Invalid number!", 0, Integer.MAX_VALUE, -1);

                    Doctor updateDoctorObj = new Doctor(code, name, spec, avail);
                    try {
                        manager.updateDoctor(updateDoctorObj);
                        System.out.println("Update successful.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //Th3: Delete the doctor.
                case 3:
                    System.out.println("-------- Delete Doctor --------");
                    code = validator.getString("Enter Code: ", "Invalid code!", "(?i)doc\\s\\d+");

                    try {
                        manager.deleteDoctor(code);
                        System.out.println("Delete successful.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //Th4: Search the doctor.
                case 4:
                    System.out.println("-------- Search Doctor --------");
                    String text = validator.getString("Enter text: ", "Invalid input!", ".*");

                    try {
                        List<Doctor> result = manager.searchDoctor(text);

                        // Nếu chạy đến đây tức là chắc chắn tìm thấy
                        System.out.println("-------- Result --------");
                        System.out.printf("%-6s %-15s %-20s %s%n",
                                "Code", "Name", "Specialization", "Availability");
                        for (Doctor doctor : result) {
                            System.out.println(doctor);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //Th5: Exit the program.
                case 5:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}
