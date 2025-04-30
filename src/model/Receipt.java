package model;

public class Receipt {
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
