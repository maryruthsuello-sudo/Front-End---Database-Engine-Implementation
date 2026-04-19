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
        String sql = "SELECT sectn_id, subject_code, instructor, course_year, time, term, no_of_students FROM sectn";
        
        try (
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery()
        ) { 
            while (rs.next()) { 
                Section section = new Section(
                    rs.getInt("sectn_id"),
                    rs.getString("instructor"),
                    rs.getString("course_year"),
                    rs.getString("subject_code"),
                    rs.getString("time"),
                    rs.getString("term"),
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

        String sql = "INSERT INTO sectn (subject_code, instructor, course_year, time, term, no_of_students) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, newSection.getSubjectCode());
            pStatement.setString(2, newSection.getInstructor());
            pStatement.setString(3, newSection.getCourseYear());
            pStatement.setString(4, newSection.getTime());
            pStatement.setString(5, newSection.getTerm());
            pStatement.setInt(6, newSection.getNoOfStudents());

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // call to update section
    public boolean updateSection(Section updateSection) {
        String sql = "UPDATE sectn SET subject_code = ?, instructor = ?, course_year = ?, time = ?, term = ?, no_of_students = ? WHERE sectn_id = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, updateSection.getSubjectCode());
            pStatement.setString(2, updateSection.getInstructor());
            pStatement.setString(3, updateSection.getCourseYear());
            pStatement.setString(4, updateSection.getTime());
            pStatement.setString(5, updateSection.getTerm());
            pStatement.setInt(6, updateSection.getNoOfStudents());
            pStatement.setInt(7, updateSection.getId());

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // call to delete section
    public boolean deleteSection(int sectnId){
        String sql = "DELETE FROM sectn WHERE sectn_id = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setInt(1, sectnId);

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