package problem1;

import java.util.Locale;

// The class name keeps the exact spelling used in the assignment.
public class CommisionEmployee extends Employee {
    private double commissionRate;
    private double grossSales;

    public CommisionEmployee(String firstName, String lastName,
                             String socialSecurityNumber,
                             double commissionRate, double grossSales) {
        super(firstName, lastName, socialSecurityNumber);
        setCommissionRate(commissionRate);
        setGrossSales(grossSales);
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(Locale.US,
                " | Commission rate: %.0f%% | Gross sales: $%,.2f",
                commissionRate * 100.0, grossSales);
    }
}
