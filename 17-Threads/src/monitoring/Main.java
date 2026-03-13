package monitoring;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("Before start: " + myThread.getState());
        myThread.start();
        System.out.println("After start: " + myThread.getState());

    }
}
