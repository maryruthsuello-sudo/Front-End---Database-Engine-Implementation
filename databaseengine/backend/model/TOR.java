package databaseengine.backend.model;

import java.sql.Date;

public class TOR {
    private int studentId;
    private Date dateCompleted;

    public TOR(int studentId, Date dateCompleted) {
        this.studentId = studentId;
        this.dateCompleted = dateCompleted;
    }

    public int getStudentId() {
        return studentId;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}