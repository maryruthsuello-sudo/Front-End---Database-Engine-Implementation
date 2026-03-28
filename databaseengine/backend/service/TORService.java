package databaseengine.backend.service;

import databaseengine.backend.model.TOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TORService {
    private final Connection connect;

    public TORService(Connection connect) {
        this.connect = connect;
    }

    // call to display TOR records
    public ArrayList<TOR> viewTor() {
        ArrayList<TOR> list = new ArrayList<>();

        String sql = """
            SELECT t.student_id, s.student_name, t.date_completed
            FROM tor t
            JOIN student s ON t.student_id = s.student_id
        """;

        try (PreparedStatement ps = connect.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(TOR.forDisplay(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getDate("date_completed")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // call to generate tor
    public boolean generateTor(TOR tor) {
        if (findTor(tor.getStudentId())) {
            return false;
        }

        String sql = "INSERT INTO tor (student_id, date_completed) VALUES (?, ?)";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, tor.getStudentId());
            ps.setDate(2, tor.getDateCompleted());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean findTor(int studentId) {
        String sql = "SELECT 1 FROM tor WHERE student_id = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}