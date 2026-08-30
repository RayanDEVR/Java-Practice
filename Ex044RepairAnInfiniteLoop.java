/*
Repair an Infinite Loop   [Bug Fixing | Beginner]
Fix three loops: one lacks an update, one updates in the wrong direction and one uses a condition that can never 
become false. Explain the minimum fix.
Done when: All loops terminate with the intended number of iterations.
 */

public class Ex044RepairAnInfiniteLoop {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++)
            System.out.println(i);

        System.out.println();

        for(int j = 5; j<10; j++)
            System.out.println(j);

        System.out.println();

        int k = 10;
        while (k <= 15) {
            System.out.println(k);
            k++;
        }
    }
}


//1st loop -- wrong (int i =1 ; i<5)
//2nd loop -- wrong (int j = 5; j<1; j++)
//3rd loop -- wrong while( k <=6)
//                   System.out.println(k);
