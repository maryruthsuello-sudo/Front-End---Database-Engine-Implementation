package databaseengine.backend.service;

import databaseengine.backend.model.Graduate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GraduateService {
    private final Connection connect;

    public GraduateService(Connection connect) {
        this.connect = connect;
    }

    // retrieves all graduate records for table display
    public ArrayList<Graduate> viewGraduates() {
        ArrayList<Graduate> list = new ArrayList<>();

        String sql = """
            SELECT g.student_id, s.student_name, g.prog, g.unit_grade,
                   g.rating, g.graduation_date, g.final_grade, g.major
            FROM graduates g
            JOIN student s ON g.student_id = s.student_id
        """;

        try (PreparedStatement ps = connect.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(Graduate.forDisplay(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("prog"),
                    rs.getBigDecimal("unit_grade"),
                    rs.getBigDecimal("rating"),
                    rs.getDate("graduation_date"),
                    rs.getBigDecimal("final_grade"),
                    rs.getString("major")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // call to create graduate record
    public boolean createGraduate(Graduate graduate) {
        if (findGraduate(graduate.getStudentId(), graduate.getProg())) {
            System.out.println("Graduate already exists.");
            return false;
        }

        String sql = """
            INSERT INTO graduates
            (student_id, prog, unit_grade, rating, graduation_date, final_grade, major)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, graduate.getStudentId());
            ps.setString(2, graduate.getProg());
            ps.setBigDecimal(3, graduate.getUnitGrade());
            ps.setBigDecimal(4, graduate.getRating());
            ps.setDate(5, graduate.getGraduationDate());
            ps.setBigDecimal(6, graduate.getFinalGrade());
            ps.setString(7, graduate.getMajor());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // delete graduate
    public boolean deleteGraduate(int studentId) {
        String sql = "DELETE FROM graduates WHERE student_id = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // update graduate
    public boolean updateGraduate(Graduate graduate) {
        String sql = """
            UPDATE graduates
            SET prog = ?, unit_grade = ?, rating = ?, graduation_date = ?, final_grade = ?, major = ?
            WHERE student_id = ?
        """;

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, graduate.getProg());
            ps.setBigDecimal(2, graduate.getUnitGrade());
            ps.setBigDecimal(3, graduate.getRating());
            ps.setDate(4, graduate.getGraduationDate());
            ps.setBigDecimal(5, graduate.getFinalGrade());
            ps.setString(6, graduate.getMajor());
            ps.setInt(7, graduate.getStudentId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

     // check if graduate already exists
    public boolean findGraduate(int studentId, String prog) {
        String sql = "SELECT 1 FROM graduates WHERE student_id = ? AND prog = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setString(2, prog);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}