package syncronized;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                if (i == 250) {
                    counter.running = false;
                }
                counter.incrementSync();
            }
        });
        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementSync();
            }
        });

        firstThread.start();
        secondThread.start();

        try {
            // Waits for each thread to finish
            firstThread.join();
            secondThread.join();

            System.out.println("Counter: " + counter.getCount());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
