package capstoneApp.service;

public class PercentageDiscount implements DiscountPolicy {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage.");
        }

        this.percentage = percentage;
    }

    @Override 
    public double getDiscount(double subtotal) {
        return (subtotal * percentage) / 100;
    }
}
