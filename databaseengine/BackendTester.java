package databaseengine;

import java.math.BigDecimal;

import databaseengine.backend.StartDatabase;
import databaseengine.backend.model.Section;
import databaseengine.backend.model.Grades;

public class BackendTester {
    public static void main(String[] args) {
        StartDatabase startDb = new StartDatabase();
        startDb.getDb().getGrade().updateGrade(new Grades(20, new BigDecimal(1.00), "IT101", 5));
        System.out.println("updated = " + updated);
        startDb.getDb().getGrade().deleteGrade(20, "IT101");
       
        printCompletions(startDb);
    }

    public static void printCompletions(StartDatabase startDb) {
        for (Grades c : startDb.getDb().getGrade().viewGrade()) {
            System.out.println("Student ID: " + c.getStudentId());
            System.out.println("Subject: " + c.getSubjectCode());
            System.out.println("Grade: " + c.getGrade());
            System.out.println("Units: " + c.getUnits());
            System.out.println();
        }
    }

     public static void printSection(StartDatabase startDb) {
        for (Section c : startDb.getDb().getSection().viewSection()) {
            System.out.println("CourseYr: " + c.getCourseYear());
            System.out.println("SubjectCode: " + c.getSubjectCode());
            System.out.println("No of Studetnt: " + c.getNoOfStudents());
            System.out.println();
        }
    }
}
