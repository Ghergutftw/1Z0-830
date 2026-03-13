package syncronized;

public class Counter {

    private int count = 0;

    public void increment() {
        //Not an atomic operation , so it can interfer with Threads
        count++;
    }

    synchronized public void incrementSync() {
        //Not an atomic operation
        count++;
    }

    public int getCount() {
        return count;
    }
}
