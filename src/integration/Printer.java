package integration;

public class Printer {
    /**
     * Prints the sale information to the console.
     *
     * @param sale The sale to print.
     */
    public static void print(SaleDTO sale) {
        System.out.println("--------------------Receipt--------------------");
        System.out.println("Sale Date: " + sale.date());
        System.out.println("Items Sold:");
        for (SoldItemDTO item : sale.items()) {
            System.out.println(" - " + item.item().getName() + ": " + item.quantity() + " x " + item.subtotal());
        }
        System.out.println("Total: " + sale.total());
        System.out.println("VAT: " + sale.vat());
        System.out.println("Amount Paid: " + sale.amountPaid());
        System.out.println("Change: " + sale.change());
        System.out.println("--------------------Receipt--------------------");
    }
}
