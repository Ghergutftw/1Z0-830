public class SharedBuffer {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) {
        // 1. Wait while the buffer is full
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 2. Perform the action (Move this OUTSIDE the while block)
        data = value;
        System.out.println(Thread.currentThread().getName() + " produced value=" + value);
        hasData = true;

        // 3. Notify the consumer
        notify();
    }

    public synchronized void consume() {
        // 1. Wait while the buffer is empty
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 2. Perform the action (Move this OUTSIDE the while block)
        System.out.println(Thread.currentThread().getName() + " consumed value=" + data);
        hasData = false;

        // 3. Notify the producer
        notify();
    }
}
