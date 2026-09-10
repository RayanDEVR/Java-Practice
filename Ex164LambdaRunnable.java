/*
Lambda Runnable   [Code Completion | Advanced]
Replace a simple anonymous Runnable with a lambda. Keep a multi-statement version and a one-statement 
version.
Done when: Both compile because Runnable is functional and behavior stays the same.
*/

public class Ex164LambdaRunnable {
    public static void main(String[] args) throws InterruptedException {
        Runnable anonTask = new Runnable(){
            @Override
            public void run(){
                System.out.println("Anonymous Runnable executing...");
            }
        };

        //One-statement Lambda
        Runnable simpleLambda = () -> System.out.println("Simple lambda Runnable executing...");

        //Multi-statement Lambda
        Runnable multiLambda = () -> {
                System.out.println("multi-statement lambda: step 1");
                System.out.println("multi-statement lambda: step 2");
        };

        Thread t1 = new Thread(anonTask);
        Thread t2 = new Thread(simpleLambda);
        Thread t3 = new Thread(multiLambda);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
