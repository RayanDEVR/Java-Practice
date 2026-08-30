/* 
Username Construction   [Scenario-Based | Intermediate]
Using simple String operations already practiced and a StringBuilder, create a username from a first name, a 
last name and a numeric suffix. State assumptions about capitalization rather than introducing unverified APIs.
Done when: The construction is deterministic and handles empty-name assumptions explicitly.
*/

public class Ex91UsernameConstruction {
    static String buildUsername(String firstName, String lastName, int suffix) {
        StringBuilder sb = new StringBuilder();
        if (firstName != null && firstName.length() > 0) {
            sb.append(firstName.toLowerCase());
        }
        if (lastName != null && lastName.length() > 0) {
            sb.append(".").append(lastName.toLowerCase());
        }

        sb.append(suffix);
        return sb.toString();

    }
    public static void main(String[] args) {
        System.out.println(buildUsername("Samiul", "Rayan", 20));
        System.out.println(buildUsername("Abdullah", "Radoan", 30));
        System.out.println(buildUsername("Anika", null, 13));
        System.out.println(buildUsername(null, "Ahmed", 19));
    }
}
