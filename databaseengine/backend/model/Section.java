package databaseengine.backend.model;

public class Section {
    private String courseYear;
    private String subjectCode;
    private int noOfStudents;

    public Section(String courseYear, String subjectCode, int noOfStudents) {
        this.courseYear = courseYear;
        this.subjectCode = subjectCode;
        this.noOfStudents = noOfStudents;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
}
