package databaseengine;

import java.util.ArrayList;

public class Program {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Program(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    // Used by CourseManager to prevent duplicate subject codes
    public boolean hasCourse(String subjectCode) {
        for (Course c : courses) {
            if (c.getSubjectCode().equalsIgnoreCase(subjectCode)) {
                return true;
            }
        }
        return false;
    }

    public void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("  No courses found.");
            return;
        }
        for (Course c : courses) {
            System.out.println("  " + c.display());
        }
    }
}