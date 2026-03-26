package databaseengine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager(); // THIS IS THE CLASS YOU CALL

        while (true) {
            System.out.println("\n=== Student Information System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    // CALL THE STUDENT CLASS METHOD
                    manager.addStudent(sc);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    return; // stop program

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}