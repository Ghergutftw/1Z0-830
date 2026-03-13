class MyThread extends Thread {
    int id;
    public MyThread(int id) { super("Extends-Thread-" + id); this.id = id; }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("[" + name + "] is running (ID: " + id + ")");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("[" + name + "] finished sleep.");
    }
}
