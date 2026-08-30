/*
Utility Billing Bands   [Scenario-Based | Beginner]
Calculate a progressive usage bill where different unit bands have different rates. Do not apply one rate to all 
units once a threshold is crossed.
Done when: Examples around every band boundary show progressive calculation.
 */

public class Ex049UtilityBillingBands {
    public static void main(String[] args) {
        double totalUnit = 100000;
        double bill=0;
       

        if(totalUnit >= 0 && totalUnit <= 100)
            bill = totalUnit * 5;

        else if (totalUnit >= 101 && totalUnit <= 300)
            bill = (100 * 5) + ((totalUnit - 100) * 7);

        else if (totalUnit > 300)
            bill = (100 * 5) + (200 * 7) + ((totalUnit - 300) * 10);

        System.out.println(bill);

}}



// 0-100  -> 5
//     101-300 -> 7
//     300+ -> 10
