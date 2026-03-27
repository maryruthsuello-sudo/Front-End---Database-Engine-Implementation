package databaseengine.backend;

import java.sql.Connection;
import databaseengine.backend.service.StudentService;

public class Database {
    private StudentService student;

    public Database(Connection connect){
        this.student = new StudentService(connect);
    }

    public StudentService getStudent(){
        return student;
    }
}
