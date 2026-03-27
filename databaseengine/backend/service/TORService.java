package databaseengine.backend.service;

import databaseengine.backend.model.TOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TORService {
    private final Connection connect;

    public TORService(Connection connect) {
        this.connect = connect;
    }

    // call to generate tor
    public boolean generateTor(TOR tor) {
        if (findTor(tor.getStudentId())) {
            System.out.println("TOR already exists.");
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

    // call to  display TOR records
    public List<TOR> viewTor() {
        List<TOR> list = new ArrayList<>();

        String sql = "SELECT student_id, date_completed FROM tor";

        try (PreparedStatement ps = connect.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new TOR(
                    rs.getInt("student_id"),
                    rs.getDate("date_completed")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}