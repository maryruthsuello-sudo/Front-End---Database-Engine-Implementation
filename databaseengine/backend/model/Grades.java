package databaseengine.backend.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Grades {
    private int studentId;
    private BigDecimal grade;
    private String subjectCode;
    private Date dateSubmitted;

    public Grades(int studentId, BigDecimal grade, String subjectCode, Date dateSubmitted) {
        this.studentId = studentId;
        this.grade = grade;
        this.subjectCode = subjectCode;
        this.dateSubmitted = dateSubmitted;
    }

    public int getStudentId() {
        return studentId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }
}