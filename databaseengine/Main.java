package databaseengine;

import java.sql.Date;

import databaseengine.backend.StartDatabase;
import databaseengine.backend.model.Student;

public class Main {
    public static void main(String[] args) {
        StartDatabase startDb = new StartDatabase();
        startDb.getDb().getStudent().deleteStudent(21);
    }
}