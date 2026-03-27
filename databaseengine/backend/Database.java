package databaseengine.backend;

import java.sql.Connection;

import databaseengine.backend.service.CompletionService;
import databaseengine.backend.service.SectionService;
import databaseengine.backend.service.StudentService;

public class Database {
    private StudentService student;
    private SectionService section;
    private CompletionService completion;

    public Database(Connection connect){
        this.student = new StudentService(connect);
        this.section = new SectionService(connect);
        this.completion = new CompletionService(connect);
    }

    public StudentService getStudent(){
        return student;
    }

    public SectionService getSection(){
        return section;
    }

    public CompletionService getCompletion(){
        return completion;
    }
}
