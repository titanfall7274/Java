package chat2.client;

import java.io.*;
import java.net.Socket;

import static util.MyLogger.log;

public class Client {

    private String host;
    private int port;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private ReadHandler readHandler;
    private WriteHandler writeHandler;

    public Client(String host, int port) throws IOException {
        this.host = host;
        this.port = port;

    }

    public void start() throws IOException {
        socket = new Socket(host, port);
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

        readHandler = new ReadHandler(in, this);
        writeHandler = new WriteHandler(out, this);

        Thread readThread = new Thread(readHandler, "readHandler");
        Thread writeThread = new Thread(writeHandler, "writeThread");
        writeThread.setDaemon(true); // JVM이 기다리지 않도록 하기
        readThread.start();
        writeThread.start();
    }

    public void close() {

        readHandler.close();
        writeHandler.close();

        try {
            out.close();
        } catch (IOException e) {
            log(e);
        }

        try {
            in.close();
        } catch (IOException e) {
            log(e);
        }

        try {
            socket.close();
        } catch (IOException e) {
            log(e);
        }
    }
}
