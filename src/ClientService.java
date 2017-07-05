import commands.Command;
import commands.CommandFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Scott Davey on 05/07/2017.
 */
public class ClientService implements Runnable {
    private Socket socket;
    private Scanner input;
    private BufferedWriter output;

    //temporary, authentication should be replicated properly
    private static final String PASSWORD = "super123";

    public ClientService(Socket socket) throws IOException {
        this.socket = socket;
        try {
            input = new Scanner(socket.getInputStream(), "utf-8");
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        sendSingleMessage("### Battlefield Heroes ModManager Rcon v8.5.\n");
        sendSingleMessage("### Digest seed: HSiaFbygLStjipmv\n");
    }

    public void run() {
        while(true) {
            String reply = input.nextLine();
            Command command = CommandFactory.GetCommand(reply);
            try {
                sendSingleMessage(command.handle());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendSingleMessage(String message) throws IOException {
        output.write(message);
        output.flush();
    }
}
