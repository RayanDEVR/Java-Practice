/*
Cinema Seat Map   [Build from Scratch | Beginner]
Use nested loops to print rows A-D and seats 1-6 as labels such as A1. Do not store them yet.
Done when: All 24 unique seat labels appear in row-major order.
*/

public class Ex42cinemaSeatMap {
    public static void main(String[] args) {
        for (char rows = 'A'; rows <= 'D'; rows++) {
            for (int seat = 1; seat <= 6; seat++)
                System.out.print(rows + "" + seat + " ");
                
            System.out.println();
        }     
    }
}
