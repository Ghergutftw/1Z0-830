import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Main{
    public static void main(String[] args) {
        blockingQueue();
    }

    static void threadSafeList(){
        //Thread safe list
        List<String> orderList = new CopyOnWriteArrayList<>();
        Thread t1 = new Thread(() -> addOrder(orderList, "Order 1"));
        Thread t2 = new Thread(() -> addOrder(orderList, "Order 2"));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final order list: " + orderList);
    }

    static void blockingQueue(){
        //Block if its full, wait if its empty
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);

        Thread producer = new Thread(() -> produce(queue));
        Thread consumer = new Thread(() -> consume(queue));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void addOrder(List<String>orderList , String order){
        orderList.add(order);
        Random rand = new Random();
        if(rand.nextBoolean()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " added : " + order);
    }

    static void produce(BlockingQueue<String> queue){
        for (int i = 0; i < 6; i++) {
            queue.offer(String.valueOf(i));
            System.out.println("Produced : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void consume(BlockingQueue<String> queue){
        for (int i = 0; i < 6; i++) {
            int value = 0;
            try {
                value = Integer.parseInt(queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumed : " + value);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
