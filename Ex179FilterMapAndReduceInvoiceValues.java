/*
Filter, Map and Reduce Invoice Values   [Build from Scratch | Advanced]
Given a List<Integer> of line totals in cents, stream it: filter qualifying values, map them through a simple 
transformation and reduce to a sum. Also implement the loop version.
Done when: Both versions return the same result and every pipeline stage is explained.
*/

import java.util.List;

public class Ex179FilterMapAndReduceInvoiceValues {
    public static void main(String[] args) {
        List<Integer> lineTotalInCents = List.of(500, 1000, 1200, 150, 300);
        int streamResult = lineTotalInCents.stream()
            .filter(amount -> amount >= 500)
            .map(amount -> (int) (amount * 1.10))
                .reduce(0, Integer::sum);

        System.out.println("Stream result: " + streamResult);

        int loopResult = 0;
        for (int amount : lineTotalInCents) {
            if (amount >= 500) {
                int taxed = (int) (amount * 1.10);
                loopResult += taxed;
            }
        }

        System.out.println("Loop result: " + loopResult);

        System.out.println("Stream result & Loop result are same: " + (streamResult == loopResult));
    }
}
