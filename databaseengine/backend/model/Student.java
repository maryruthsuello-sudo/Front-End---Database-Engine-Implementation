package databaseengine.backend.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Student {
    private final Connection connect;

    public Student(Connection connect){
        this.connect = connect;
    }

    public void viewStudents(){
        try (Statement statement = connect.createStatement()) {
            ResultSet students = statement.executeQuery("SELECT * FROM student;");
            while (students.next()) {
                int id = students.getInt("student_id");
                String name = students.getString("student_name");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println();
            }
            students.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
