package network.tcp.v4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class SesisonV4 implements Runnable {

    private Socket socket;

    public SesisonV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataOutputStream output = null;
        DataInputStream input = null;

        try {
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);

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
        } finally {
            closeAll(socket, input, output);
            log("연결 종료: " + socket);
        }

    }
}
