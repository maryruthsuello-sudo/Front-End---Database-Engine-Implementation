package databaseengine;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // Method to add a student
    public void addStudent(Scanner sc) {
        System.out.print("Student Name: ");
        String name = sc.nextLine();

        System.out.print("Student ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Birthday (yyyy-mm-dd): ");
        String birthday = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("Highschool: ");
        String highschool = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Birthplace: ");
        String birthplace = sc.nextLine();

        Student s = new Student(name, id, birthday, address, highschool, category, birthplace);
        students.add(s);
        System.out.println("Student added successfully!");
    }

    // Method to view all students
    public void viewStudents() {
        System.out.println("\n=== All Students ===");
        for (Student s : students) {
            System.out.println(s.display());
        }
    }
}