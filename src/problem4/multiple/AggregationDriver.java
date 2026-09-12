package problem4.multiple;

public class AggregationDriver {
    public static void main(String[] args) {
        Course course = new Course("CS3560 Object-Oriented Design and Programming");
        course.addInstructor("Nima", "Davarpanah", "3-2636");
        course.addTextbook("Clean Code", "Robert C. Martin", "Prentice Hall");

        // The second instructor and textbook are made-up data, as requested.
        course.addInstructor("Alex", "Morgan", "8-101");
        course.addTextbook("Object-Oriented Programming Fundamentals",
                "Taylor Chen", "Example Academic Press");

        course.print();
    }
}
