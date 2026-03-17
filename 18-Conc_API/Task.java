public class Task implements Runnable {

    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskName + " is starting on thread : " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Task " + taskName + " is completed on thread : " + Thread.currentThread().getName());
    }
}
