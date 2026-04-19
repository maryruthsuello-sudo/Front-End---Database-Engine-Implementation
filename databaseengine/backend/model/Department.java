package databaseengine.backend.model;

public class Department {
    private String program;
    private String college;
    private String dean;
    private String deptHead;

    public Department(String college, String program, String dean, String deptHead){
        this.college = college;
        this.program = program;
        this.dean = dean;
        this.deptHead = deptHead;
    }

    public String getProgram() {
        return program;
    }

    public String getDean() {
        return dean;
    }

    public String getDeptHead() {
        return deptHead;
    }

    public String getCollege() {
        return college;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public void setDeptHead(String deptHead) {
        this.deptHead = deptHead;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}