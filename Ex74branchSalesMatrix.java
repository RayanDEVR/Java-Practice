/*
Branch Sales Matrix   [Scenario-Based | Intermediate]
Use a 2D array where rows are branches and columns are months. Calculate each branch total, each month total 
and the grand total.
Done when: All totals reconcile; loops use actual row/column lengths.
*/

public class Ex74branchSalesMatrix {
    public static void main(String[] args) {
        double[][]	sales =	{
        {1000,	1200,	900},		//	Branch	0
		{800,	950,	1100},		//	Branch	1
        {1500,	1400,	1600}		//	Branch	2
        };


        double grandTotal = 0;
        for (int branches = 0; branches < sales.length; branches++) {
            double totalMonths = 0;
            for (int months = 0; months < sales.length; months++) {
                totalMonths += sales[branches][months];
            }
            System.out.println("Month " + branches + " total: " + totalMonths);
            grandTotal += totalMonths;
        }
        System.out.println();

        for (int months = 0; months < sales.length; months++) {
            double totalBranches = 0;
            for (int branches = 0; branches < sales.length; branches++) {
                totalBranches += sales[branches][months];
            }
            System.out.println("Branch " + months + " total: " + totalBranches);
        }
        
        System.out.println("Grand Total: " + grandTotal);
    }
}
