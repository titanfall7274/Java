package network.exception.close;

import java.io.*;
import java.net.Socket;

import static util.MyLogger.log;

public class NormalClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결");

        InputStream input = socket.getInputStream();

        log("read() 호출 > server 의 FIN 패킷이 올 때까지 블로킹");
        readByInputStream(input, socket);
//        readByBufferedReader(input, socket);
//        readByDataInputStream(input, socket);

        log("client: socket.close() 호출 완료: " + socket.isClosed());
        log("server OS > client 로 온 FIN 패킷에 대해 ACK 패킷을 전달한다. (OS 가 처리, 코드로는 확인 불가)");
    }

    private static void readByDataInputStream(InputStream input, Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(input);

        try {
            dis.readUTF();
        } catch (EOFException e) {
            log(e);
            log("server > client FIN 패킷을 전달받음 (readUTF() 가 EOFException)");
            log("client OS: FIN 에 대한 ACK 패킷 전달 (이미 완료)");
        } finally {
            log("client: socket.close() 호출 > server 로 FIN 패킷 전달");
            dis.close();
            socket.close();
        }
    }

    private static void readByBufferedReader(InputStream input, Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String readString = br.readLine();

        if(readString == null) {
            log("server > client FIN 패킷을 전달받음 (readLine() 이 null)");
            log("client OS: FIN 에 대한 ACK 패킷 전달 (이미 완료)");
            log("client: socket.close() 호출 > server 로 FIN 패킷 전달");
            br.close();
            socket.close();
        }
    }

    private static void readByInputStream(InputStream input, Socket socket) throws IOException {
        int read = input.read();
        log("read = " + read);

        if(read == -1) {
            log("server > client FIN 패킷을 전달받음 (read() 가 -1)");
            log("client OS: FIN 에 대한 ACK 패킷 전달 (이미 완료)");
            log("client: socket.close() 호출 > server 로 FIN 패킷 전달");
            input.close();
            socket.close();
        }
    }
}
