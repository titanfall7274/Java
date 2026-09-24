package network.tcp.v4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class ClientV4 {

    public static final int PORT = 12345; // 서버

    public static void main(String[] args) throws IOException {
        log("Client Start");

        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;
        Scanner scanner = null;
        try {
            socket = new Socket("localhost", PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

             scanner = new Scanner(System.in);

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
        } catch(IOException e) {
            log(e);
        } finally {
            scanner.close();
            closeAll(socket, input, output);
            log("연결 종료. " + socket);
        }

    }
}
