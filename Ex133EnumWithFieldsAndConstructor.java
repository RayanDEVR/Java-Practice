/*
Enum with Fields and Constructor   [Build from Scratch | Advanced]
Create MembershipPlan enum whose constants carry monthlyPrice and discountPercent through a private 
constructor and getters/methods.
Done when: Each constant holds the correct data and callers cannot create arbitrary plans.
*/

enum MembershipPlan {
    Basic(199, 0),
    Standered(499, 5),
    Premium(999, 10);

    private final double monthlyPrice;
    private final double discountPercent;

    MembershipPlan(double monthlyPrice, double discountPercent) {
        this.monthlyPrice = monthlyPrice;
        this.discountPercent = discountPercent;
    }

    double getMonthlyPrice() {
        return monthlyPrice;
    }

    double getDiscountPercent() {
        return discountPercent;
    }
}

public class Ex133EnumWithFieldsAndConstructor {
    public static void main(String[] args) {
        MembershipPlan[] plans = MembershipPlan.values();

        for (MembershipPlan m : plans) {
            System.out.println(m + " - price: " + m.getMonthlyPrice() + ", discount: " + m.getDiscountPercent() + "%");
        }
    }
}
