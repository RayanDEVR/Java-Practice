/*
throws and Propagation Chain   [Code Reading | Advanced]
Trace an exception from a low-level calculate method through service method to main using throws. Decide at 
which layer the sample can recover with a user message.
Done when: The propagation path is correct and the chosen catch boundary has a reason.
*/

class CalculateException extends Exception {
    public CalculateException(String massage) {
        super(massage);
    }
}

class MathUtil {
    double calculate(double a, double b) throws CalculateException {
        if (b == 0)
            throw new CalculateException("Cannot divided by Zero");
        return a / b;
    }
}

class ReportService {
    double genarateReport(double total, double count) throws CalculateException {
        return new MathUtil().calculate(total, count);
    }
}

public class Ex152ThrowsAndPropagationChain {
    public static void main(String[] args) {
        try {
            double avg = new ReportService().genarateReport(100, 0);
            System.out.println("Average: " + avg);
        }
        catch (CalculateException e) {
            System.out.println("Report could not be generated: " + e.getMessage());
        }
    }
}
