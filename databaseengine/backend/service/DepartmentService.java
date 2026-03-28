package databaseengine.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import databaseengine.backend.model.Department;

public class DepartmentService {
    private final Connection connect;

    public DepartmentService(Connection connect){
        this.connect = connect;
    }

    // method to call to create department
    public boolean createDepartment(Department newDepartment){
        String sql = "INSERT INTO department (college, prog, dept_head, dean, instructor, course) "
               + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pStatement = connect.prepareStatement(sql)){
            pStatement.setString(1, newDepartment.getCollege());
            pStatement.setString(2, newDepartment.getProgram());
            pStatement.setString(3, newDepartment.getDeptHead());
            pStatement.setString(4, newDepartment.getDean());
            pStatement.setString(5, newDepartment.getInstructor());
            pStatement.setString(6, newDepartment.getCourse());
            
            return pStatement.executeUpdate() > 0;

        } catch (SQLException e){
            e.printStackTrace();
        }
            
        // department not created
        return false;
    }

        // update department
    public boolean updateDepartment(Department department){
        String sql = "UPDATE department SET instructor = ?, dean = ?, "
              + "dept_head = ?, course = ?, college = ? "
              + "WHERE prog = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, department.getInstructor());
            pStatement.setString(2, department.getDean());
            pStatement.setString(3, department.getDeptHead());
            pStatement.setString(4, department.getCourse());
            pStatement.setString(5, department.getCollege());
            pStatement.setString(6, department.getProgram()); // WHERE prog = ?

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // not updated
    }

    // delete department via program name
    public boolean deleteDepartment(String program){
        String sql = "DELETE FROM department WHERE prog = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)){
            pStatement.setString(1, program);

            return pStatement.executeUpdate() > 0;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    //get all departments to display in table
    public ArrayList<Department> getAllDepartments() {
        ArrayList<Department> departments = new ArrayList<>();
        String sql = "SELECT college, prog, dept_head, dean, instructor, course FROM department";

        try (Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Department department = new Department(
                    rs.getString("college"),
                    rs.getString("prog"),
                    rs.getString("dept_head"),
                    rs.getString("dean"),
                    rs.getString("instructor"),
                    rs.getString("course")
                );

                departments.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }
}
