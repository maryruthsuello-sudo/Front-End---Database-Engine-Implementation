package databaseengine.backend;

import java.sql.Connection;

import databaseengine.backend.service.GraduateService;
import databaseengine.backend.service.SectionService;
import databaseengine.backend.service.StudentService;
import databaseengine.backend.service.TORService;

public class Database {
    private StudentService student;
    private SectionService section;
    private GraduateService graduate;
    private TORService tor;

    public Database(Connection connect){
        this.student = new StudentService(connect);
        this.section = new SectionService(connect);
        this.graduate = new GraduateService(connect);
        this.tor = new TORService(connect);
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

}
