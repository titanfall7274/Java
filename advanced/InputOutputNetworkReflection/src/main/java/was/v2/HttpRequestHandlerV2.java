package was.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.*;
import static util.MyLogger.log;

public class HttpRequestHandlerV2 implements Runnable {

    private final Socket socket;

    public HttpRequestHandlerV2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
            log(e);
        }
    }

    private void process() throws IOException {
        try (socket;
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8)
        ) {
            String requestString = requestToString(reader);
            if (requestString.equals("/favicon.ico")) {
                log("favicon 요청");
                return;
            }

            System.out.println(requestString);

            sleep(5000);
            responseToClient(writer);
        }
    }

    private void responseToClient(PrintWriter writer) {
        StringBuilder sb = new StringBuilder();

        String body = "<h1>Hello World</h1>";
        int length = body.getBytes(UTF_8).length;

        sb.append("HTTP/1.1 200 OK\r\n");
        sb.append("Content-Type: text/html; encoding: utf-8;\r\n");
        sb.append("Content-Length: ").append(length).append("\r\n");
        sb.append("\r\n"); // header, body 구분 라인
        sb.append(body);

        writer.println(sb);
        writer.flush();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String requestToString(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }

            sb.append(line).append("\n");
        }

        return sb.toString();
    }
}
