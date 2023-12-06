import java.util.Scanner;

public class Menu {
    // Stores all patients
    private Patients patients;

    /**
     * Initiates the patients object
     */
    public Menu() {
        patients = new Patients();
    }

    /**
     * Runs the menu, allows the user to input different options
     */
    public void runMenu() {
        // This while loop will iterate forever unless the user chooses to quit the program, so the user can perform as many tasks as desired
        while (true) {
            // Display the menu
            System.out.println("Welcome to the Hospital Management System");
            System.out.println("Select an option from the menu by entering its corresponding number:");
            System.out.println("1. Add a new patient to the system");
            System.out.println("2. Find a patient by ID");
            System.out.println("3. Find a patient by last name");
            System.out.println("4. Find a patient by first name");
            System.out.println("5. Find a patient by age range");
            System.out.println("6. Remove a patient by ID");
            System.out.println("0. Quit");
            System.out.println();
            System.out.print("Please enter a number: ");

            // Scans the user input and perform corresponding action
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    findById();
                    break;
                case 3:
                    findByLastName();
                    break;
                case 4:
                    findByFirstName();
                    break;
                case 5:
                    findByAgeRange();
                    break;
                case 6:
                    removePatient();
                    break;
                case 0:
                    // Adds a confirmation upon exit to prevent quiting by accident
                    if (confirmQuit()) {
                        return;
                    }
                    break;
                default:
                    // User did not enter a valid number
                    System.out.println("Invalid choice; please try again. ");
                    System.out.println();
                    break;
            }
        }
    }

    /**
     * Prompts the user for the required fields of a new patient and adds the new patient to the system
     */
    private void addPatient() {
        // Display the prompts
        System.out.println("Adding new patient");
        System.out.print("Please enter the first name of the patient: ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();

        System.out.print("Please enter the last name of the patient: ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter the age of the patient: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // prevents the scanner from skipping the next input

        System.out.print("Please enter the gender of the patient, F for female, M for male: ");
        String genderInput = scanner.nextLine();

        Gender gender = Gender.UNKNOWN; // If user did not enter a valid input, leave it as unknown
        if (genderInput.equalsIgnoreCase("F")) {
            gender = Gender.FEMALE;
        } else if (genderInput.equalsIgnoreCase("M")) {
            gender = Gender.MALE;
        }

        System.out.print("Please enter additional notes, or press enter to skip: ");
        String notes = scanner.nextLine();

        // Retrieves the ID number tracker from patients
        int id = patients.getIdNumber();

        Patient patient = new Patient(firstName, lastName, id, age, gender, notes);
        patients.addPatient(patient);

        // Displays a response and line breaker for readability
        System.out.println("Patient added! " + patient);
        System.out.print("Press enter to return to the main menu");
        scanner.nextLine();
        System.out.println("************************************************************************");
    }

    /**
     * Prompts the user for an ID number and finds the patient with the ID
     */
    private void findById() {
        System.out.println("Finding patient by ID");
        System.out.print("Please enter the patient's ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine(); // Prevents skipping input

        // Displays a response and line breaker for readability
        System.out.println(patients.findById(id));
        System.out.print("Press enter to return to the main menu");
        scanner.nextLine();
        System.out.println("************************************************************************");
    }

    /**
     * Prompts the user for a last name and finds the patients with the last name
     */
    private void findByLastName() {
        System.out.println("Finding patient by last name");
        System.out.print("Please enter the patient's last name: ");
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        // Displays a response and line breaker for readability
        System.out.println(patients.findByLastName(lastName));
        System.out.print("Press enter to return to the main menu");
        scanner.nextLine();
        System.out.println("************************************************************************");
    }

    /**
     * Prompts the user for a first name and finds the patients with the first name
     */
    private void findByFirstName() {
        System.out.println("Finding patient by first name");
        System.out.print("Please enter the patient's first name: ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();

        // Displays a response and line breaker for readability
        System.out.println(patients.findByFirstName(firstName));
        System.out.print("Press enter to return to the main menu");
        scanner.nextLine();
        System.out.println("************************************************************************");
    }

    /**
     * Prompts the user for a minimum and a maximum age and finds the patients within the age range
     */
    private void findByAgeRange() {
        System.out.println("Finding patient by age range");
        System.out.print("Please enter the minimum age: ");
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the maximum age, enter the same number if searching for a single age: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        // Displays a response and line breaker for readability
        System.out.println(patients.findByAgeRange(min, max));
        System.out.print("Press enter to return to the main menu");
        scanner.nextLine();
        System.out.println("************************************************************************");
    }

    /**
     * Prompts the user for an ID and removes that patient
     */
    private void removePatient() {
        System.out.println("Removing a patient");
        System.out.print("Please enter the patient's ID to be removed: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();

        // Displays a response and line breaker for readability
        System.out.println("Patient removed! " + patients.removePatient(id));
        System.out.print("Press enter to return to the main menu");
        scanner.nextLine();
        System.out.println("************************************************************************");
    }

    /**
     * Asks the user for confirmation on exit
     * @return true if confirmed, otherwise false
     */
    private boolean confirmQuit() {
        System.out.print("Are you sure to exit? (Y/N) ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            System.out.println("Goodbye!");
            return true;
        }
        System.out.println("************************************************************************");
        return false;
    }
}
