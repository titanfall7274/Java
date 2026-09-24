package network.tcp.v5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class SesisonV5 implements Runnable {

    private final Socket socket;

    public SesisonV5(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (socket;
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in);) {

            while (true) {
                String received = null;
                received = input.readUTF(); // EOFException
                log("clent > server " + received);
                if (received.equals("exit")) break;

                String toSend = received + " World!";
                output.writeUTF(toSend);
                log("client < server " + toSend);
            }
        } catch (IOException e) {
            log(e);
        }

        log("연결 정료: " + socket + " isClosed: " + socket.isClosed());
    }
}
