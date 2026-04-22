import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task1 = () ->{
            lock1.lock();
            System.out.println("Thread 1 acquired lock1");
            try {
                Thread.sleep(500);
                lock2.lock();
                System.out.println("Thread 1 acquired lock2");
                Thread.sleep(500);
                lock2.unlock();
                lock1.unlock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable task2 = () ->{

            try {
                lock1.lock();
                System.out.println("Thread 2 acquired lock1");
                Thread.sleep(500);
                lock2.lock();
                System.out.println("Thread 2 acquired lock2");
                Thread.sleep(500);
                lock2.unlock();
                lock1.unlock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread1 = new Thread(task1, "Thread 1");
        Thread thread2 = new Thread(task2, "Thread 2");
        thread1.start();
        thread2.start();

    }

}
