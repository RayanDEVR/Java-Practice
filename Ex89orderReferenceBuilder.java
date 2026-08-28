/*
Order Reference Builder   [Build from Scratch | Intermediate]
Construct an order reference from a prefix, numeric ID and region using String concatenation. Produce a second 
clearer version using StringBuilder append calls.
Done when: Both outputs match and the trade-off is explained without unsupported performance claims.
*/

public class Ex89orderReferenceBuilder {
    public static void main(String[] args) {
        String prefix = "ORD";
        int id = 1042;
        String region = "DHK";
        String ref1 = prefix + "-" + id + "-" + region;         //String Concatenation

        StringBuilder sb = new StringBuilder();                 //StringBilder
        sb.append(prefix).append("-").append(id).append("-").append(region);
        String ref2 = sb.toString();

        System.out.println(ref1);
        System.out.println(ref2);
        System.out.println(ref1.equals(ref2));
    }
}
