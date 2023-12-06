import java.util.ArrayList;
import java.util.List;

public class Patients {
    // Stores the list of Patient objects
    private ArrayList<Patient> patientList;

    // Keeps track of ID numbers issued so no duplicate ID numbers are created
    private int idNumber;

    /**
     * Constructor for the Patients class, initiates patientList and sets the idNumber tracker to 0
     */
    public Patients() {
        this.patientList = new ArrayList<Patient>();
        idNumber = 0;
    }

    /**
     * Adds a new patient to the list in the correct alphabetical order of last names, using binary search
     * @param patient patient to be added
     */
    public void addPatient(Patient patient) {
        // Sets lower and upper bounds for the binary search
        int lowerBound = 0;
        int upperBound = patientList.size();
        int i = patientList.size() / 2; // i is the middle value to be checked within the bounds
        int compare; // stores the compared result to reduce method calls

        // Use a while loop to implement the binary search, exits when the lower and upper bounds meet, or the same last name is found
        while ((upperBound - lowerBound) > 0) { // loop when there are more than one element in the current bounds
            // Compares the new patient with an existing patient at index i by last name
            compare = patient.compareToIgnoreCase(patientList.get(i));
            if (compare > 0) {
                // New patient has a higher alphabetical order, sets the bounds to the second half
                lowerBound = i + 1; // set lower bound one higher than i so i won't be repeatedly checked when there are only 2 elements left
                i = (upperBound + lowerBound) / 2; // new i is the average of lower and upper bounds
            } else if (compare < 0) {
                // New patient has a lower alphabetical order, sets the bounds to the first half
                upperBound = i; // i will never be equal to upperbound because of integer division, so no need to plus one
                i = (upperBound + lowerBound) / 2; // eg. bounds (7, 8) results in i = 7
            } else {
                // Last names are equal, exits the loop and inserts at current position
                break;
            }
        }

        // Adds the new patient at the position i
        patientList.add(i, patient);

        // Increments the ID tracker
        idNumber++;
    }

    /**
     * Finds the Patient by ID number
     * @param id the ID number
     * @return the corresponding patient
     */
    public Patient findById(int id) {
        // Use a for-each loop to find the Patient with matching ID
        for (Patient patient :
                patientList) {
            if (patient.getPatientId() == id) {
                // Found, returns the result
                return patient;
            }
        }

        // No patient is found; returns null
        return null;
    }

    /**
     * Finds the list of Patient objects by last name
     * @param lastName last name to look for
     * @return a List of Patient because subList returns a List object
     */
    public List<Patient> findByLastName(String lastName) {
        // Simple linear search approach, O(n), slower but simple and concise
//        List<Patient> matchingLastName = new ArrayList<Patient>();
//
//        for (Patient patient :
//                patientList) {
//            if (patient.getLastName().equals(lastName)) {
//                matchingLastName.add(patient);
//            }
//        }
//        return matchingLastName;

        // Two binary searches approach, O(log n), faster in larger cases, but code is super long
        // Similar approach as in addPatient()
        int lowerBound = 0;
        int upperBound = patientList.size();
        int compare;

        // First binary search finds the index of first occurrence of the last name
        // Similar approach as in addPatient()
        int firstOccur = (upperBound + lowerBound) / 2;
        while ((upperBound - lowerBound) > 0) {
            compare = lastName.compareToIgnoreCase(patientList.get(firstOccur).getLastName());
            if (compare > 0) {
                // First occurrence is in the second half
                lowerBound = firstOccur + 1;
                firstOccur = (lowerBound + upperBound) / 2;
            } else if (compare < 0) {
                // First occurrence is in the first half
                upperBound = firstOccur;
                firstOccur = (lowerBound + upperBound) / 2;
            } else {
                // Found, check if it's first occurrence
                if (firstOccur == 0) {
                    // Check if it's first element before performing get(firstOccur - 1) which would cause an index out of range error
                    // If so, the first occurrence is found because there is no element before 0
                    break;
                } else if (patientList.get(firstOccur - 1).getLastName().equalsIgnoreCase(lastName)) {
                    // Not first occurrence, keep searching the first half
                    upperBound = firstOccur;
                    firstOccur = (lowerBound + upperBound) / 2;
                } else {
                    // Element before doesn't match the last name; first occurrence found
                    break;
                }
            }
        }

        // Second binary search finds the index of the last occurrence
        // Similar approach as in addPatient()
        lowerBound = firstOccur; // Sets the lower bound to first occurrence for optimization
        upperBound = patientList.size();
        int lastOccur = (upperBound + lowerBound) / 2;
        while ((upperBound - lowerBound) > 0) {
            compare = lastName.compareToIgnoreCase(patientList.get(lastOccur).getLastName());
            if (compare > 0) {
                // Last occurrence is in the second half
                lowerBound = lastOccur + 1;
                lastOccur = (lowerBound + upperBound) / 2;
            } else if (compare < 0) {
                // Last occurrence is in the first half
                upperBound = lastOccur;
                lastOccur = (lowerBound + upperBound) / 2;
            } else {
                // Similarly, check if it's last occurrence, preventing index out of range
                if (lastOccur == patientList.size() - 1) {
                    // It is the last element; last occurrence found
                    break;
                } else if (patientList.get(lastOccur + 1).getLastName().equalsIgnoreCase(lastName)) {
                    // Not last, keep searching the second half
                    lowerBound = lastOccur + 1;
                    lastOccur = (lowerBound + upperBound) / 2;
                } else {
                    // No later occurrence; last occurrence found
                    break;
                }
            }
        }

        // Returns the sublist with the indexes found
        return patientList.subList(firstOccur, lastOccur + 1); // range is exclusive on the second index, so plus one
    }

    /**
     * Finds the Patient objects by first name
     * @param firstName first name to look for
     * @return ArrayList of Patient objects matching the first name
     */
    public ArrayList<Patient> findByFirstName(String firstName) {
        // As there might be multiple objects with the same first name, store results in an ArrayList
        ArrayList<Patient> matchingFirstName = new ArrayList<Patient>();

        // Linear search similar to findById()
        for (Patient patient :
                patientList) {
            if (patient.getFirstName().equalsIgnoreCase(firstName)) { // ignores case of names, in case user entered lower case
                // Found, adds to the result list
                matchingFirstName.add(patient);
            }
        }

        return matchingFirstName;
    }

    /**
     * Finds the Patient objects by age range
     * @param minAge minimum age to look for
     * @param maxAge maximum age to look for
     * @return an ArrayList of Patient objects within the age range
     */
    public ArrayList<Patient> findByAgeRange (int minAge, int maxAge) {
        // Similar to findByFirstName(), won't explain again
        ArrayList<Patient> matchingAgeRange = new ArrayList<Patient>();
        for (Patient patient :
                patientList) {
            if ((patient.getAge() >= minAge) && (patient.getAge() <= maxAge)) {
                matchingAgeRange.add(patient);
            }
        }
        return matchingAgeRange;
    }

    /**
     * Removes a Patient by ID
     * @param patientId the ID to look for
     * @return the Patient that was removed, null if not found
     */
    public Patient removePatient(int patientId) {
        // Use a for loop because remove() requires an index
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getPatientId() == patientId) {
                // Stores the removed Patient to be displayed to the user
                Patient removed = patientList.get(i);
                patientList.remove(i);
                return removed;
            }
        }
        // no patient found; return null
        return null;
    }

    /**
     * Retrieves the ID number tracker
     * @return current ID tracker
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Overrides the toString method
     * @return a list of Patient's String representation, separated by commas and closed by [] brackets
     */
    @Override
    public String toString() {
        return patientList.toString();
    }
}
