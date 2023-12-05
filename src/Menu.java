import java.util.Scanner;

public class Menu {
    private Patients patients;

    public Menu() {
        patients = new Patients();
    }

    public void runMenu() {
        while (true) {
            // Display the menu
            System.out.println("Welcome to the Hospital Management System");
            System.out.println("Select an option from the menu by entering its corresponding number:");
            System.out.println("1. Add a new patient to the system");
            System.out.println("2. Find a patient by ID");
            System.out.println("3. Find a patient by last name");
            System.out.println("4. Find a patient by first name");
            System.out.println("5. Find a patient by age range");
            System.out.println("6. Delete a patient by ID");
            System.out.println("0. Quit");
            System.out.println();
            System.out.print("Please enter a number: ");

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
                    return;
                default:
                    // User did not enter a valid number
                    System.out.println("Invalid choice; please try again. ");
                    System.out.println();
                    break;
            }
        }
    }

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

        Gender gender = Gender.UNKNOWN;
        if (genderInput.equalsIgnoreCase("F")) {
            gender = Gender.FEMALE;
        } else if (genderInput.equalsIgnoreCase("M")) {
            gender = Gender.MALE;
        } // TODO: tell the user if input is invalid

        System.out.print("Please enter additional notes if any: ");
        String notes = scanner.nextLine();

        int id = patients.getNumOfPatients();

        Patient patient = new Patient(firstName, lastName, id, age, gender, notes);
        patients.addPatient(patient);

        System.out.println("Patient added! " + patient);
        System.out.print("Press enter to return to the main menu");
        scanner.nextLine();
        System.out.println("************************************************************************");
    }

    private void findById() {}

    private void findByLastName() {}

    private void findByFirstName() {}

    private void findByAgeRange() {}

    private void removePatient() {}
}
