package databaseengine.backend.model;

public class Course {
    private String program;
    private String subjectCode;
    private int units;
    private String descriptiveTitle;

    public Course(String program, String subjectCode, int units, String descriptiveTitle) {
        this.program = program;
        this.subjectCode = subjectCode;
        this.units = units;
        this.descriptiveTitle = descriptiveTitle;
    }

    public String getProgram() {
        return program;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public int getUnits() {
        return units;
    }

    public String getDescriptiveTitle() {
        return descriptiveTitle;
    }

    public void setProgram(String program) {
        this.program = program;
    }


    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setDescriptiveTitle(String descriptiveTitle) {
        this.descriptiveTitle = descriptiveTitle;
    }

}
