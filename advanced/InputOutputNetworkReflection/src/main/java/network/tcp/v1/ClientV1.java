package network.tcp.v1;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class ClientV1 {

    public static final int PORT = 12345; // 서버

    public static void main(String[] args) throws IOException {
        log("Client Start");

        Socket socket = new Socket("localhost", PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String toSend = "Hello";
        output.writeUTF(toSend);

        log("client > server " + toSend);

        String received = input.readUTF();
        log("server > client " + received);

        input.close();
        output.close();
        socket.close();

    }
}
