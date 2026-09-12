package problem4.multiple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import problem4.Instructor;
import problem4.Textbook;

public class Course {
    private String courseName;
    private final List<Instructor> instructors = new ArrayList<>();
    private final List<Textbook> textbooks = new ArrayList<>();

    public Course(String courseName) {
        setCourseName(courseName);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Instructor> getInstructors() {
        return Collections.unmodifiableList(instructors);
    }

    public void setInstructor(int index, Instructor instructor) {
        instructors.set(index, Objects.requireNonNull(instructor, "Instructor is required."));
    }

    public void addInstructor(String firstName, String lastName, String officeNumber) {
        addInstructor(new Instructor(firstName, lastName, officeNumber));
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(Objects.requireNonNull(instructor, "Instructor is required."));
    }

    public List<Textbook> getTextbooks() {
        return Collections.unmodifiableList(textbooks);
    }

    public void setTextbook(int index, Textbook textbook) {
        textbooks.set(index, Objects.requireNonNull(textbook, "Textbook is required."));
    }

    public void addTextbook(String title, String author, String publisher) {
        addTextbook(new Textbook(title, author, publisher));
    }

    public void addTextbook(Textbook textbook) {
        textbooks.add(Objects.requireNonNull(textbook, "Textbook is required."));
    }

    public void print() {
        System.out.println("Course: " + courseName);
        for (int i = 0; i < instructors.size(); i++) {
            Instructor instructor = instructors.get(i);
            System.out.println("Instructor " + (i + 1) + ": " + instructor.getFirstName()
                    + " " + instructor.getLastName() + " | Office: "
                    + instructor.getOfficeNumber());
        }
        for (int i = 0; i < textbooks.size(); i++) {
            Textbook textbook = textbooks.get(i);
            System.out.println("Textbook " + (i + 1) + ": " + textbook.getTitle()
                    + " | Author: " + textbook.getAuthor()
                    + " | Publisher: " + textbook.getPublisher());
        }
    }
}
