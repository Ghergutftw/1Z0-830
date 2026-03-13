public class Main {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println("[" + name + "] Starting the engine...");

        MyThread thread1 = new MyThread(1);
        MyThread thread2 = new MyThread(2);
        MyRunnable runnableJob = new MyRunnable();

        // 1. Start parallel workers
        thread1.start();
        thread2.start();

        // 2. Start a worker specifically for the Runnable
        Thread thread3 = new Thread(runnableJob, "Parallel-Runnable-Worker");
        thread3.start();

        // 3. The Main thread "hijacks" the runnable job directly
        System.out.println("[" + name + "] About to run runnableJob.run() manually...");
        runnableJob.run();

        System.out.println("[" + name + "] Finally reached the end of main().");
    }
}

