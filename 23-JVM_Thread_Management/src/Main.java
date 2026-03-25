public class Main {
    public static void main(String[] args) {
        demonThread();
    }

    static void threadLifecycle() {
        Thread thread1 = new Thread(new CustomTask(), "Thread-1");
        Thread thread2 = new Thread(new CustomTask(), "Thread-2");
        Thread thread3 = new Thread(new CustomTask(), "Thread-3");

        System.out.println("Thread-1 State before start: " + thread1.getState());
        System.out.println("Thread-2 State before start: " + thread2.getState());
        System.out.println("Thread-3 State before start: " + thread3.getState());


        thread1.start();
        thread2.start();
        thread3.start();

        //give time to terminate a task
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread-1 State after start: " + thread1.getState());
        System.out.println("Thread-2 State after start: " + thread2.getState());
        System.out.println("Thread-3 State after start: " + thread3.getState());

    }

    static void threadPriority(){
        Thread highPriorityThread = new Thread(()->{
            for (int i = 1; i <= 5; i++){
                System.out.println("High-priority thread: " + i);
            }
        }, "High Priority Thread");

        Thread mediumPriorityThread = new Thread(()->{
            for (int i = 1; i <= 5; i++){
                System.out.println("Medium-priority thread: " + i);
            }
        }, "Medium Priority Thread");

        Thread lowPriorityThread = new Thread(()->{
            for (int i = 1; i <= 5; i++){
                System.out.println("Low-priority thread: " + i);
            }
        }, "Low Priority Thread");

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        mediumPriorityThread.setPriority(Thread.NORM_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        mediumPriorityThread.start();
        lowPriorityThread.start();
    }

    static void demonThread(){
        Thread userThread = new Thread(()->{

            for (int i = 1; i <= 5; i++){
                System.out.println("User Thread: " + i);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        },"UserThread");

        Thread daemonThread = new Thread(()->{

            while (true){
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        },"DaemonThread");

        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

    }
}
