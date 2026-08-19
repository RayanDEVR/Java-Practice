/*
Authentication Simulation Methods   [Scenario-Based | Intermediate]
Create isUsernameCorrect, isPasswordCorrect and authenticate methods using fixed expected values. Return a 
result rather than printing from each helper.
Done when: The program distinguishes unknown username, wrong password and success using method 
results/control flow.
*/

class check {
    private final String EXPECTED_USERNAME = "Rayan";
    private final String EXPECTED_PASSWORD = "admin123";

    public boolean isUsernameCorrect(String username) {
        return EXPECTED_USERNAME.equals(username);
    }

    public boolean isPasswordCorrect(String password) {
        return EXPECTED_PASSWORD.equals(password);
    }

    public String authenticate(String username, String password) {
        if (!isUsernameCorrect(username)) {
            return "Failed: Incorrect Username";
        }
        if (!isPasswordCorrect(password)) {
            return "Failed: Incorrect Password";
        } 
        else {
            return "Login Successful";
        }
    }
}

public class Ex61authenticationSimulationMethods {

    public static void main(String[] args) {
        check id = new check();

        System.out.println(id.authenticate("Rayan", "aadmin123"));      //Failed
        System.out.println(id.authenticate("Tina", "admin123"));        //Failed
        System.out.println(id.authenticate("Rayan", "admin123"));       //Successful
        
    }
}