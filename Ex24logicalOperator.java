/*
Logical Operator Truth Table   [Code Reading | Beginner]
Build a compact truth table for &&, || and !, then map it to “admin OR verified staff, AND active account.” Add 
parentheses that make the intended grouping explicit.
Done when: The truth table and business expression agree for all relevant combinations.
 */

public class Ex24logicalOperator {
    public static void main(String[] args) {
        
        boolean admin = true;
        boolean verifiedStaff = false;
        boolean accountActive = true;
        boolean permission = ((admin || verifiedStaff) && accountActive);
        
        if(permission==true)
            System.out.println("Access Granted");
        else
            System.out.println("Access Denied");
    }
}


/*
            &&            |             ||           |          !
--------------------------|--------------------------|-----------------
true && true -> true      | true || true -> true     | true -> false
true && false -> false    | true || false -> true    | false -> true
false && true -> false    | false || true -> true    |
false && false -> false   | false || false -> false  |
                            
*/