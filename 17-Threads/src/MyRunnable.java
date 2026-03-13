class MyRunnable implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("[" + name + "] is executing the Runnable task...");
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        System.out.println("[" + name + "] Runnable task COMPLETE.");
    }
}
