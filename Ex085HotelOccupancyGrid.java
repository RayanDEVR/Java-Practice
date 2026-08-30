/*
Hotel Occupancy Grid   [Scenario-Based | Intermediate]
Represent floors and rooms with a 2D boolean array. Implement display,
count occupied per floor, find total available and attempt a room
booking after coordinate validation.
Done when: State changes only for a valid, currently free room.
*/

class Hotel {
    int floorNo;
    int roomNo;
    boolean[][] room;

    public Hotel(boolean[][] room) {
        this.room = room;
    }
    

    public void bookRoom(int floorNo, int roomNo) {

        if (floorNo < 0 || floorNo >= room.length || roomNo < 0 || roomNo >= room[floorNo].length) {        //available
            System.out.println("Invalid Floor/Room Coordinates.");
        } 
        else {
            if (!room[floorNo][roomNo]) {
                room[floorNo][roomNo] = true;
                System.out.println("This room is now occupied.");
            }
            else {
                System.out.println("This room is already occupied.");
            }
        }
    }
}


public class Ex085HotelOccupancyGrid {
    public static void main(String[] args) {
        boolean[][] room = new boolean[4][5];
        room[0][0] = true;
        room[1][4] = true;
        room[3][1] = true;

        for (int i = 0; i < room.length; i++) {
            System.out.print("Floor " + (i + 1) + ": ");            //map
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] == true)
                    System.out.print(" [Room " + (j + 1) + ": OCC] ");
                else
                    System.out.print(" [Room " + (j + 1) + ": FREE]");                
            }
            System.out.println();
        }
        System.out.println();


        Hotel h = new Hotel(room);

        h.bookRoom(2, 4);       //This room is now occupied.
        h.bookRoom(3, 1);       //This room is already occupied.
        h.bookRoom(4, 5);       //Invalid Floor/Room Coordinates.

        int occupiedRoom = 0;
        int totalAvailable = 0;
        for (int i = 0; i < room.length; i++) {             //occupied each floor and total available 
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j])
                    occupiedRoom++;
                else
                    totalAvailable++;
            }
            System.out.println("Occupied on Floor " + (i + 1) + ": " + occupiedRoom);
            occupiedRoom = 0;
        }
        System.out.println("Total Available Rooms: " + totalAvailable);
        System.out.println();


        for (int i = 0; i < room.length; i++) {             //map after booking
            System.out.print("Floor " + (i + 1) + ": ");
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] == true)
                    System.out.print(" [Room " + (j + 1) + ": OCC] ");
                else
                    System.out.print(" [Room " + (j + 1) + ": FREE]");
            }
            System.out.println();
        }
    }
}
