package databaseengine.backend.service;

import databaseengine.backend.model.Completion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CompletionService {
    private final Connection connect;

    public CompletionService(Connection connect) {
        this.connect = connect;
    }

    public List<Completion> viewCompletion() {
        List<Completion> completions = new ArrayList<>();
        String sql = "SELECT student_id, subject_code, units, grade FROM completion";

        try (
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Completion completion = new Completion(
                    rs.getInt("student_id"),
                    rs.getBigDecimal("grade"),
                    rs.getString("subject_code"),
                    rs.getInt("units")
                );

                completions.add(completion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return completions;
    }

    public boolean createCompletion(Completion newCompletion) {
        String sql = "INSERT INTO completion (student_id, grade, subject_code, units) VALUES (?, ?, ?, ?)";

        if(!findCompletion(newCompletion.getStudentId(), newCompletion.getSubjectCode())){
            try (PreparedStatement ps = connect.prepareStatement(sql)) {
                ps.setInt(1, newCompletion.getStudentId());
                ps.setBigDecimal(2, newCompletion.getGrade());
                ps.setString(3, newCompletion.getSubjectCode());
                ps.setInt(4, newCompletion.getUnits());

                int affectedRow = ps.executeUpdate();

                if (affectedRow > 0){
                    // completion successfully created
                    System.out.println("created");
                    return true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean updateCompletion(Completion updateCompletion) {
        String sql = "UPDATE completion SET grade = ?, units = ? WHERE student_id = ? AND subject_code = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setBigDecimal(1, updateCompletion.getGrade());
            ps.setInt(2, updateCompletion.getUnits());
            ps.setInt(3, updateCompletion.getStudentId());
            ps.setString(4, updateCompletion.getSubjectCode());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("updated successfully");
        return false;
    }

    public boolean deleteCompletion(int studentId, String subjectCode) {
        String sql = "DELETE FROM completion WHERE student_id = ? AND subject_code = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setString(2, subjectCode);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean findCompletion(int studentId, String subjectCode) {
        String sql = "SELECT * FROM completion WHERE student_id = ? AND subject_code = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setString(2, subjectCode);

            ResultSet rs = ps.executeQuery();
          
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
