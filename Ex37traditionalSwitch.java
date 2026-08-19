/*
Traditional Switch: Support Department   [Build from Scratch | Beginner]
Map numeric menu options to Billing, Technical, Sales or Exit with a default invalid option. Prevent fall-through 
unless it is intentionally explained.
Done when: Each case produces exactly one expected result.
 */

public class Ex37traditionalSwitch
{
    public static void main(String[] args) {
        int option = 3;
        switch (option) {
            case 1:
                System.out.println("Billing");
                break;

            case 2:
                System.out.println("Technical");
                break;

            case 3:
                System.out.println("Sales");
                break;

            case 4:
                System.out.println("Exit");
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
    }
}