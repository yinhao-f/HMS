import java.util.ArrayList;

public class Patients {
    private ArrayList<Patient> patientList;
    // private long numOfPatients; // might be replaced by size()

    public Patients() {
        this.patientList = new ArrayList<Patient>();
    }

    public void addPatient(Patient patient) {
        // Add patient in alphabetical order of last name
        int lowerBound = 0;
        int upperBound = patientList.size();
        int i = patientList.size() / 2;
        int compare;
        while ((upperBound - lowerBound) > 0) {
            compare = patient.compareTo(patientList.get(i));
            if (compare > 0) {
                // go higher
                lowerBound = i + 1; // when the number of remaining elements is 2, skip the one already compared
                i = (upperBound + lowerBound) / 2;
            } else if (compare < 0) {
                // go lower
                upperBound = i;
                i = (upperBound + lowerBound) / 2;
            } else {
                break;
            }
        }
        patientList.add(i, patient);
    }

    public Patient findById(int id) {
        for (Patient patient :
                patientList) {
            if (patient.getPatientId() == id) {
                return patient;
            }
        }

        // No patient is found; return empty patient
        return new Patient();
    }

    public ArrayList<Patient> findByLastName(String lastName) {
        ArrayList<Patient> matchingLastName = new ArrayList<Patient>();
        // TODO: replace with a binary search
        for (Patient patient :
                patientList) {
            if (patient.getLastName().equals(lastName)) {
                matchingLastName.add(patient);
            }
        }
        return matchingLastName;
    }

    public ArrayList<Patient> findByFirstName(String firstName) {
        ArrayList<Patient> matchingFirstName = new ArrayList<Patient>();
        for (Patient patient :
                patientList) {
            if (patient.getFirstName().equals(firstName)) {
                matchingFirstName.add(patient);
            }
        }

        return matchingFirstName;
    }

    public ArrayList<Patient> findByAgeRange (int minAge, int maxAge) {
        ArrayList<Patient> matchingAgeRange = new ArrayList<Patient>();
        for (Patient patient :
                patientList) {
            if ((patient.getAge() >= minAge) && (patient.getAge() <= maxAge)) {
                matchingAgeRange.add(patient);
            }
        }
        return matchingAgeRange;
    }

    public Patient removePatient(int patientId) {
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getPatientId() == patientId) {
                Patient removed = patientList.get(i);
                patientList.remove(i);
                return removed;
            }
        }
        return new Patient();
    }

    public int getNumOfPatients() {
        return patientList.size();
    }

    @Override
    public String toString() {
        return patientList.toString();
    }
}
