package databaseengine.backend;

import java.sql.Connection;

import databaseengine.backend.service.GraduateService;
import databaseengine.backend.service.SectionService;
import databaseengine.backend.service.CourseService;
import databaseengine.backend.service.DepartmentService;
import databaseengine.backend.service.EnrollmentService;
import databaseengine.backend.service.StudentService;
import databaseengine.backend.service.TORService;

public class Database {
    private StudentService student;
    private DepartmentService department;
    private SectionService section;
    private GraduateService graduate;
    private TORService tor;
    private EnrollmentService enrollment;
    private CourseService course;

    public Database(Connection connect){
        this.student = new StudentService(connect);
        this.section = new SectionService(connect);
        this.graduate = new GraduateService(connect);
        this.tor = new TORService(connect);
        this.department = new DepartmentService(connect);
        this.enrollment = new EnrollmentService(connect);
        this.course = new CourseService(connect);
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

    public DepartmentService getDepartment(){
        return department;
    }

    public EnrollmentService getEnrollment(){
        return enrollment;
    }

    public CourseService getCourse(){
        return course;
    }
}
