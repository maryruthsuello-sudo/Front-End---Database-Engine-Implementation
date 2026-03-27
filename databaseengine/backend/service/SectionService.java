package databaseengine.backend.service;

import databaseengine.backend.model.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SectionService {
    private final Connection connect;

    public SectionService(Connection connect) {
        this.connect = connect;
    }

    public List<Section> viewSection() {
        List<Section> sections = new ArrayList<>();
        String sql = "SELECT course_year, subject_code, no_of_students FROM sectn";

        try (
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                Section sect = new Section(
                    rs.getString("course_year"), 
                    rs.getString("subject_code"),  
                    rs.getInt("no_of_students")
                );
                sections.add(sect);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sections;
    }

    public boolean createSection(Section newSection) {
        String sql = "INSERT INTO sectn (course_year, no_of_students, subject_code) VALUES (?, ?, ?)";
        if(!findSection(newSection.getCourseYear(), newSection.getSubjectCode())){
            try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
                pStatement.setString(1, newSection.getCourseYear());
                pStatement.setInt(2, newSection.getNoOfStudents());
                pStatement.setString(3, newSection.getSubjectCode());

                int affectedRows = pStatement.executeUpdate();

                if (affectedRows > 0) {
                    return true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public boolean updateSection(Section updateSection) {
        if (!findSection(updateSection.getCourseYear(), updateSection.getSubjectCode())) {
            System.out.println("Section not found.");
            return false;
        }

        String sql = "UPDATE sectn SET no_of_students = ? WHERE course_year = ? AND subject_code = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setInt(1, updateSection.getNoOfStudents());
            pStatement.setString(2, updateSection.getCourseYear());
            pStatement.setString(3, updateSection.getSubjectCode());

            int affectedRows = pStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }

        return false;
    }

    public boolean deleteSection(String courseYr, String subjCode) {
        String sql = "DELETE FROM sectn WHERE course_year = ? AND subject_code = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, courseYr);
            pStatement.setString(2, subjCode);
            int affectedRows = pStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Section deleted successfully.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
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