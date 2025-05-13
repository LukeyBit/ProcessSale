package integration;

import model.Customer;
import model.Discount;

import java.time.LocalDateTime;
import java.util.List;

public record SaleDTO(LocalDateTime date, List<SoldItemDTO> items, float total, float vat, Discount discount, float amountPaid, float change, Customer customer) {

    /**
     * Constructor for the SaleDTO class.
     * Initializes the date, items, total, vat, discount, amount paid, change, and customer.
     * @param date The sale date and time.
     * @param items The items sold in the sale.
     * @param total The total amount of the sale.
     * @param vat The VAT amount of the sale.
     * @param discount The discount applied to the sale.
     * @param amountPaid The amount paid for the sale.
     * @param change The change given to the customer.
     * @param customer The customer associated with the sale.
     */
    public SaleDTO(LocalDateTime date, List<SoldItemDTO> items, float total, float vat, Discount discount, float amountPaid, float change, Customer customer) {
        this.date = date;
        this.items = items;
        this.total = total;
        this.vat = vat;
        this.discount = discount;
        this.amountPaid = amountPaid;
        this.change = change;
        this.customer = customer;
    }
}
