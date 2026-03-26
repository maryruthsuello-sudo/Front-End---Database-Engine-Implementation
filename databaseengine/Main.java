package databaseengine;

import java.util.Scanner;

import databaseengine.backend.StudentManager;
import databaseengine.backend.CourseManager;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        CourseManager courseManager = new CourseManager();

        while (true) {
            System.out.println("\n=== Student Information System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. View Students");
            System.out.println("4. View Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch   (choice) {
                    case 1: studentManager.addStudent(sc); break;
                    case 2: courseManager.addCourse(sc); break;
                    case 3: studentManager.viewStudents(); break;
                    case 4: courseManager.viewCourses(); break;
                    case 5:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid option! Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}