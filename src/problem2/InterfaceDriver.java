package problem2;

import java.util.ArrayList;
import java.util.Locale;

public class InterfaceDriver {
    public static void main(String[] args) {
        ArrayList<Payable> payables = new ArrayList<>();
        payables.add(new Freelancer("Alex", "Morgan", 50.0, 38.0));
        payables.add(new Freelancer("Jordan", "Lee", 60.0, 45.0));
        payables.add(new VendorInvoice("Acme Office Supplies", "INV-1001", 450.75));
        payables.add(new VendorInvoice("Cloud Hosting Services", "INV-1002", 199.25));

        double totalPayout = 0.0;
        for (Payable payable : payables) {
            payable.print();
            totalPayout += payable.calculatePayment();
        }

        System.out.printf(Locale.US, "Total payout: $%,.2f%n", totalPayout);
    }
}
