package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV1 {

    public static final int PORT = 12345; // 서버

    public static void main(String[] args) throws IOException {
        log("Server Start");

        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();
        log("소켓 연결 " + socket);

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        DataInputStream input = new DataInputStream(socket.getInputStream());

        String received = input.readUTF();
        log("client > server " + received);

        String toSend = received + " World!";
        output.writeUTF(toSend);

        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}
