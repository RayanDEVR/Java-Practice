/*
Three-Dimensional Warehouse Snapshot   [Code Reading | Intermediate]
Interpret a 3D array as warehouse -> aisle -> shelf quantity. Write nested traversal that prints coordinates and 
total stock per warehouse.
Done when: Coordinate labels and totals correspond to the supplied dimensions.
*/

public class Ex77threeDimensionalWarehouseSnapshot {
    public static void main(String[] args) {
        int[][][] warehouse = {
                { { 10, 31 }, { 13, 14 } },
                { { 19, 30, 40 }, { 90, 80, 34 } }
        };

        int warehouseTotal = 0;
        for (int w = 0; w < warehouse.length; w++) {
            for (int a = 0; a < warehouse[w].length; a++) {
                for (int s = 0; s < warehouse[w][a].length; s++) {
                    int quantity = warehouse[w][a][s];
                    System.out.println("Warehouse-" + w + " Aisle-" + a + " Shelf-" + s + " = " + quantity);
                    warehouseTotal += quantity;
                }
            }
            System.out.println("Warehouse-" + w + " Total Stock: " + warehouseTotal);
                System.out.println();
        }

    }
}
