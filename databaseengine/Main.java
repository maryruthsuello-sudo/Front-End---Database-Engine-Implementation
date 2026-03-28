package databaseengine;

import databaseengine.backend.StartDatabase;
import databaseengine.backend.model.Student;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        StartDatabase startDb = new StartDatabase();
        System.out.println(startDb.getDb().getStudent().createStudent(new Student("May", Date.valueOf("2000-11-11"), "Manila", "Bahay", "School", "Regular")));
        
    }
}