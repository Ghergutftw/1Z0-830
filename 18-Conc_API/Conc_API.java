import java.util.concurrent.ExecutorService; // used for managing thread pools
import java.util.concurrent.Executors;
import java.util.concurrent.Executor; //Factory that creates ThreadPools
import java.util.concurrent.TimeUnit; //Used for time conversion when shutting down the executor

public class Conc_API {
    public static void main(String[] args) {

    }

    static void executorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task " + i);
            executorService.submit(task);
        }
        executorService.shutdown();
        System.out.println("All task submitted");

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Executor Serice Finished");
    }
}