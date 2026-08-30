/*
Enhanced Switch: Plan Price   [Build from Scratch | Beginner]
Use the enhanced switch form to assign a monthly price for BASIC, STANDARD, PREMIUM and an invalid input. 
Compare its structure with a traditional switch.
Done when: The switch produces a value without duplicated assignment code and all options are tested.
 */

public class Ex038EnhancedSwitch
{
    public static void main(String[] args) {
        String Plan = "Premium";

        int result = switch (Plan) {
            case "Basic" -> (int) 500;
            case "Standard" -> 1000;
            case "Premium" -> 1500;
            default -> 0;
        };

        System.out.println("Price = " + result);
    }
}
