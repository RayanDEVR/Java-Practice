/*
final and Immutability Reasoning   [Build from Scratch | Advanced]
Create a CustomerId value object with final field, constructor and getter only. Explain what final prevents and 
what additional choices make the simple object effectively immutable.
Done when: No method changes state and the explanation does not equate final reference with deeply 
immutable referenced objects.
*/

class CustomerId {
    private final String id;            //final stops reassign for id

    public CustomerId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

public class Ex140FinalAndImmutabilityReasoning {
    public static void main(String[] args) {
        CustomerId id = new CustomerId("CUST-001");
        System.out.println("Customer ID: " + id.getId());
    }
}
