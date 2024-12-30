public class Student {
    private String SID;
    private String firstName;
    private String lastName;

    public Student(String StuID, String firstname, String lastname) {
        SID = StuID;
        firstName = firstname;
        lastName = lastname;
    }

    public String getSID() {
        return SID;
    }

    public  String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return SID + " " + firstName + " " + lastName;
    }
}