package databaseengine.backend.model;

import java.sql.Date;

public class Enrollment {
    private int id;
    private String program;
    private String schoolYr;
    private Date dateAdmitted;

    public Enrollment(int id, String program, String schoolYr, Date dateAdmitted){
        this.id = id;
        this.program = program;
        this.schoolYr = schoolYr;
        this.dateAdmitted = dateAdmitted;
    }

    public int getId() {
        return id;
    }

    public String getProgram() {
        return program;
    }

    public String getSchoolYr() {
        return schoolYr;
    }

    public Date getDateAdmitted() {
        return dateAdmitted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setSchoolYr(String schoolYr) {
        this.schoolYr = schoolYr;
    }

    public void setDateAdmitted(Date dateAdmitted) {
        this.dateAdmitted = dateAdmitted;
    }
}
