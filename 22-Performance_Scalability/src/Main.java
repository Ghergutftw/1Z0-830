import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static final ReentrantLock lock = new ReentrantLock();
    static int counter = 0;

    public static void main(String[] args) {
        immutability();

    }

    static void concurrencyWithLock(){

        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    System.out.println("Thread " + Thread.currentThread().getName() + " is incrementing the counter");
                    counter++;
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(counter);
                    System.out.println("Thread " + Thread.currentThread().getName() + " is releasing the lock");
                    lock.unlock();
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
    }

    static void deadLock(){
        final ReentrantLock lock1 = new ReentrantLock();
        final ReentrantLock lock2 = new ReentrantLock();

        Runnable r1 = () -> {
            lock1.lock();
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " got first lock, waiting for second lock");
                Thread.sleep(100L);
                lock2.lock();
                try {
                    System.out.println("Thread " + Thread.currentThread().getName() + " got second lock");
                }finally {
                    lock2.unlock();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock1.unlock();
            }
        };

        Runnable r2 = () -> {
            lock2.lock();
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " got second lock , waiting for first lock");
                Thread.sleep(100L);
                lock1.lock();
                try {
                    System.out.println("Thread " + Thread.currentThread().getName() + " got first lock");
                }finally {
                    lock1.unlock();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock2.unlock();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

    static void threadSafeness(){
        ThreadSafeCounter counter1 = new ThreadSafeCounter();
        Runnable task = counter1::increment;

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }

    static void immutability(){
        Person person = new Person("Alice", 39);
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + ": " + person);
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }

}
