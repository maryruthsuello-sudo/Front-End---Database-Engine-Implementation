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
        // FIX #5: Removed student_ID from the SQL — that column does NOT exist
        // in the course table (check your SQL schema). Including it caused every
        // INSERT to throw a SQLException and silently return false.
        String sql = "INSERT INTO course (prog, subject_code, units, descriptive_title, grade, time, term, date_submitted) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, newCourse.getProgram());
            pstmt.setString(2, newCourse.getSubjectCode());
            pstmt.setInt(3, newCourse.getUnits());
            pstmt.setString(4, newCourse.getDescriptiveTitle());
            pstmt.setBigDecimal(5, newCourse.getGrade());
            pstmt.setString(6, newCourse.getTime());
            pstmt.setString(7, newCourse.getTerm());
            pstmt.setDate(8, newCourse.getDateSubmitted());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // update course by subject_code
    public boolean updateCourse(Course course) {
        // FIX #5 (continued): Removed student_ID from UPDATE as well
        String sql = "UPDATE course SET prog = ?, units = ?, descriptive_title = ?, "
                   + "grade = ?, time = ?, term = ?, date_submitted = ? WHERE subject_code = ?";

        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, course.getProgram());
            pstmt.setInt(2, course.getUnits());
            pstmt.setString(3, course.getDescriptiveTitle());
            pstmt.setBigDecimal(4, course.getGrade());
            pstmt.setString(5, course.getTime());
            pstmt.setString(6, course.getTerm());
            pstmt.setDate(7, course.getDateSubmitted());
            pstmt.setString(8, course.getSubjectCode());

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
                return true;
            }

        } catch (SQLException e) {
            // FIX #6: was e.getStackTrace() which does nothing
            e.printStackTrace();
        }
        return false;
    }

    // get all courses
    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        // FIX #5 (continued): Removed student_ID from SELECT — column does not exist
        String sql = "SELECT prog, subject_code, units, descriptive_title, grade, time, term, date_submitted FROM course";

        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Course course = new Course(
                    rs.getString("prog"),
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