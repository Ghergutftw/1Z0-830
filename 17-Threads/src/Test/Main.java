package Test;

class SharedData {
    int value = 5;
}
//Pass by value
//public class Main {
//    public static void main(String[] args) {
//        Integer x = 5;
//        for (int i = 0; i < 10; i++) {
//            TestRunnable  runnable = new TestRunnable(i,x);
//            Thread thread = new Thread(runnable);
//            thread.start();
//        }
//        System.out.println("Main" + x);
//    }
//}

//Pass by ref
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedData shared = new SharedData(); // Obiect unic în Heap

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new TestRunnable(shared));
            t.start();
        }

        // Așteptăm un pic să termine thread-urile (pentru demo) , ca sa aibe timp Threadurile sa se termine
        Thread.sleep(1000);

        System.out.println("Main vede acum: " + shared.value);
    }
}
