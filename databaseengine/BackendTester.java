package databaseengine;

import databaseengine.backend.StartDatabase;
import databaseengine.backend.model.Section;

public class BackendTester {
    public static void main(String[] args) {
        StartDatabase startDb = new StartDatabase();
        startDb.getDb().getSection().createSection(new Section("4th Year", "IS302", 50));
        startDb.getDb().getSection().viewSection();
        
    }
}