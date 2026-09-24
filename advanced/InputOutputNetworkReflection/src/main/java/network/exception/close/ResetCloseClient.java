package network.exception.close;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static util.MyLogger.log;

public class ResetCloseClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);

        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        /*
        output.close();
        input.close();
        socket.close();
*/
        // client <- server: FIN
        Thread.sleep(1000); // server가 close() 호출할 때 까지 잠시 대기

        // client -> server: PUSH[1]
        output.write(1);

        // client <- server: RST
        Thread.sleep(1000); // RST 메시지 전송 대기

        // client 가 RST를 받은 상태 (더이상 메시지를 주고받을수 없음)
        // MAC: ECONNRESET: Connection reset
        // WIN: WSAECONNABORTED(10053) : 현재 연결은 사용자의 호스트 시스템의 소프트웨어의 의해 중단되었습니다
        try {
            int read = input.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // 근데 만약 사용자가 연결이 끊긴 상태에서 다시 보낼경우
        // MAC: Broken pipe
        // WIN: 현재 연결은 사용자의 호스트 시스템의 소프트웨어의 의해 중단되었습니다
        try {
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
