/*
Reusable Boundary Methods   [Build from Scratch | Intermediate]
Create methods for isAgeValid, isMarkValid and isPercentageValid. Then write a registration decision method 
that reuses them.
 */


class boundaryValidator {
    public boolean isAgeValid(int age){
        return age >= 18 && age <= 30;
    }

    public boolean isMarkValid(double mark) {
        return mark >= 0 && mark <= 100;
    }

    public boolean isPercentageValid(double percentage){
        return percentage >= 0 && percentage <= 100;
    }

    public boolean canRegister(int age, double mark) {
        return isAgeValid(age) && isMarkValid(mark);       
    }
}
public class Ex060ReusableBoundaryMethods {
    public static void main(String[] args) {
        boundaryValidator id = new boundaryValidator();

        System.out.println(id.isAgeValid(34));
        System.out.println(id.isMarkValid(80));
        System.out.println(id.isPercentageValid(70));
        System.out.println(id.canRegister(29, 45));
    }
}
