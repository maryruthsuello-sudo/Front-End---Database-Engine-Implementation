package databaseengine.backend.model;

public class Section {
    private int id;
    private String instructor;
    private String courseYear;
    private String subjectCode;
    private String time;
    private String term;
    private int noOfStudents;

    public Section(int id, String instructor, String courseYear, String subjectCode, String time, String term, int noOfStudents) {
        this.id = id;
        this.instructor = instructor;
        this.courseYear = courseYear;
        this.subjectCode = subjectCode;
        this.time = time;
        this.term = term;
        this.noOfStudents = noOfStudents;
    }

    public int getId() {
        return id;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getTime() {
        return time;
    }

    public String getTerm() {
        return term;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
}
