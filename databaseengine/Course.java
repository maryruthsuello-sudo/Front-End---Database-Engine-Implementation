package databaseengine;

public class Course {
    private String program;
    private String subjectCode;
    private int units;
    private String descriptiveTitle;
    private float grade;
    private String time;
    private String term;
    private String dateSubmitted;

    public Course(String program, String subjectCode, int units, String descriptiveTitle,
                  float grade, String time, String term, String dateSubmitted) {
        this.program = program;
        this.subjectCode = subjectCode;
        this.units = units;
        this.descriptiveTitle = descriptiveTitle;
        this.grade = grade;
        this.time = time;
        this.term = term;
        this.dateSubmitted = dateSubmitted;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String display() {
        return program + " | " + subjectCode + " | Units: " + units + " | " + descriptiveTitle
                + " | Grade: " + grade + " | Time: " + time + " | Term: " + term
                + " | Date Submitted: " + dateSubmitted;
    }
}