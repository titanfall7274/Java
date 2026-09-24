package chat.client.handler;

import chat.client.Client;

import java.io.DataInputStream;
import java.io.IOException;

import static util.MyLogger.log;

public class ReadHandler implements Runnable {

    private final DataInputStream input;
    private final Client client;
    public boolean closed = false;

    public ReadHandler(DataInputStream input, Client client) {
        this.input = input;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF(); // EOFException
                log(received);
            }
        } catch (IOException e) {
            log(e);
        } finally {

            client.close();
        }
    }

    // 동시 호출 가능성이 있음
    public synchronized void close() {
        if (closed) {
            return;
        }

        closed = true;
        log("readHandler 종료");

    }
}
