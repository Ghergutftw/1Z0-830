public class Main {
    public static void main(String[] args) {
        SharedBufferWithLock sharedBuffer = new SharedBufferWithLock();

        Thread producerThread = new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                sharedBuffer.produce(i);
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        },"Producer Thread");

        Thread consumerThread = new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                sharedBuffer.consume();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Consumer Thread");

        producerThread.start();
        consumerThread.start();

    }
}
