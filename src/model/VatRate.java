package model;

/**
 * The VatRate enum represents different VAT rates used in the Point of Sale (POS) system.
 * Each enum constant corresponds to a specific VAT rate.
 */
public enum VatRate {
    VAT_RATE1(25),
    VAT_RATE2(12),
    VAT_RATE3(6);

    private final int value;

    /**
     * Constructor for the VatRate enum.
     * Initializes the VAT rate value.
     *
     * @param value The VAT rate value.
     */
    VatRate(int value) {
        this.value = value;
    }

    /**
     * Gets the VAT rate value.
     *
     * @return The VAT rate value.
     */
    public int getRate() {
        return value;
    }
}
