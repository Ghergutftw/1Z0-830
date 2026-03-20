import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBufferWithLock {

    private int data;
    private boolean hasData = false;

    // The Lock acts as a "talking stick"—only one thread can hold it at a time.
    private final Lock lock = new ReentrantLock();

    // The Condition allows threads to "park" and wait for a specific state change.
    private final Condition condition = lock.newCondition();

    public void produce(int i) {
        // 1. Acquire the lock before touching any shared data.
        lock.lock();
        try {
            // 2. Use a 'while' loop to check the condition.
            // This handles "spurious wakeups" where a thread wakes up for no reason.
            while (hasData) {
                // 3. await() temporarily releases the lock so the Consumer can run.
                // The Producer thread sleeps here until signaled.
                condition.await();
            }

            // 4. Critical Section: Update the shared data.
            data = i;
            System.out.println(Thread.currentThread().getName() + " produced value=" + data);
            hasData = true;

            // 5. Signal the Consumer that new data is available.
            condition.signal();

        } catch (InterruptedException e) {
            // Restore the interrupted status if the thread was stopped while waiting.
            Thread.currentThread().interrupt();
        } finally {
            // 6. ALWAYS unlock in a finally block to ensure the lock is released
            // even if an exception occurs.
            lock.unlock();
        }
    }

    public void consume() {
        // 1. Acquire the lock.
        lock.lock();
        try {
            // 2. If there is no data, the Consumer must wait.
            while (!hasData) {
                // 3. Release lock and wait for the Producer to call signal().
                condition.await();
            }

            // 4. Critical Section: Read and "clear" the data.
            System.out.println(Thread.currentThread().getName() + " consumed value=" + data);
            hasData = false;

            // 5. Signal the Producer that the buffer is now empty.
            condition.signal();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // 6. Ensure the lock is released so other threads can enter.
            lock.unlock();
        }
    }
}
