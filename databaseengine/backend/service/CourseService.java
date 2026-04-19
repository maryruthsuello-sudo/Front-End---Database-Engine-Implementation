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
        String sql = "INSERT INTO course (subject_code, prog, units, descriptive_title) "
                   + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, newCourse.getSubjectCode());
            pstmt.setString(2, newCourse.getProgram());
            pstmt.setInt(3, newCourse.getUnits());
            pstmt.setString(4, newCourse.getDescriptiveTitle());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // update course by subject_code
    public boolean updateCourse(Course updatedCourse, String oldSubjectCode) {
        String sql = "UPDATE course SET prog = ?, units = ?, descriptive_title = ? WHERE subject_code = ?";

        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, updatedCourse.getSubjectCode());
            pstmt.setString(2, updatedCourse.getProgram());
            pstmt.setInt(3, updatedCourse.getUnits());
            pstmt.setString(4, updatedCourse.getDescriptiveTitle());
            pstmt.setString(5, oldSubjectCode);

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
        String sql = "SELECT prog, subject_code, units, descriptive_title FROM course";

        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Course course = new Course(
                    rs.getString("prog"),
                    rs.getString("subject_code"),
                    rs.getInt("units"),
                    rs.getString("descriptive_title")
                );
                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }
}