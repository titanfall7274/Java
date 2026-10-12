package was.v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.*;
import static util.MyLogger.log;

public class HttpServerV1 {

    private final int port;

    public HttpServerV1(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        log("서버 시작 port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            process(socket);
        }
    }

    private void process(Socket socket) {
        try (socket;
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8)
        ) {
            /*
            GET / HTTP/1.1\n
            Host: localhost:12345\n
            Connection: keep-alive\n
            User-Agent: Mozilla/5.0 ...\n
            Accept: text/html,...\n
            ...
            */

            String requestString = requestToString(reader);

            if (requestString.contains("/favicon.ico")) {
                log("favicon 요청");
                return;
            }

            log("HTTP 요청 정보 출력");
            System.out.println(requestString);

            log("HTTP 응답 생성중...");
            sleep(5000);

            responseToClient(writer);
            log("HTTP 응답 전달 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void responseToClient(PrintWriter writer) {
        // 웹 브라우저에 전달하는 내용

        String body = "<h1>Hello World</h1>";
        int length = body.getBytes(UTF_8).length;

        StringBuilder sb = new StringBuilder();
        // header
        sb.append("HTTP/1.1 200 OK\r\n");
        sb.append("Content-Type: text/html; charset: utf-8\r\n");
        sb.append("Content-Length: ").append(length).append("\r\n");

        sb.append("\r\n");

        sb.append(body); // "<h1>Hello World</h1>"

        log("HTTP 응답 정보 출력");
        System.out.println(sb);

        writer.println(sb);
        writer.flush();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String requestToString(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();

        String line;
        // 클라이언트가 소켓 출력을 닫아 스트림이 끝난 EOF
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break; // 정상 경로. 헤더를 다 읽고 빈 줄을 만났을 경우
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
