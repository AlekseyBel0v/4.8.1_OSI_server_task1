import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Messenger {
    private final String mySide;

    public void setAnotherSide(String anotherSide) {
        this.anotherSide = anotherSide;
    }

    private String anotherSide;
    private final PrintWriter out;
    private final BufferedReader in;

    public Messenger(String mySide, String anotherSide, PrintWriter out, BufferedReader in) {
        this.mySide = mySide;
        this.anotherSide = anotherSide;
        this.out = out;
        this.in = in;
    }

    void sendMessage(String answer) {
        out.println(answer);
        out.flush();
        System.out.print(mySide + ": " + answer + "\n\n");
    }

    String getMessage() throws IOException {
        String message = in.readLine();
        System.out.print(anotherSide + ": " + message + "\n\n");
        return message;
    }
}
