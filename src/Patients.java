import java.util.ArrayList;
import java.util.List;

public class Patients {
    private ArrayList<Patient> patientList;
    private int idNumber;

    public Patients() {
        this.patientList = new ArrayList<Patient>();
        idNumber = 0;
    }

    public void addPatient(Patient patient) {
        // Add patient in alphabetical order of last name
        int lowerBound = 0;
        int upperBound = patientList.size();
        int i = patientList.size() / 2;
        int compare;
        while ((upperBound - lowerBound) > 0) {
            compare = patient.compareToIgnoreCase(patientList.get(i));
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
        idNumber++;
    }

    public Patient findById(int id) {
        for (Patient patient :
                patientList) {
            if (patient.getPatientId() == id) {
                return patient;
            }
        }

        // No patient is found; return null
        return null;
    }

    public List<Patient> findByLastName(String lastName) {
        // Simple linear search approach, O(n)
//        List<Patient> matchingLastName = new ArrayList<Patient>();
//
//        for (Patient patient :
//                patientList) {
//            if (patient.getLastName().equals(lastName)) {
//                matchingLastName.add(patient);
//            }
//        }
//        return matchingLastName;

        // Two binary searches approach, O(log n)
        int lowerBound = 0;
        int upperBound = patientList.size();
        int compare;

        // First binary search finds the index of first occurrence of the last name
        int firstOccur = (upperBound + lowerBound) / 2;
        while ((upperBound - lowerBound) > 0) {
            compare = lastName.compareToIgnoreCase(patientList.get(firstOccur).getLastName());
            if (compare > 0) {
                // go higher
                lowerBound = firstOccur + 1;
                firstOccur = (lowerBound + upperBound) / 2;
            } else if (compare < 0) {
                // go lower
                upperBound = firstOccur;
                firstOccur = (lowerBound + upperBound) / 2;
            } else {
                // found, check if it's first occurrence
                if (firstOccur == 0) {
                    // check if first element before performing firstOccur - 1 which would cause an error
                    break;
                } else if (patientList.get(firstOccur - 1).getLastName().equalsIgnoreCase(lastName)) {
                    // not first occurrence, keep going left
                    upperBound = firstOccur;
                    firstOccur = (lowerBound + upperBound) / 2;
                } else {
                    break;
                }
            }
        }

        // Second binary search finds the index of the last occurrence
        lowerBound = firstOccur;
        upperBound = patientList.size();
        int lastOccur = (upperBound + lowerBound) / 2;
        while ((upperBound - lowerBound) > 0) {
            compare = lastName.compareToIgnoreCase(patientList.get(lastOccur).getLastName());
            if (compare > 0) {
                // go higher
                lowerBound = lastOccur + 1;
                lastOccur = (lowerBound + upperBound) / 2;
            } else if (compare < 0) {
                // go lower
                upperBound = lastOccur;
                lastOccur = (lowerBound + upperBound) / 2;
            } else {
                // check if it's last occurrence
                if (lastOccur == patientList.size() - 1) {
                    // last element
                    break;
                } else if (patientList.get(lastOccur + 1).getLastName().equalsIgnoreCase(lastName)) {
                    lowerBound = lastOccur + 1;
                    lastOccur = (lowerBound + upperBound) / 2;
                } else {
                    break;
                }
            }
        }
        return patientList.subList(firstOccur, lastOccur + 1); // range is exclusive on the second index
    }

    public ArrayList<Patient> findByFirstName(String firstName) {
        ArrayList<Patient> matchingFirstName = new ArrayList<Patient>();
        for (Patient patient :
                patientList) {
            if (patient.getFirstName().equalsIgnoreCase(firstName)) {
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
        // no patient found; return null
        return null;
    }

    public int getIdNumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return patientList.toString();
    }
}
