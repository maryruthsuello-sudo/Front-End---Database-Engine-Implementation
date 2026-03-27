package databaseengine.backend.service;

import databaseengine.backend.model.Section;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionService {
    private final Connection connect;

    public SectionService(Connection connect) {
        this.connect = connect;
    }

    public List<Section> viewSection() {
        List<Section> sections = new ArrayList<>();
        String sql = "SELECT * FROM sectn";

        try (Statement statement = connect.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                sections.add(new Section(
                    rs.getInt("section_id"),
                    rs.getInt("course_id"),
                    rs.getString("instructor"),
                    rs.getString("school_year"),
                    rs.getString("term"),
                    rs.getString("schedule")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sections;
    }

    public boolean createSection(Section section) {
        String sql = "INSERT INTO sectn (section_id, course_id, instructor, school_year, term, schedule) VALUES (?, ?, ?, ?, ?)";
        if (findSection(section.getSectionId())) {
            System.out.println("Error: This section already exists for this term.");
            return false; 
        }

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, section.getSectionId());
            ps.setInt(2, section.getCourseId());
            ps.setString(3, section.getInstructor());
            ps.setString(4, section.getSchoolYear());
            ps.setString(5, section.getTerm());
            ps.setString(6, section.getSchedule());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSection(Section section) {
        String sql = "UPDATE sectn SET course_id = ?, instructor = ?, school_year = ?, term = ?, schedule = ? WHERE section_id = ?";
        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, section.getCourseId());
            ps.setString(2, section.getInstructor());
            ps.setString(3, section.getSchoolYear());
            ps.setString(4, section.getTerm());
            ps.setString(5, section.getSchedule());
            ps.setInt(6, section.getSectionId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSection(int sectionId) {
        String sql = "DELETE FROM sectn WHERE section_id = ?";
        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, sectionId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean findSection(int sectionId) {
        String sql = "SELECT 1 FROM sectn WHERE course_year = ? AND subject_code = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, sectionId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}