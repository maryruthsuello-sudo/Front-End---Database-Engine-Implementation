package databaseengine;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {
    private static final float MIN_GRADE = 1.0f;
    private static final float MAX_GRADE = 5.0f;

    private ArrayList<Program> programs = new ArrayList<>();

    public void addCourse(Scanner sc) {
        System.out.print("Program: ");
        String program = sc.nextLine().trim();

        System.out.print("Subject Code: ");
        String subjectCode = sc.nextLine().trim().toUpperCase();

        int units = promptInt(sc, "Units: ");
        if (units <= 0) {
            System.out.println("Error: Units must be a positive integer.");
            return;
        }

        System.out.print("Descriptive Title: ");
        String descriptiveTitle = sc.nextLine().trim();

        float grade = promptFloat(sc, "Grade: ");
        if (grade < MIN_GRADE || grade > MAX_GRADE) {
            System.out.printf("Error: Grade must be between %.1f and %.1f.%n", MIN_GRADE, MAX_GRADE);
            return;
        }

        System.out.print("Time: ");
        String time = sc.nextLine().trim();

        System.out.print("Term: ");
        String term = sc.nextLine().trim();

        System.out.print("Date Submitted (yyyy-mm-dd): ");
        String dateSubmitted = sc.nextLine().trim();

        Program p = findOrCreateProgram(program);

        // Prevent duplicate subject codes within the same program
        if (p.hasCourse(subjectCode)) {
            System.out.println("Error: Subject code '" + subjectCode + "' already exists in program '" + program + "'.");
            return;
        }

        p.addCourse(new Course(program, subjectCode, units, descriptiveTitle, grade, time, term, dateSubmitted));
        System.out.println("Course added successfully!");
    }

    // Finds an existing program by name, or creates and registers a new one
    private Program findOrCreateProgram(String name) {
        for (Program prog : programs) {
            if (prog.getName().equalsIgnoreCase(name)) {
                return prog;
            }
        }
        Program newProgram = new Program(name);
        programs.add(newProgram);
        return newProgram;
    }

    // Safely parses an integer from user input, re-prompts on invalid input
    private int promptInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    // Safely parses a float from user input, re-prompts on invalid input
    private float promptFloat(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Float.parseFloat(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a decimal number.");
            }
        }
    }

    // Add this method to your existing CourseManager class
public void viewCourses() {
    if (programs.isEmpty()) {
        System.out.println("No courses found.");
        return;
    }
    for (Program p : programs) {
        System.out.println("\nProgram: " + p.getName());
        System.out.println("--------------------------------------------------");
        p.displayCourses();
    }
}
}