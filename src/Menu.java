import java.util.Scanner;

public class Menu {
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
            }
        }
    }

    private void addPatient() {}

    private void findById() {}

    private void findByLastName() {}

    private void findByFirstName() {}

    private void findByAgeRange() {}

    private void removePatient() {}
}
