package databaseengine.backend;

import java.sql.Connection;

import databaseengine.backend.service.DepartmentService;
import databaseengine.backend.service.StudentService;

public class Database {
    private StudentService student;
    private DepartmentService department;

    public Database(Connection connect){
        this.student = new StudentService(connect);
        this.department = new DepartmentService(connect);
    }

    public StudentService getStudent(){
        return student;
    }

    public DepartmentService getDepartment(){
        return department;
    }
}
