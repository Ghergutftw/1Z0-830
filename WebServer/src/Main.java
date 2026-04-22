public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebServer server = new WebServer(8080);
        Thread serverThread = new Thread(server::startServer);
        serverThread.start();;
        serverThread.join();
    }
}
