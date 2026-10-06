package capstoneApp.service;

public class NoDiscount implements DiscountPolicy {
    
    @Override
    public double getDiscount(double subtotal) {
        return 0;
    }
}
