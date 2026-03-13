package syncronized;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        firstThread.start();
        secondThread.start();

        try {
            //Waits for each thread to finish
            firstThread.join();
            secondThread.join();

            System.out.println("Counter: " + counter.getCount());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
