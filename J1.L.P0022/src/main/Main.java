    package main;

    import controller.CandidateManager;
    import util.Validation;

    /**
     * Main class to run Candidate Manager system program.
     *
     * @version 02/11/2026
     * @author HaiNT
     */
    public class Main {

        public static void main(String[] args) {
            //Initialize validation and manager object.
            Validation validation = new Validation();
            CandidateManager manager = new CandidateManager(validation);

            while (true) {
                //Step 1: Display the main menu.
                System.out.println("CANDIDATE MANAGEMENT SYSTEM");
                System.out.println("1. Experience");
                System.out.println("2. Fresher");
                System.out.println("3. Intership");
                System.out.println("4. Searching");
                System.out.println("5. Exit");

                //Step 2: Get user choice from menu (1 to 5).
                int choice = validation.getInt("Please choose (1-5): ", 1, 5);
                switch (choice) {
                    case 1:
                        //Create Experience candidate (type = 0).
                        manager.createCandidate(0);
                        break;
                    case 2:
                        //Create Fresher candidate (type = 1).
                        manager.createCandidate(1);
                        break;
                    case 3:
                        //Create Intern candidate (type = 2).
                        manager.createCandidate(2);
                        break;
                    case 4:
                        //Search candidate by name and type.
                        manager.searchCandidate();
                        break;
                    case 5:
                        //Exit the program.
                        System.out.println("Exit Program.");
                        return;
                }
                System.out.println();
            }
        }
    }
