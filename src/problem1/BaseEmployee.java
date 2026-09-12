package problem1;

import java.util.Locale;

public class BaseEmployee extends Employee {
    private double baseSalary;

    public BaseEmployee(String firstName, String lastName,
                        String socialSecurityNumber, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(Locale.US, " | Base salary: $%,.2f", baseSalary);
    }
}
