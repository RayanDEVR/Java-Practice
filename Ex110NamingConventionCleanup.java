/*
Naming Convention Cleanup   [Refactoring | Intermediate]
Rename badly styled packages, classes, methods, variables and constants according to Java conventions taught 
in the course. Do not change behavior.
Done when: Names consistently reveal type versus action versus value roles.
*/




public class Ex110NamingConventionCleanup {
    public static void main(String[] args) {
        //Before: bad style
        /*
        class product_Item {
            public double Price;
            public static final double taxrate = 0.05;
        
            double Calculate_Total(int Qty) {
        return Qty * this.Price * (1 + taxrate);
            }
        }
        */

        //After: correct convention
        class ProductItem {
            public double price;
            public static final double TAX_RATE = 0.05;

            double Calculate_Total(int qty) {
                return qty * this.price * (1 + TAX_RATE);
            }
        }

    }
}

