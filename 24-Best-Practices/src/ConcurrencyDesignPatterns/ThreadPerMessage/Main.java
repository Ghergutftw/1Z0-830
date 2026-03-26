package ConcurrencyDesignPatterns.ThreadPerMessage;

public class Main {
    public static void main(String[] args) {
        String[] messages = {"Message 1", "Message 2", "Message 3", "Message 4", "Message 5"};

        for (String message : messages){
            Thread thread = new Thread(new PrintRequestHandler(message), "Thread for Processing " + message);
            thread.start();
//            System.out.println(Thread.getAllStackTraces());
        }
    }
}
