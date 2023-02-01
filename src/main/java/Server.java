import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String userName;
        String isChild;
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port);
        ) {
            System.out.print("Server started\n\n");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    Messenger messenger = new Messenger("Server", "User", out, in);
                    System.out.print("Connection accepted by port: " + clientSocket.getPort() + "\n\n");
                    messenger.getMessage();
                    messenger.sendMessage("Write your name");
                    userName = messenger.getMessage();
                    messenger.setAnotherSide(userName);
                    messenger.sendMessage("Are you child? (yes/no)");
                    isChild = messenger.getMessage();
                    if (isChild.toLowerCase().equals("yes")) {
                        messenger.sendMessage("Welcome to the kids area, " + userName + "! Let's play!");
                    }
                    if (isChild.toLowerCase().equals("no")) {
                        messenger.sendMessage("Welcome to the adult zone, " + userName + "! Have a good rest, or a good working day!");
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
