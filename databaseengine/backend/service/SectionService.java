package databaseengine.backend.service;

import databaseengine.backend.model.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SectionService {
    private final Connection connect;

    public SectionService(Connection connect){
        this.connect = connect;
    }

    public void viewSection(){ 
        try (Statement statement = connect.createStatement()) { 
            ResultSet section = statement.executeQuery("SELECT * FROM sectn;"); 
            while (section.next()) { 
                String courseYr = section.getString("course_year"); 
                int noOfStudents = section.getInt("no_of_students"); 
                String subjectCode = section.getString("subject_code"); 
                Section s = new Section(courseYr, subjectCode, noOfStudents); 
                System.out.println("COURSE YEAR = " + s.getCourseYear()); 
                System.out.println("NO OF STUDENTS = " + s.getNoOfStudents()); 
                System.out.println("SUBJECT CODE = " + s.getSubjectCode()); 
                System.out.println(); 
            } 
            section.close(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    }

    public void createSection(Section newSection) {
        String sql = "INSERT INTO sectn (course_year, no_of_students, subject_code) VALUES (?, ?, ?)";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, newSection.getCourseYear());
            pStatement.setInt(2, newSection.getNoOfStudents());
            pStatement.setString(3, newSection.getSubjectCode());

            int affectedRows = pStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating section failed, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSection(Section updateSection) {
        String sql = "UPDATE sectn SET no_of_students = ? WHERE course_year = ? AND subject_code = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setInt(1, updateSection.getNoOfStudents());
            pStatement.setString(2, updateSection.getCourseYear());
            pStatement.setString(3, updateSection.getSubjectCode());

            int affectedRows = pStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating section failed, no rows affected.");
            }

            System.out.println("Section updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSection(Section deleteSection){
        String sql = "DELETE FROM sectn WHERE course_year = ? AND subject_code = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, deleteSection.getCourseYear());
            pStatement.setString(2, deleteSection.getSubjectCode());

            int affectedRows = pStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Deleting section failed, no rows affected.");
            }

            System.out.println("Section deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean findSection(String courseYear, String subjectCode) {
        String sql = "SELECT 1 FROM sectn WHERE course_year = ? AND subject_code = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, courseYear);
            ps.setString(2, subjectCode);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}