package problem2;

public interface Payable {
    double calculatePayment();

    String getPayeeName();

    // The required driver calls print() on each Payable reference.
    void print();
}
