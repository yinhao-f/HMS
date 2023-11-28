import java.text.DateFormat;

public class Patient {
    private String firstName;
    private String lastName;
    private long patientId;
    private DateFormat patientBirthDate;
    private Gender gender;
    private String notes;

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

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public DateFormat getPatientBirthDate() {
        return patientBirthDate;
    }

    public void setPatientBirthDate(DateFormat patientBirthDate) {
        this.patientBirthDate = patientBirthDate;
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

    public Patient() {
    }
}
