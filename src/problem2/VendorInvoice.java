package problem2;

import java.util.Locale;

public class VendorInvoice implements Payable {
    private String vendorName;
    private String invoiceNumber;
    private double amountDue;

    public VendorInvoice(String vendorName, String invoiceNumber, double amountDue) {
        setVendorName(vendorName);
        setInvoiceNumber(invoiceNumber);
        setAmountDue(amountDue);
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        if (!Double.isFinite(amountDue) || amountDue < 0.0) {
            throw new IllegalArgumentException("Amount due must be finite and non-negative.");
        }
        this.amountDue = amountDue;
    }

    @Override
    public double calculatePayment() {
        return amountDue;
    }

    @Override
    public String getPayeeName() {
        return vendorName;
    }

    @Override
    public void print() {
        System.out.printf(Locale.US, "Vendor: %s | Invoice: %s | Payment: $%,.2f%n",
                getPayeeName(), invoiceNumber, calculatePayment());
    }
}
