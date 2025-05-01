package model;

/**
 * The Receipt class represents a receipt generated after a sale in the Point of Sale (POS) system.
 * It contains information about the sale, including date, total amount, VAT, change, and items sold.
 */
public class Receipt {

    /**
     * Constructor for the Receipt class.
     * It initializes the receipt with the sale information and prints it to the console.
     *
     * @param sale The sale object containing information about the sale.
     */
    protected Receipt(Sale sale) {
        System.out.println(
                "Receipt\n"
                + "Date: " + sale.getSaleDateTime()
                + "\nTotal: " + String.valueOf(sale.getTotal())
                + "\nVAT: " + sale.getVat()
                + "\nChange: " + sale.getChange()
                + "\nAmount Paid: " + sale.getAmountPaid()
                + "\nItems Sold: "
        );
        for (SoldItem item : sale.getItems()) {
            System.out.println(item.getItem().getName() + " - " + item.getQuantity());
        }
        System.out.println("\n");
    }
}
