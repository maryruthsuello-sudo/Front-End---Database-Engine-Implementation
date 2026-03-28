package databaseengine.backend.service;

import databaseengine.backend.model.Grades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GradesService {
    private final Connection connect;

    public GradesService(Connection connect) {
        this.connect = connect;
    }

    public ArrayList<Grades> viewGrade() {
        ArrayList<Grades> grades = new ArrayList<>();
        String sql = "SELECT student_id, subject_code, units, grade FROM completion";

        try (
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Grades grade = new Grades(
                    rs.getInt("student_id"),
                    rs.getBigDecimal("grade"),
                    rs.getString("subject_code"),
                    rs.getInt("units")
                );

                grades.add(grade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grades;
    }

    public boolean createGrade(Grades newCompletion) {
        String sql = "INSERT INTO completion (student_id, grade, subject_code, units) VALUES (?, ?, ?, ?)";

        if(!findGrade(newCompletion.getStudentId(), newCompletion.getSubjectCode())){
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

    public boolean updateGrade(Grades updateCompletion) {
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

    public boolean deleteGrade(int studentId, String subjectCode) {
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

    public int getStudentIdByName(String studentName) {
        String sql = "SELECT student_id FROM student WHERE student_name = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, studentName);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("student_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // not found
    }

    private boolean findGrade(int studentId, String subjectCode) {
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
