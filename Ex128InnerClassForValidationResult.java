/*
Inner Class for Validation Result   [Build from Scratch | Advanced]
Inside RegistrationService, create an inner Result class holding success and message. Return Result from 
validate without exposing unrelated internals.
Done when: The inner type is used because it is tightly coupled to its enclosing service.
*/

class RegistrationService {
    class Result {
        boolean success;
        String message;

        Result(boolean success, String massage) {
            this.success = success;
            this.message = massage;
        }

        public String toString() {
            return (success ? "Success: " : "Failure: ") + message;
        }
    }

    Result validate(String username, int age) {
        if (username == null || username.isEmpty())
            return new Result(false, "Username is required.");
        if (age < 18)
            return new Result(false, "Must be at least 18 years old.");
        return new Result(true, "Ragistration data is valid.");
    }
}

public class Ex128InnerClassForValidationResult {
    public static void main(String[] args) {
        RegistrationService service = new RegistrationService();
        System.out.println(service.validate("Rayan", 20));
        System.out.println(service.validate(null, 18));
        System.out.println(service.validate("Abdullah", 12));
    }
}
