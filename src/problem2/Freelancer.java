package problem2;

import java.util.Locale;

public class Freelancer implements Payable {
    private String firstName;
    private String lastName;
    private double hourlyRate;
    private double hoursWorked;

    public Freelancer(String firstName, String lastName,
                      double hourlyRate, double hoursWorked) {
        setFirstName(firstName);
        setLastName(lastName);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (!Double.isFinite(hourlyRate) || hourlyRate < 0.0) {
            throw new IllegalArgumentException("Hourly rate must be finite and non-negative.");
        }
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (!Double.isFinite(hoursWorked) || hoursWorked < 0.0) {
            throw new IllegalArgumentException("Hours worked must be finite and non-negative.");
        }
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePayment() {
        double regularHours = Math.min(hoursWorked, 40.0);
        double overtimeHours = Math.max(hoursWorked - 40.0, 0.0);
        return regularHours * hourlyRate + overtimeHours * hourlyRate * 1.5;
    }

    @Override
    public String getPayeeName() {
        return firstName + " " + lastName;
    }

    @Override
    public void print() {
        System.out.printf(Locale.US, "Freelancer: %s | Payment: $%,.2f%n",
                getPayeeName(), calculatePayment());
    }
}
