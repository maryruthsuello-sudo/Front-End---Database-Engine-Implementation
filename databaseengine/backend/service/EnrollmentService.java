package databaseengine.backend.service;

import databaseengine.backend.model.Enrollment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnrollmentService {
    private final Connection connect;

    public EnrollmentService(Connection connect){
        this.connect = connect;
    }

    // Create enrollment — mirrors createStudent() in StudentService exactly.
    // No pre-checks. Just INSERT and let the DB enforce constraints.
    public boolean createEnrollment(Enrollment newEnrollment) {
        String sql = "INSERT INTO enrollment (student_id, prog, school_year, date_admitted) "
                  + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setInt(1, newEnrollment.getId());
            pStatement.setString(2, newEnrollment.getProgram());
            pStatement.setString(3, newEnrollment.getSchoolYr());
            pStatement.setDate(4, newEnrollment.getDateAdmitted());

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // prints exact DB error (FK violation, duplicate, etc.)
        }

        return false;
    }

    // Update enrollment
    public boolean updateEnrollment(Enrollment enrollment) {
        String sql = "UPDATE enrollment SET prog = ?, school_year = ?, date_admitted = ? "
                  + "WHERE student_id = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, enrollment.getProgram());
            pStatement.setString(2, enrollment.getSchoolYr());
            pStatement.setDate(3, enrollment.getDateAdmitted());
            pStatement.setInt(4, enrollment.getId());

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete enrollment by student_id
    public boolean deleteEnrollment(int studentId) {
        String sql = "DELETE FROM enrollment WHERE student_id = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setInt(1, studentId);
            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get all enrollment records
    public ArrayList<Enrollment> getAllEnrollment() {
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT student_id, prog, school_year, date_admitted FROM enrollment";

        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                    rs.getInt("student_id"),
                    rs.getString("prog"),
                    rs.getString("school_year"),
                    rs.getDate("date_admitted")
                );
                enrollments.add(enrollment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enrollments;
    }
}