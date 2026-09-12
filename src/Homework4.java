/** Runs every assignment driver in the same order as the document. */
public class Homework4 {
    public static void main(String[] args) {
        System.out.println("1) INHERITANCE");
        problem1.InheritanceDriver.main(args);

        System.out.println("\n2) INTERFACE");
        problem2.InterfaceDriver.main(args);

        System.out.println("\n3) POLYMORPHISM");
        problem3.PolymorphismDriver.main(args);

        System.out.println("\n4) AGGREGATION - One instructor and one textbook");
        problem4.single.AggregationDriver.main(args);

        System.out.println("\n4) AGGREGATION - Two instructors and two textbooks");
        problem4.multiple.AggregationDriver.main(args);

        System.out.println("\n5) COMPOSITION");
        problem5.CompositionDriver.main(args);
    }
}
