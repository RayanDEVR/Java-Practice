/*
Builder Capacity Observation   [Code Reading | Intermediate]
Create a StringBuilder, print length and capacity before and after several appends, and describe what capacity 
represents. Do not treat the observed growth formula as a business guarantee.
Done when: Length and capacity are not confused, and observations are recorded accurately.
*/

public class Ex92BuilderCapacityObservation {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println("Initial length: " + sb.length());
        System.out.println("Initial capacity: " + sb.capacity());

        sb.append("Hello");
        sb.append(" World");
        sb.toString();
        System.out.println("After append length: " + sb.length());
        System.out.println("After append length: " + sb.capacity());
    }
}


/*ength	= number of	characters currently stored.
capacity = size	of the internal	buffer before it must grow;
it grows automatically once	length would exceed	it.	The	exact
growth numbers are an implementation detail, not a fixed business rule.
*/
