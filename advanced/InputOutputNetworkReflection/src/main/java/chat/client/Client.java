package chat.client;

import chat.client.handler.ReadHandler;
import chat.client.handler.WriteHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class Client {

    private final String host;
    private final int port;

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream outupt;

    private ReadHandler readHandler;
    private WriteHandler writeHandler;
    private boolean closed = false;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        log("client 시작");

        socket = new Socket(host, port);
        input = new DataInputStream(socket.getInputStream());
        outupt = new DataOutputStream(socket.getOutputStream());

        readHandler = new ReadHandler(input, this);
        Thread readThread = new Thread(readHandler, "readHandler");

        writeHandler = new WriteHandler(outupt, this);
        Thread writeThread = new Thread(writeHandler, "writeHandler");

        readThread.start();
        writeThread.start();
    }

    public synchronized void close() {
        if(closed) {
            return;
        }

        writeHandler.close();
        readHandler.close();

        closeAll(socket, input, outupt);
        /*outupt.close();
        input.close();
        socket.close();*/

        closed = true;
        log("client: 연결 종료 " + socket);
    }
}
