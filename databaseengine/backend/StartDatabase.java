package databaseengine.backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class StartDatabase {
    private Database db;

    public StartDatabase(){
        start();
    }
  
    private void start(){
        String password = "Chuchay_0926"; // change kung anong password nilagay sa postgres
          String dbName = "SuelloUniversity"; // change kung ano name ng database sa postgres
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
        this.db = new Database(connect);
    }

    public Database getDb(){
        return db;
    }
}
