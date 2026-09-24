package network.exception.close;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class normalCloseServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        log("소켓 연결 " + socket);

        Thread.sleep(1000);
        socket.close();
        log("server: socket.close() 호출 > client 로 FIN 패킷 전달");

        log("client OS > server 로 온 FIN 패킷에 대해 ACK 패킷을 전달한다.");
        log("client: read() 가 -1 을 반환하면 socket.close() 호출 > server 로 FIN 패킷 전달");
        log("server OS > client 의 FIN 패킷에 대해 ACK 패킷을 전달한다. (OS 가 처리, 코드로는 확인 불가)");
    }
}
