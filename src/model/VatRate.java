package model;

public enum VatRate {
    VAT_RATE1(25),
    VAT_RATE2(12),
    VAT_RATE3(6);

    VatRate(int i) {
    }

    public int getRate() {
        return switch (this) {
            case VAT_RATE1 -> 25;
            case VAT_RATE2 -> 12;
            case VAT_RATE3 -> 6;
        };
    }
}
