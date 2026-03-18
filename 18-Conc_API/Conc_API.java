import java.util.Map;
import java.util.concurrent.*;

public class Conc_API {
    public static void main(String[] args) {
        concurentCollection();
    }

    static void executorService() {
        //Executor Service este manager, Executors este echipa, 3 sunt sefi
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            Task task = new Task("Task " + i);
            //Creaza comenzi si le trimite la manager
            executorService.submit(task);
        }
        //Managerul nu mai accepte commenzi
        executorService.shutdown();
        System.out.println("All task submitted");

        try {
            //Await termination asteapta ca toate thread-urile sa se termine
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                //Daca dupa 60 de secunde nu e totul gata atunci inchide tot
                executorService.shutdownNow();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Executor Service Finished");
    }

    static void scheduledExecutorService() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        //sequencial
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 7; i++) {
            Task task = new Task("Task " + i);
            //Rulează acest task peste 5 secunde
            executorService.schedule(task, 5, TimeUnit.SECONDS);
        }


        //astepta o secunda si incepe task-ul, dupa 1 secund, and run every 5 seconds, runs at 1 sec, din nou la 6, dupa 11 dupa la 16
        //executorService.scheduleAtFixedRate(new Task("Fixed Rate Task"), 2 ,5, TimeUnit.SECONDS);
        //Task Fixed Rate Task STARTED at 15:18:47 on thread: pool-1-thread-1
        //Task Fixed Rate Task COMPLETED at 15:18:49 on thread: pool-1-thread-1
        //Task Fixed Rate Task STARTED at 15:18:52 on thread: pool-1-thread-1
        //Task Fixed Rate Task COMPLETED at 15:18:54 on thread: pool-1-thread-1
        //Task Fixed Rate Task STARTED at 15:18:57 on thread: pool-1-thread-2
        //Task Fixed Rate Task COMPLETED at 15:18:59 on thread: pool-1-thread-2
        //Task Fixed Rate Task STARTED at 15:19:02 on thread: pool-1-thread-2
        //Task Fixed Rate Task COMPLETED at 15:19:04 on thread: pool-1-thread-2



        //incepe dupa un delay de 2 secunde, apoi dupa ce se termina task-ul curent, asteapta 5 secunde ,si incepe altul
        //executorService.scheduleWithFixedDelay(new Task("Fixed Delay Task"), 2 ,5, TimeUnit.SECONDS);
        //Task Fixed Delay Task STARTED at 15:17:10 on thread: pool-1-thread-1
        //Task Fixed Delay Task COMPLETED at 15:17:12 on thread: pool-1-thread-1
        //Task Fixed Delay Task STARTED at 15:17:17 on thread: pool-1-thread-1
        //Task Fixed Delay Task COMPLETED at 15:17:19 on thread: pool-1-thread-1
        //Task Fixed Delay Task STARTED at 15:17:24 on thread: pool-1-thread-2
        //Task Fixed Delay Task COMPLETED at 15:17:26 on thread: pool-1-thread-2

        try {
            //gives time for the tasks to execute
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //finished scheduled tasks ,and dont accept anymore
        executorService.shutdown();
        System.out.println("Scheduled Executor Service Finished");
    }

    static void concurentCollection(){
        Map<String, String> taskResult = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 6; i++) {
            String taskName = "Task " + i;
            //Clasa anonima care implementeaza Runnable, deoarece submit are nevoie de un runnable
            executorService.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " is executin " + taskName);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                taskResult.put(taskName, "Completed by " + threadName);
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        taskResult.forEach((s, s2) -> {
            System.out.println(s + " " + s2);
        });

    }
}
