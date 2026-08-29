package hospital;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        PatientManager manager = new PatientManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=====================================");
        System.out.println("  HOSPITAL PATIENT ADMISSION SYSTEM   ");
        System.out.println("=====================================");

        while (true) {
            System.out.println("\n--- Patient Management Menu ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Display All Patients");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (choice == 1) {
                // Register Patient
                System.out.println("\n--- Register New Patient ---");
                System.out.print("Patient ID: ");
                String id = scanner.nextLine();
                System.out.print("First Name: ");
                String firstName = scanner.nextLine();
                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Medical Condition: ");
                String condition = scanner.nextLine();
                System.out.print("Category (INPATIENT, OUTPATIENT, EMERGENCY): ");
                String catStr = scanner.nextLine().toUpperCase();
                PatientCategory category = PatientCategory.valueOf(catStr);

                Patient patient = new Patient(id, firstName, lastName, age, gender, condition, category);
                boolean success = manager.registerPatient(patient);
                if (success) {
                    System.out.println("Patient registered successfully.");
                } else {
                    System.out.println("Patient ID already exists.");
                }

            } else if (choice == 2) {
                // Search Patient
                System.out.print("Enter Patient ID to search: ");
                String id = scanner.nextLine();
                Patient patient = manager.searchPatient(id);
                if (patient != null) {
                    System.out.println("\n--- Patient Found ---");
                    patient.displayDetails();
                } else {
                    System.out.println("Patient not found.");
                }

            } else if (choice == 3) {
                // Update Patient
                System.out.print("Enter Patient ID to update: ");
                String id = scanner.nextLine();
                Patient patient = manager.searchPatient(id);
                if (patient == null) {
                    System.out.println("Patient not found.");
                    continue;
                }

                System.out.println("Enter new details (leave blank to keep current):");
                System.out.print("First Name (" + patient.getFirstName() + "): ");
                String firstName = scanner.nextLine();
                if (!firstName.isEmpty()) patient.setFirstName(firstName);

                System.out.print("Last Name (" + patient.getLastName() + "): ");
                String lastName = scanner.nextLine();
                if (!lastName.isEmpty()) patient.setLastName(lastName);

                System.out.print("Age (" + patient.getAge() + "): ");
                String ageInput = scanner.nextLine();
                if (!ageInput.isEmpty()) patient.setAge(Integer.parseInt(ageInput));

                System.out.print("Gender (" + patient.getGender() + "): ");
                String gender = scanner.nextLine();
                if (!gender.isEmpty()) patient.setGender(gender);

                System.out.print("Medical Condition (" + patient.getMedicalCondition() + "): ");
                String condition = scanner.nextLine();
                if (!condition.isEmpty()) patient.setMedicalCondition(condition);

                System.out.println("Patient details updated.");

            } else if (choice == 4) {
                // Delete Patient
                System.out.print("Enter Patient ID to delete: ");
                String id = scanner.nextLine();
                boolean success = manager.deletePatient(id);
                if (success) {
                    System.out.println("Patient deleted successfully.");
                } else {
                    System.out.println("Patient not found.");
                }

            } else if (choice == 5) {
                // Display All Patients
                manager.displayAllPatients();

            } else if (choice == 6) {
                // Exit
                System.out.println("Exiting system. Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
