public class ThreadSafeCounter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " incremeneted the counter : " + counter);
    }

    public int getCounter() {
        return counter;
    }

}
