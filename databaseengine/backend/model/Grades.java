package databaseengine.backend.model;

import java.math.BigDecimal;

public class Grades {
    private int studentId;
    private BigDecimal grade;
    private String subjectCode;
    private int units;

    public Grades(int studentId, BigDecimal grade, String subjectCode, int units) {
        this.studentId = studentId;
        this.grade = grade;
        this.subjectCode = subjectCode;
        this.units = units;
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

    public int getUnits() {
        return units;
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

    public void setUnits(int units) {
        this.units = units;
    }
}