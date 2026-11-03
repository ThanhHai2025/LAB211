package controller;

import java.util.ArrayList;
import java.util.List;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import util.Validation;

/**
 * CandidateManager class to manage candidate operation (Creation and Search).
 *
 * @version 02/11/2026
 * @author HaiNT
 */
public class CandidateManager {

    /**
     * List to store all candidates in the system.
     */
    private List<Candidate> candidateList;

    /**
     * Validation utility instance for input handling.
     */
    private Validation validation;

    /**
     * Constructor initializing the candidate list and validation instance.
     *
     * @param validation Validation object for input handling
     */
    public CandidateManager(Validation validation) {
        candidateList = new ArrayList<>();
        this.validation = validation;
    }

    /**
     * Check if a Candidate ID already exist in the system list.
     *
     * @param id Candidate ID to check
     * @return true if ID exist, otherwise false
     */
    private boolean isIdExist(String id) {
        //Iterate through all existing candidates
        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Display all candidates grouped by candidate type.
     */
    private void displayAllCandidates() {
        //Display Experience candidates.
        System.out.println("\nList of candidate: ");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate candidate : candidateList) {
            //Print name is object is an instance of Experience.
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        //Display Fresher candidates.
        System.out.println("===========FRESHER CANDIDATE============");
        for (Candidate candidate : candidateList) {
            //Print name is object is an instance of Fresher.
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        //Display Intern candidates.
        System.out.println("===========INTERN CANDIDATE============");
        for (Candidate candidate : candidateList) {
            //Print name is object is an instance of Intern.
            if (candidate instanceof Intern) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

    /**
     * Create a new candidate based on type (0: Experience, 1: Fresher, 2:
     * Intern).
     *
     * @param type Candidate type integer code
     */
    public void createCandidate(int type) {

        //Loop continuously to allow adding multiple candidates.
        while (true) {
            System.out.println("----------------------------------");
            // Determine candidate type based on input.
            String candidateType;
            switch (type) {
                case 0:
                    candidateType = "Experience";
                    break;
                case 1:
                    candidateType = "Fresher";
                    break;
                case 2:
                    candidateType = "Intern";
                    break;
                default:
                    System.out.println("Invalid candidate type!");
                    return;
            }
            System.out.println("Entering information for " + candidateType + " candidate: ");

            //Step 1: Input common information
            String id;
            while (true) {
                id = validation.getString("Enter ID: ");
                //Check if ID already exist
                if (!isIdExist(id)) {
                    break;
                }
                System.err.println("Candidate ID already exist! Please enter another ID.");
            }
            String firstName = validation.getString("Enter First Name: ");
            String lastName = validation.getString("Enter Last Name: ");
            int birthDate = validation.getBirthDate("Enter Birth Date (1900-Current Year): ");
            String address = validation.getString("Enter Address: ");
            String phone = validation.getPhone("Enter Phone (min 10 digits): ");
            String email = validation.getEmail("Enter Email: ");

            //Step 2: Input specific inforamtion based on Candidate type (0: Experience, 1: Fresher, 2: Intern).
            if (type == 0) {
                int expInYear = validation.getYearOfExp("Enter Year of experience (0-100): ");
                String proSkill = validation.getString("Enter Professional skill: ");

                //Create Experience candidate object to list.
                Candidate exp = new Experience(id, firstName, lastName, birthDate,
                        address, phone, email, type, expInYear, proSkill);
                candidateList.add(exp);
            } else if (type == 1) {
                String gradudationDate = validation.getString("Enter Graduation time: ");
                String graduationRank = validation.getGraduationRank("Enter Rank of graduation (Excellence/Good/Fair/Poor): ");
                String education = validation.getString("Enter University where graduated: ");

                //Create Fresher candidate object to list.
                Candidate fresher = new Fresher(id, firstName, lastName, birthDate,
                        address, phone, email, type, gradudationDate, graduationRank, education);
                candidateList.add(fresher);
            } else if (type == 2) {
                String majors = validation.getString("Enter Majors: ");
                String semester = validation.getString("Enter Semester: ");
                String universityName = validation.getString("Enter University Name: ");

                //Create Intern candidate object to list.
                Candidate intern = new Intern(id, firstName, lastName, birthDate,
                        address, phone, email, type, majors, semester, universityName);
                candidateList.add(intern);
            }
            System.out.println("Candidate created successfully!");

            //Ask if user wants to continue adding more candidates of this type.
            boolean continueChoice = validation.getYN("Do you want to continue (Y/N)? : ");
            if (!continueChoice) {
                System.out.println("\nList of created candidate: ");
                displayAllCandidates();
                break;
            }
        }
    }

    /**
     * Search candidates by name and candidate type.
     */
    public void searchCandidate() {
        //Check if candidate list is empty
        if (candidateList.isEmpty()) {
            System.err.println("The candidate list is current empty!");
            return;
        }
        // Step 1: Display all candidates grouped by type.
        System.out.println("\nList of candidates:");
        displayAllCandidates();

        //Step 2: Read search criteria from user.
        String searchName = validation.getString("\nInput Candidate name(First name or Last name): ");
        int searchType = validation.getInt("Inpue type of candidate (0: Experience, 1: Fresher, 2: Intern): ", 0, 2);
        System.out.println("\nThe candidate found: ");
        boolean found = false;

        //Step 3:Iterate through list to display matching candidate.
        for (Candidate candidate : candidateList) {
            //Check if candidate type matches search type.
            if (candidate.getCandidateType() == searchType) {
                //Check if full name contains search keyword (case-insensitive)
                String fullName = (candidate.getFirstName() + " " + candidate.getLastName()).toLowerCase();
                if (fullName.contains(searchName.toLowerCase())) {
                    System.out.printf("%-15s | %-7s | %-15s | %-12s | %-20s | %-5d%n", 
                            candidate.getFirstName() + " " + candidate.getLastName(),
                            candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), 
                            candidate.getEmail(), candidate.getCandidateType());
                    found = true;
                }
            }
        }
        if (!found) {
            System.err.println("No candidate found matching your criteria.");
        }
    }
}
