package databaseengine.backend;

import java.sql.Connection;

import databaseengine.backend.service.GradesService;
import databaseengine.backend.service.GraduateService;
import databaseengine.backend.service.SectionService;
import databaseengine.backend.service.DepartmentService;
import databaseengine.backend.service.StudentService;
import databaseengine.backend.service.TORService;

public class Database {
    private StudentService student;
    private DepartmentService department;
    private SectionService section;
    private GraduateService graduate;
    private TORService tor;
    private GradesService grade;

    public Database(Connection connect){
        this.student = new StudentService(connect);
        this.section = new SectionService(connect);
        this.graduate = new GraduateService(connect);
        this.tor = new TORService(connect);
        this.department = new DepartmentService(connect);
    }

    public StudentService getStudent(){
        return student;
    }

    public SectionService getSection(){
        return section;
    }

    public GraduateService getGraduate(){
        return graduate;
    }

    public TORService getTOR(){
        return tor;
    }

    public GradesService getGrade(){
        return grade;
    }

    public DepartmentService getDepartment(){
        return department;
    }
}
