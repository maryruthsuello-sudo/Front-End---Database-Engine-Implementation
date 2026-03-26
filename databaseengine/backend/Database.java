package databaseengine.backend;

import java.sql.Connection;
import databaseengine.backend.model.Student;

public class Database {
    private Student student;

    public Database(Connection connect){
        this.student = new Student(connect);
    }

    public Student getStudent(){
        return student;
    }
}
