package databaseengine;

import databaseengine.backend.StartDatabase;

public class Main {
    public static void main(String[] args) {
        StartDatabase startDb = new StartDatabase();
        startDb.getDb().getStudent().viewStudents();
    }
}