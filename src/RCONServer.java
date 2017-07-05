import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Scott Davey on 05/07/2017.
 */
public class RCONServer {
    public static final int PORT = 4711;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Started BFH RCON Server at port " + PORT);
        System.out.println("Waiting for clients to connect...");
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress().toString());
            ClientService service = new ClientService(socket);
            new Thread(service).start();
        }
    }
}

