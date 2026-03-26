package databaseengine.backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class StartDatabase {
    public static void main(String[] args) {
        String password = "Sherlin21@@@"; // change kung anong password nilagay sa postgres
        String dbName = "Suello_University"; // change kung ano name ng database sa postgres
        Connection connect = null;

        try{
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName,
            "postgres", password);
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
