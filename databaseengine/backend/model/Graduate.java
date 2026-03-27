package databaseengine.backend.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Graduate {
    private int studentId;
    private String prog;
    private BigDecimal unitGrade;
    private BigDecimal rating;
    private Date graduationDate;
    private BigDecimal finalGrade;
    private String major;

    // for display (JOIN with student table)
    private String studentName;

    // constructor for INSERT / UPDATE
    public Graduate(int studentId, String prog, BigDecimal unitGrade, BigDecimal rating,
                    Date graduationDate, BigDecimal finalGrade, String major) {
        this.studentId = studentId;
        this.prog = prog;
        this.unitGrade = unitGrade;
        this.rating = rating;
        this.graduationDate = graduationDate;
        this.finalGrade = finalGrade;
        this.major = major;
    }

    //  for DISPLAY 
    public static Graduate forDisplay(int studentId, String studentName, String prog,
                                      BigDecimal unitGrade, BigDecimal rating,
                                      Date graduationDate, BigDecimal finalGrade, String major) {

        Graduate g = new Graduate(studentId, prog, unitGrade, rating, graduationDate, finalGrade, major);
        g.setStudentName(studentName);
        return g;
    }

    // getters
    public int getStudentId() {
        return studentId;
    }

    public String getProg() {
        return prog;
    }

    public BigDecimal getUnitGrade() {
        return unitGrade;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public BigDecimal getFinalGrade() {
        return finalGrade;
    }

    public String getMajor() {
        return major;
    }

    public String getStudentName() {
        return studentName != null ? studentName : "";
    }

    // setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setProg(String prog) {
        this.prog = prog;
    }

    public void setUnitGrade(BigDecimal unitGrade) {
        this.unitGrade = unitGrade;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setFinalGrade(BigDecimal finalGrade) {
        this.finalGrade = finalGrade;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}