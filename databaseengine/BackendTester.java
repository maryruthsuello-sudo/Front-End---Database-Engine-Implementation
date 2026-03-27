package databaseengine;

import java.math.BigDecimal;

import databaseengine.backend.StartDatabase;
import databaseengine.backend.model.Section;
import databaseengine.backend.model.Completion;

public class BackendTester {
    public static void main(String[] args) {
        StartDatabase startDb = new StartDatabase();

        //startDb.getDb().getSection().createSection(new Section("4th Year", "IS302", 50));
        // startDb.getDb().getSection().deleteSection("4th Year", "IS302");
        // startDb.getDb().getSection().deleteSection("1st Year", "IS101");
        // startDb.getDb().getSection().updateSection(new Section("4rd Year", "IS302", 99));
        // printSection(startDb);
        //startDb.getDb().getCompletion().createCompletion(new Completion(2, new BigDecimal("1.50"), "IS101", 5));
        //startDb.getDb().getCompletion().deleteCompletion(1, "CS101");
        //startDb.getDb().getCompletion().updateCompletion(new Completion(20, new BigDecimal("1.25"), "IT101", 5));
        printCompletions(startDb);
    }

    public static void printCompletions(StartDatabase startDb) {
        for (Completion c : startDb.getDb().getCompletion().viewCompletion()) {
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
