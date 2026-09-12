package problem4.single;

public class AggregationDriver {
    public static void main(String[] args) {
        Course course = new Course("CS3560 Object-Oriented Design and Programming",
                "Nima", "Davarpanah", "3-2636",
                "Clean Code", "Robert C. Martin", "Prentice Hall");

        // Access each component's information using its getters and setters.
        course.getInstructor().setOfficeNumber("3-2636");
        course.getTextbook().setPublisher("Prentice Hall");
        course.print();
    }
}
