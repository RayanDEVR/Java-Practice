/*
Seat Availability Matrix   [Build from Scratch | Intermediate]
Represent occupied/free seats with a 2D boolean array. Print a seat map, count free seats and update one valid 
seat to occupied.
Done when: Already-occupied and invalid coordinates are handled with conditions.
*/

class Seat {
    boolean[][] seat;

    Seat(boolean[][] seat){
        this.seat = seat;
    }
    
    public void serial(int row, int column) {
         
        if(seat[row][column]){
            System.out.println("This seat is occupied.");
        }
        else{
            System.out.println("This seat is available.");
            seat[row][column] = true;
        }
    }
}

public class Ex75seatAvailabilityMatrix {
    public static void main(String[] args) {
        boolean[][] seat = {
                { false, false, true },
                { false, true, true },
                { true, false, false },
        };

        Seat s = new Seat(seat);                                        //seat check
        s.serial(0, 0);


        for (int i = 0; i < seat.length; i++) {                         //seat map
            for (int j = 0; j < seat.length; j++) {
                System.out.print((seat[i][j] ? "X" : "O") + "  ");
            }
            System.out.println();
        }


        int freeSeats = 0;                                              //free seats' number

        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat.length; j++) {
                if (!seat[i][j])
                    freeSeats++;
            }
        }
        
        System.out.println("Free Seats: " + freeSeats);
    }
}
    

    
    
