package network.exception;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketTimeoutClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        InputStream inputStream = socket.getInputStream();

        try {
            socket.setSoTimeout(3000); // 타임아웃 설정
            int read = inputStream.read();
            System.out.println("read = " + read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
