package ConcurrencyDesignPatterns.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            int number = (int) (Math.random() * 100);
            System.out.println("Produced : " + number);
            try {
                queue.put(number);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
