public class Patient {
    private String firstName;
    private String lastName;
    private int patientId;
    private int age;
    private Gender gender;
    private String notes; // Can be used to store additional notes, such as allergies of the patient

    /**
     * Constructor for the Patient class, requires the following parameters:
     * @param firstName first name of the patient
     * @param lastName last name of the patient
     * @param patientId ID number as it will be managed in the Patients class
     * @param age age of the patient
     * @param gender gender of the patient
     * @param notes optional comments
     */
    public Patient(String firstName, String lastName, int patientId, int age, Gender gender, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.notes = notes;
    }

    /**
     * Overrides the toString method to produce a String representation of a Patient object
     * @return String representation, eg. {First name: John, Last name: Doe, Patient ID: 0123456789, Age: 35, Gender: MALE}
     */
    @Override
    public String toString() {
        return "{First name: " + firstName +
                ", Last name: " + lastName +
                ", Patient ID: " + String.format("%010d", patientId) +
                ", Age: " + age +
                ", Gender: " + gender +
                "}";
    }

    /**
     * Compares the last names of two patient objects alphabetically, ignoring case
     * @param patient the patient to be compared with
     * @return negative if argument is after the object of the method call in alphabetical order, positive if before, and 0 if identical
     */
    public int compareToIgnoreCase(Patient patient) {
        return this.lastName.compareToIgnoreCase(patient.lastName);
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Concatenates the first name and last name separated by a space
     * @return a concatenated String
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
