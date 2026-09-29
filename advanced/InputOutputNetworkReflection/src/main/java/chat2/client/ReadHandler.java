package chat2.client;

import java.io.DataInputStream;
import java.io.IOException;

import static util.MyLogger.log;

public class ReadHandler implements Runnable {

    private final DataInputStream in;
    private Client client;

    private boolean closed;

    public ReadHandler(DataInputStream in, Client client) {
        this.in = in;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String inputMessage = in.readUTF(); // connection reset
                System.out.println("client < server: " + inputMessage);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    public void close() {
        if (closed) {
            return;
        }

        closed = true;
        try {
            in.close();
        } catch (IOException e) {
            log(e);
        }
    }
}
