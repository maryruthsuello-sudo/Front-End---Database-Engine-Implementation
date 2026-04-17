package databaseengine.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import databaseengine.backend.model.Enrollment;

public class EnrollmentService {
    private final Connection connect;

    public EnrollmentService(Connection connect){
        this.connect = connect;
    }

    // method to create enrollment
    public boolean createEnrollment(Enrollment newEnrollment) {
        String sql = "INSERT INTO enrollment (student_id, prog, school_year, date_admitted) "
                  + "VALUES (?, ?, ?, ?)";
        
        if (!isEnrolled(newEnrollment.getId(), newEnrollment.getProgram(), newEnrollment.getSchoolYr())) {
            try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
                pStatement.setInt(1, newEnrollment.getId()); 
                pStatement.setString(2, newEnrollment.getProgram()); 
                pStatement.setString(3, newEnrollment.getSchoolYr()); 
                pStatement.setDate(4, newEnrollment.getDateAdmitted()); 

                return pStatement.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
        
        // enrollment not created
        return false;
    }

    private boolean isEnrolled(int id, String prog, String schoolYr){
        String sql = "SELECT * FROM enrollment WHERE student_id = ? AND prog = ? AND school_year = ?";
        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, prog);
            stmt.setString(3, schoolYr);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return true; // student does exists
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        // student does not exists
        return false;
    }

    // Update enrollment
    public boolean updateEnrollment(Enrollment enrollment) {
        String sql = "UPDATE enrollment SET  date_admitted = ? WHERE student_id = ? AND prog = ? AND school_year = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setDate(1, enrollment.getDateAdmitted());    
            pStatement.setInt(2, enrollment.getId());
            pStatement.setString(3, enrollment.getProgram());  
            pStatement.setString(4, enrollment.getSchoolYr());    

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // update failed
    }

    // delete enrollment 
    public boolean deleteEnrollment(int id, String prog, String schoolYr){
        String sql = "DELETE FROM enrollment WHERE student_id = ? AND prog = ? AND school_year = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)){
            pStatement.setInt(1, id);
            pStatement.setString(2, prog);
            pStatement.setString(3, schoolYr);
            
            return pStatement.executeUpdate() > 0;
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        // not deleted
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
