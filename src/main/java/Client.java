import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException {
        int port = 8080;
        try (Socket clientSocket = new Socket("netology.homework", port); //запрос на соиденение
             PrintWriter out = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            Messenger messenger = new Messenger("Client", "Server", out, in);
            messenger.sendMessage("Привет, сервер!");
            messenger.getMessage();
            messenger.sendMessage("Igor");
            messenger.getMessage();
            messenger.sendMessage("no");
            messenger.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
