package j1.s.p0011;

/**
 * Main class to run the program.
 *
 * @version 06/10/2026
 * @author HaiNT
 */
public class Main {

    public static void main(String[] args) {

        Validation validation = new Validation();
        Manager manager = new Manager();

        while (true) {

            // Step 1: Choose input base
            manager.displayBaseMenu("CHOOSE INPUT BASE");
            int fromChoice = validation.getInt( "Choose input base (1-3): ", 1, 3);
            manager.setFromBase(manager.choiceToBase(fromChoice));

            // Step 2: Choose output base
            manager.displayBaseMenu("CHOOSE OUTPUT BASE");
            int toChoice = validation.getInt("Choose output base (1-3): ", 1, 3);
            manager.setToBase( manager.choiceToBase(toChoice));

            // Step 3: Enter input value
            String inputValue = validation.getValueByBase(
                    "Enter input value: ",
                    manager.getFromBase()
            );

            manager.setInputValue(inputValue);

            // Step 4: Convert value
            String result = manager.convert();

            // Step 5: Display result
            System.out.println("Output value: " + result);

            // Step 6: Ask user whether to continue
            boolean isContinue = validation.getYN("Do you want to continue? (Y/N): ");
            if (!isContinue) {
                System.out.println("End the program!");
                break;
            }
            System.out.println();
        }
    }
}