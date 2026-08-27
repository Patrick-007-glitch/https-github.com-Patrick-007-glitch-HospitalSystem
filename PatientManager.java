package hospital;

import java.util.ArrayList;

public class PatientManager {
    private ArrayList<Patient> patients = new ArrayList<>();
    
    public PatientManager() {
        // Constructor
    }
    
    public boolean registerPatient(Patient patient) {
        for (Patient p : patients) {
            if (p.getPatientID().equals(patient.getPatientID())) {
                return false;
            }
        }
        patients.add(patient);
        return true;
    }
    
    public Patient searchPatient(String patientID) {
        for (Patient p : patients) {
            if (p.getPatientID().equals(patientID)) {
                return p;
            }
        }
        return null;
    }
    
    public boolean updatePatient(String patientID, String firstName, String lastName,
                                 int age, String gender, String medicalCondition) {
        Patient patient = searchPatient(patientID);
        if (patient == null) {
            return false;
        }
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setAge(age);
        patient.setGender(gender);
        patient.setMedicalCondition(medicalCondition);
        return true;
    }
    
    public boolean deletePatient(String patientID) {
        Patient patient = searchPatient(patientID);
        if (patient == null) {
            return false;
        }
        patients.remove(patient);
        return true;
    }
    
    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        System.out.println("\n--- All Registered Patients ---");
        for (Patient p : patients) {
            p.displayDetails();
            System.out.println("-------------------");
        }
    }
    
    public ArrayList<Patient> getAllPatients() {
        return patients;
    }
}