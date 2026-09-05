/*
Functional Interface Contract   [Build from Scratch | Advanced]
Define @FunctionalInterface Validator with boolean isValid(String value). Implement one validator with a named 
class, one anonymous class and one lambda.
Done when: All three can be passed to one validation method and the annotation prevents adding a second 
abstract method.
*/



public class Ex130FunctionalInterfaceContract {
    @FunctionalInterface
    interface Validator {
        boolean isValid(String value);
    }

    static class NotEmptyValidator implements Validator {
        @Override
        public boolean isValid(String value) {
            return value != null && !value.isEmpty();
        }
    }

    static void runValidation(String label, Validator validator, String input)
    {
        System.out.println(label + " on \"" + input + "\"->" + validator.isValid(input));
    }
    
    public static void main(String[] args) {
        Validator nameValidator = new NotEmptyValidator();

        Validator anonymousValidator = new Validator() {
            @Override
            public boolean isValid(String value) {
                return value != null && value.length() >= 3;
            }
        };

        Validator lambdaValidator = value -> value != null && value.matches("@");

        runValidation("Named", nameValidator, "Alice");
        runValidation("Anonymous", anonymousValidator, "Al");
        runValidation("Lambda", lambdaValidator, "@");
    }
}
