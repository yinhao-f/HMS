public class Patient {
    private String firstName;
    private String lastName;
    private int patientId;

    // TODO: store the patient's birth date a Date type so the age will be consistent with time
    // private Date patientBirthDate;
    private int age;
    private Gender gender;
    private String notes;

    // TODO: age to be removed
    public Patient(String firstName, String lastName, int patientId, int age, Gender gender, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.notes = notes;
    }

    public Patient() {}

    @Override
    public String toString() {
        return "{Name: " + firstName + " " +
                lastName +
                ", Patient ID: " + String.format("%010d", patientId) +
                ", Age: " + age +
                ", Gender: " + gender +
                "}";
    }

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

//    public void setPatientBirthDate(Date patientBirthDate) {
//        this.patientBirthDate = patientBirthDate;
//    }

    // TODO: calculate age based on the birth date and current date
    public int getAge() {
        return age;
    }

    // TODO: to be removed once the birth date is implemented
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

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
