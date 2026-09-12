package network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV3 {

    public static final int PORT = 12345; // 서버

    public static void main(String[] args) throws IOException {
        log("Client Start");

        Socket socket = new Socket("localhost", PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String toSend = scanner.nextLine();
            log("client > server " + toSend);
            output.writeUTF(toSend);
            if(toSend.equals("exit")) {
                break;
            }

            String received = input.readUTF();
            log("client < server " + received);
        }
        input.close();
        output.close();
        socket.close();
    }
}
