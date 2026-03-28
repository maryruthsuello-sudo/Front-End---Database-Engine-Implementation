package databaseengine.backend.service;

import databaseengine.backend.model.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectionService {
    private final Connection connect;

    public SectionService(Connection connect){
        this.connect = connect;
    }

    // call to display section records
    public ArrayList<Section> viewSection(){ 
        ArrayList<Section> sections = new ArrayList<>();
        String sql = "SELECT course_year, subject_code, no_of_students FROM sectn";
        
        try (
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery()
        ) { 
            while (rs.next()) { 
                Section section = new Section(
                    rs.getString("course_year"),
                    rs.getString("subject_code"),
                    rs.getInt("no_of_students")
                ); 

                sections.add(section);
            } 

        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        return sections;
    }

    // call to create section
    public boolean createSection(Section newSection) {
        if (findSection(newSection.getCourseYear(), newSection.getSubjectCode())) {
            System.out.println("Section already exists.");
            return false;
        }

        String sql = "INSERT INTO sectn (course_year, no_of_students, subject_code) VALUES (?, ?, ?)";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, newSection.getCourseYear());
            pStatement.setInt(2, newSection.getNoOfStudents());
            pStatement.setString(3, newSection.getSubjectCode());

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // call to update section
    public boolean updateSection(Section updateSection) {
        String sql = "UPDATE sectn SET no_of_students = ? WHERE course_year = ? AND subject_code = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setInt(1, updateSection.getNoOfStudents());
            pStatement.setString(2, updateSection.getCourseYear());
            pStatement.setString(3, updateSection.getSubjectCode());

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // call to delete section
    public boolean deleteSection(Section deleteSection){
        String sql = "DELETE FROM sectn WHERE course_year = ? AND subject_code = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, deleteSection.getCourseYear());
            pStatement.setString(2, deleteSection.getSubjectCode());

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // call to find section
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