package network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class SessionV3 implements Runnable {

    private final Socket socket;

    public SessionV3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            while (true) {
                String received = input.readUTF();
                log("clent > server " + received);
                if(received.equals("exit")) break;

                String toSend = received + " World!";
                output.writeUTF(toSend);
                log("client < server " + toSend);
            }

            scanner.close();
            output.close();
            input.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
