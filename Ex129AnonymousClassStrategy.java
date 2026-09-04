/*
Anonymous Class Strategy   [Build from Scratch | Advanced]
Given a DiscountPolicy interface with calculate(total), create a one-use festival policy using an anonymous class. 
Then compare with a lambda when the interface is functional.
Done when: Both versions produce the same result and readability is discussed.
*/

public class Ex129AnonymousClassStrategy {
    interface DiscountPolicy {
    double calculate(double total);
}
    public static void main(String[] args) {
        double total = 2000;

        //Anonymous class version
        DiscountPolicy festivalPolicyAnon = new DiscountPolicy() {
            @Override
            public double calculate(double total) {
                return total * 0.15;    //15% festival discount
            }
        };
        System.out.println("Anonymous class result: " + festivalPolicyAnon.calculate(total));

        //Lambda version            
        DiscountPolicy festivalPolicyLambda = t -> t * 0.15;
        System.out.println("Lambda result: " + festivalPolicyLambda.calculate(total));
    }
}
