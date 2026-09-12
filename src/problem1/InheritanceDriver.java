package problem1;

public class InheritanceDriver {
    public static void main(String[] args) {
        // Instantiate the base class too, using Joe's supplied identity.
        Employee employee = new Employee("Joe", "Jones", "111-11-1111");
        System.out.println("Employee base-class example: " + employee);
        System.out.println("The seven employee records from the assignment:");

        Employee[] employees = {
            new SalariedEmployee(employee.getFirstName(), employee.getLastName(),
                    employee.getSocialSecurityNumber(), 2500.0),
            new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25.0, 32.0),
            new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19.0, 47.0),
            new CommisionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.0),
            new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700.0),
            new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.0),
            new CommisionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40000.0)
        };

        for (Employee current : employees) {
            System.out.println(current);
        }
    }
}
