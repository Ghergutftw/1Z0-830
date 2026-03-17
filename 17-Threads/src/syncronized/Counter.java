package syncronized;

public class Counter {

    // volatile
    volatile boolean running = true;
    private int count = 0;

    public void increment() {
        // Not an atomic operation , so it can interfer with Threads
        count++;
    }

    synchronized public void incrementSync() {
        if (running) {
            // Not an atomic operation, dar deoarece avem syncronized ,
            // aceasta functie este folosita ca un semafor
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public void stopRunning() {
        running = false;
    }

    public void run() {
        while (running) {
            System.out.println("Thread is running");
        }
        System.out.println("Thread has stopped");
    }
}
