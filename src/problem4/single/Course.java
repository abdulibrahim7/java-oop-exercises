package problem4.single;

import java.util.Objects;
import problem4.Instructor;
import problem4.Textbook;

public class Course {
    private String courseName;
    private Instructor instructor;
    private Textbook textbook;

    // This constructor creates the Instructor and Textbook within Course.
    public Course(String courseName, String firstName, String lastName,
                  String officeNumber, String title, String author, String publisher) {
        this(courseName, new Instructor(firstName, lastName, officeNumber),
                new Textbook(title, author, publisher));
    }

    // Aggregation also permits objects that already exist independently.
    public Course(String courseName, Instructor instructor, Textbook textbook) {
        setCourseName(courseName);
        setInstructor(instructor);
        setTextbook(textbook);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = Objects.requireNonNull(instructor, "Instructor is required.");
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = Objects.requireNonNull(textbook, "Textbook is required.");
    }

    public void print() {
        System.out.println("Course: " + courseName);
        System.out.println("Instructor: " + instructor.getFirstName() + " "
                + instructor.getLastName() + " | Office: " + instructor.getOfficeNumber());
        System.out.println("Textbook: " + textbook.getTitle() + " | Author: "
                + textbook.getAuthor() + " | Publisher: " + textbook.getPublisher());
    }
}
