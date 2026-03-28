package databaseengine.backend.model;

public class Department {
    private String program;
    private String college;
    private String instructor;
    private String dean;
    private String deptHead;
    private String course;

    public Department (String collge, String program, String instructor, String dean, String deptHead, String course){
        this.college = collge;
        this.program = program;
        this.instructor = instructor;
        this.course = course;
        this.dean = dean;
        this.deptHead = deptHead;
    }

    public String getProgram() {
        return program;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDean() {
        return dean;
    }

    public String getDeptHead() {
        return deptHead;
    }

    public String getCourse() {
        return course;
    }

    public String getCollege(){
        return college;
    }
}
