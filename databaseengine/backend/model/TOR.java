package databaseengine.backend.model;

import java.sql.Date;

public class TOR {
    private int studentId;
    private Date dateCompleted;

    // for display (JOIN with student table)
    private String studentName;

    public TOR(int studentId, Date dateCompleted) {
        this.studentId = studentId;
        this.dateCompleted = dateCompleted;
    }

    // for Display
    public static TOR forDisplay(int studentId, String studentName, Date dateCompleted){
        TOR t = new TOR(studentId, dateCompleted);
        t.setStudentName(studentName);
        return t;
    }
    

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName(){
        return studentName;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}