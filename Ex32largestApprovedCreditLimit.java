/*
 Largest Approved Credit Limit   [Basic Coding | Beginner]
Given three proposed limits, print the largest and report if two or more are tied. Use only decisions, not arrays 
or library max methods.
Done when: All ordering and tie arrangements are tested.
 */

public class Ex32largestApprovedCreditLimit {
    public static void main(String[] args) {
        int a = 50000;
        int b = 80000;
        int c = 65000;

        if(a>b && a>c)
            System.out.println("Largest Credit Limit: " + a);
        else if(b>c)
            System.out.println("Largest Credit Limit: " + b);
        else
            System.out.println("Largest Credit Limit: " + c);
    }
}
