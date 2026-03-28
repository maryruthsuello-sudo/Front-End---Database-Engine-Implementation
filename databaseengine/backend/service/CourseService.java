package databaseengine.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import databaseengine.backend.model.Course;

public class CourseService {
    private final Connection connect;

    public CourseService(Connection connect) {
        this.connect = connect;
    }

    // create course
    public boolean createCourse(Course newCourse) {
        String sql = "INSERT INTO course (prog, student_ID, subject_code, units, descriptive_title, grade, time, term, date_submitted) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, newCourse.getProgram());
            pstmt.setInt(2, newCourse.getId());
            pstmt.setString(3, newCourse.getSubjectCode());
            pstmt.setInt(4, newCourse.getUnits());
            pstmt.setString(5, newCourse.getDescriptiveTitle());
            pstmt.setBigDecimal(6, newCourse.getGrade());
            pstmt.setString(7, newCourse.getTime());
            pstmt.setString(8, newCourse.getTerm());
            pstmt.setDate(9, newCourse.getDateSubmitted());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // update course by subject_code
    public boolean updateCourse(Course course) {
        String sql = "UPDATE course SET prog = ?, student_ID = ?, units = ?, descriptive_title = ?, "
                   + "grade = ?, time = ?, term = ?, date_submitted = ? WHERE subject_code = ?";

        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, course.getProgram());
            pstmt.setInt(2, course.getId());
            pstmt.setInt(3, course.getUnits());
            pstmt.setString(4, course.getDescriptiveTitle());
            pstmt.setBigDecimal(5, course.getGrade());
            pstmt.setString(6, course.getTime());
            pstmt.setString(7, course.getTerm());
            pstmt.setDate(8, course.getDateSubmitted());
            pstmt.setString(9, course.getSubjectCode());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // delete course by subject_code
    public boolean deleteCourse(String subjectCode) {
        String sql = "DELETE FROM course WHERE subject_code = ?";

        if (!isSectionExist(subjectCode)){
            try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
                pstmt.setString(1, subjectCode);
                return pstmt.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        return false;
    }

    private boolean isSectionExist(String subject_code){
        String sql = "SELECT * FROM sectn WHERE subject_code = ?";
        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            stmt.setString(1, subject_code);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return true; // safe to delete
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        // cannot delete
        return false;
    }

    // get all courses
    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        String sql = "SELECT prog, student_ID, subject_code, units, descriptive_title, grade, time, term, date_submitted FROM course";

        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Course course = new Course(
                    rs.getString("prog"),
                    rs.getInt("student_ID"),
                    rs.getString("subject_code"),
                    rs.getInt("units"),
                    rs.getString("descriptive_title"),
                    rs.getBigDecimal("grade"),
                    rs.getString("time"),
                    rs.getString("term"),
                    rs.getDate("date_submitted")
                );
                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }
}