package chat2.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static util.MyLogger.log;

public class WriteHandler implements Runnable {

    private final DataOutputStream out;
    private final Client client;

    private boolean closed;

    public WriteHandler(DataOutputStream out, Client client) {
        this.out = out;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                String inputMessage = scanner.nextLine(); // NoSuchElementException e
                out.writeUTF(inputMessage);
                out.flush();
            }
        } catch (IOException | NoSuchElementException ex) {
            log(ex);
        } finally {
            client.close();
        }
    }

    public void close() {
        if (closed) {
            return;
        }

        closed = true;
    }
}
