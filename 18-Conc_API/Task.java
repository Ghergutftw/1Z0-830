import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task implements Runnable {
    private String taskName;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        // Marcăm începutul
        LocalTime startTime = LocalTime.now();
        System.out.println("Task " + taskName + " STARTED at " + startTime.format(formatter) +
                " on thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000); // Simulăm lucru timp de 2 secunde
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task interrupted: " + e.getMessage());
        }

        // Marcăm finalul
        LocalTime endTime = LocalTime.now();
        System.out.println("Task " + taskName + " COMPLETED at " + endTime.format(formatter) +
                " on thread: " + Thread.currentThread().getName());
    }
}
