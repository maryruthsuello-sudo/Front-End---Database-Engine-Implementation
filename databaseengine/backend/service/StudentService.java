package databaseengine.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import databaseengine.backend.model.Student;

public class StudentService {
    private final Connection connect;

    public StudentService(Connection connect){
        this.connect = connect;
    }

    // method to call to create student
    public boolean createStudent(Student newStudent){
        String sql = "INSERT INTO student (student_name, student_birthday, student_address, student_highschool, student_category, birth_place) "
               + "VALUES (?, ?, ?, ?, ?, ?)";
        
        if (!findStudent(newStudent.getName())){
            try (PreparedStatement pStatement = connect.prepareStatement(sql)){
                pStatement.setString(1, newStudent.getName());
                pStatement.setDate(2, newStudent.getBirthday());
                pStatement.setString(3, newStudent.getAddress());
                pStatement.setString(4, newStudent.getHighSchool());
                pStatement.setString(5, newStudent.getCategory());
                pStatement.setString(6, newStudent.getBirthPlace());

            } catch (SQLException e){
                e.getStackTrace();
            }
            // student successfully created
            return true;
        }
        // student not created
        return false;
    }

    private boolean findStudent(String name){
        String sql = "SELECT * FROM student WHERE student_name = ?";
        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            
            if (rs == null) return true; // student does not exist

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // student already exist
        return false;
    }

    //update student
    public boolean updateStudent(Student student){
        String sql = "UPDATE student SET student_name = ?, student_birthday = ?, student_address = ?, "
               + "student_highschool = ?, student_category = ?, birth_place = ? "
               + "WHERE student_id = ?";
        try (PreparedStatement pStatement = connect.prepareStatement(sql)) {
            pStatement.setString(1, student.getName());
            pStatement.setDate(2, student.getBirthday());
            pStatement.setString(3, student.getAddress());
            pStatement.setString(4, student.getHighSchool());
            pStatement.setString(5, student.getCategory());
            pStatement.setString(6, student.getBirthPlace());
            pStatement.setInt(7, student.getId());

            int affectedRow = pStatement.executeUpdate();

            if (affectedRow > 0) return true; // not updated

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // updated successfully
        return false;
    }

    // delete student 
    public boolean deleteStudent(int id){
        String sql = "DELETE FROM student WHERE student_id = ?";

        try (PreparedStatement pStatement = connect.prepareStatement(sql)){
            pStatement.setInt(1, id);
            int affectedRow = pStatement.executeUpdate();

            if (affectedRow > 0){
                // deleted
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        // not deleted
        return false;
    }

    //get all students to display in table
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT student_id, student_name, student_birthday, student_address, "
                   + "student_highschool, student_category, birth_place FROM student";

        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getDate("student_birthday"),
                    rs.getString("birth_place"),
                    rs.getString("student_address"),
                    rs.getString("student_highschool"),
                    rs.getString("student_category")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

}
