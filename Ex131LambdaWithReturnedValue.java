/*
Lambda with Returned Value   [Code Completion | Advanced]
Complete lambdas for fee calculation, number comparison and text formatting, including a multi-statement 
lambda with explicit return.
Done when: Parameter/return types match their functional interface and braces/return are used correctly.
*/

interface feeCalculation {
    double calculateFee(double ammount);
}

interface numberComparison {
    double compareNumbers(double n1, double n2);
}

interface textFormatting {
    String formatText(String text);
}

public class Ex131LambdaWithReturnedValue {
    public static void main(String[] args) {
        feeCalculation fee =  ammount -> ammount * 0.02;
        numberComparison compare = (n1, n2) -> n1 > n2  ? n1 - n2  : n2 - n1; 
        textFormatting format = text -> {text = text.trim();
        String[] words = text.split(" ");
            return words[0].substring(0, 1).toUpperCase() + words[0].substring(1) + " "
                 + words[1].substring(0, 1).toUpperCase() + words[1].substring(1);
        };

        System.out.println("Fee on 1000.0: " + fee.calculateFee(1000.0));
        System.out.println("Compared result: " + compare.compareNumbers(5, 7));
        System.out.println("Formatted text: " + format.formatText("   hello world   "));
    }
}
