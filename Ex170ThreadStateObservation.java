/*
Thread State Observation   [Code Reading | Advanced]
Create a thread that waits/sleeps and inspect its state before start, during activity and after join using the state 
concept/API demonstrated. Explain possible timing sensitivity.
Done when: Observed states are recorded without assuming every run catches the exact same intermediate 
state.
*/

public class Ex170ThreadStateObservation {
    public static void main(String[] args) throws InterruptedException{
        Thread task = new Thread(() -> {
            try{
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        });

        System.out.println("Before start: " + task.getState());

        task.start();
        Thread.sleep(200);
        System.out.println("During activity: " + task.getState());

        task.join();
        System.out.println("After join: " + task.getState());
    }
}

