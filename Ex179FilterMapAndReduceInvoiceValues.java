/*
Filter, Map and Reduce Invoice Values [Build from Scratch | Advanced]
Given a List<Integer> of line totals in cents, stream it: filter qualifying values, map them through a simple 
transformation and reduce to a sum. Also implement the loop version.
Done when: Both versions return the same result and every pipeline stage is explained.
*/

import java.util.List;

public class Ex179FilterMapAndReduceInvoiceValues {
    
    public static void main(String[] args) {
        List<Integer> lineTotalsInCents = List.of(1000, 1200, 300, 4000, 500);
        
        //Stream Version
        int streamResult = lineTotalsInCents.stream()
        .filter(amount -> amount >= 500)
        .map(amount -> (int)(amount * 1.10))
        .reduce(0, Integer::sum);
        
        System.out.println("Stream Result: " + streamResult);
        
        //Loop Version
        int loopResult = 0;
        for (int amount : lineTotalsInCents){
            if (amount >= 500){
                int taxed = (int) (amount * 1.10);
                loopResult += taxed;
            }
        }
        
        System.out.println("Loop Result: " + loopResult);
        System.out.println("Match: " + (streamResult == loopResult));
    }   
}