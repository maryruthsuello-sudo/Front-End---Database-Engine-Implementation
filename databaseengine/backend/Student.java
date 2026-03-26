package databaseengine.backend;

public class Student {
    private String studentName;
    private int studentID;
    private String studentBirthday;
    private String studentBirthplace;
    private String studentAddress;
    private String studentHighschool;
    private String studentCategory;

    public Student(String studentName, int studentID, String studentBirthday,
                   String studentBirthplace, String studentAddress,
                   String studentHighschool, String studentCategory) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentBirthday = studentBirthday;
        this.studentBirthplace = studentBirthplace;
        this.studentAddress = studentAddress;
        this.studentHighschool = studentHighschool;
        this.studentCategory = studentCategory;
    }

    // Getters
    public int getStudentID() { return studentID; }
    public String getStudentName() { return studentName; }
    public String getStudentBirthday() { return studentBirthday; }
    public String getStudentBirthplace() { return studentBirthplace; }
    public String getStudentAddress() { return studentAddress; }
    public String getStudentHighschool() { return studentHighschool; }
    public String getStudentCategory() { return studentCategory; }

    // Setters (needed for Update)
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setStudentBirthday(String studentBirthday) { this.studentBirthday = studentBirthday; }
    public void setStudentBirthplace(String studentBirthplace) { this.studentBirthplace = studentBirthplace; }
    public void setStudentAddress(String studentAddress) { this.studentAddress = studentAddress; }
    public void setStudentHighschool(String studentHighschool) { this.studentHighschool = studentHighschool; }
    public void setStudentCategory(String studentCategory) { this.studentCategory = studentCategory; }

    public String display() {
        return studentName + " | ID: " + studentID + " | Birthday: " + studentBirthday
                + " | Birthplace: " + studentBirthplace + " | Address: " + studentAddress
                + " | Highschool: " + studentHighschool + " | Category: " + studentCategory;
    }
}