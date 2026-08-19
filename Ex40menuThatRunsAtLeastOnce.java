/*
Menu That Runs at Least Once   [Build from Scratch | Beginner]
Use do-while to display a simple banking menu at least once and repeat until the chosen option represents exit. 
Use predetermined choices first; Scanner input comes later.
Done when: The menu always appears once and exits on the correct choice.
 */

public class Ex40menuThatRunsAtLeastOnce {
    public static void main(String[] args) {
        int choices[] = { 1, 2, 3, 4 };
        
        int i = 0;
        int choice;

        do {
            choice = choices[i];
            System.out.println("Selected Option: " + choice);
            i++;
        }
        while( choice != 4);
        
    }
}
