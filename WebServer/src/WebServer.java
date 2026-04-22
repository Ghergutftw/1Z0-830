import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {

    private final int port;

    public WebServer(int port) {
        this.port = port;
    }

    public void startServer(){
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        try(ServerSocket serverSocket =  new ServerSocket(port)) {
            System.out.println("Running on port  " + port);
            while (true){
                Socket clientSocket = serverSocket.accept();
                threadPool.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
