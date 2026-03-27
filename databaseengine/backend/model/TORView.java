package databaseengine.backend.model;

import java.sql.Date;

public class TORView {
    private int studentId;
    private String studentName;
    private Date dateCompleted;

    public TORView(int studentId, String studentName, Date dateCompleted) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateCompleted = dateCompleted;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }
}