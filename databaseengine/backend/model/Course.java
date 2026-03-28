package databaseengine.backend.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Course {
    private String program;
    private int id;
    private String subjectCode;
    private int units;
    private String descriptiveTitle;
    private BigDecimal grade;
    private String time;
    private String term;
    private Date dateSubmitted;

    public Course(String program, int id, String subjectCode, int units,
                  String descriptiveTitle, BigDecimal grade, String time,
                  String term, Date dateSubmitted) {
        this.program = program;
        this.id = id;
        this.subjectCode = subjectCode;
        this.units = units;
        this.descriptiveTitle = descriptiveTitle;
        this.grade = grade;
        this.time = time;
        this.term = term;
        this.dateSubmitted = dateSubmitted;
    }

    public String getProgram() {
        return program;
    }

    public int getId() {
        return id;
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

    public BigDecimal getGrade() {
        return grade;
    }

    public String getTime() {
        return time;
    }

    public String getTerm() {
        return term;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }
}
