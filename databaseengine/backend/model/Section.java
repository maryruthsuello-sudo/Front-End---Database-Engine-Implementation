package databaseengine.backend.model;

public class Section {
    private int sectionId;
    private int courseId;
    private String instructor;
    private String schoolYear;
    private String term;
    private String schedule;

    public Section(int courseId, String instructor, String schoolYear, String term, String schedule) {
        this.courseId = courseId;
        this.instructor = instructor;
        this.schoolYear = schoolYear;
        this.term = term;
        this.schedule = schedule;
    }

    public Section(int sectionId, int courseId, String instructor, String schoolYear, String term, String schedule) {
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.instructor = instructor;
        this.schoolYear = schoolYear;
        this.term = term;
        this.schedule = schedule;
    }

    public int getSectionId() { return sectionId; }
    public int getCourseId() { return courseId; }
    public String getInstructor() { return instructor; }
    public String getSchoolYear() { return schoolYear; }
    public String getTerm() { return term; }
    public String getSchedule() { return schedule; }
}