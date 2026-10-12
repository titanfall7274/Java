package was.v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;

import static java.nio.charset.StandardCharsets.UTF_8;
import static util.MyLogger.log;

public class HttpRequestHandlerV3 implements Runnable {

    private final Socket socket;
    public HttpRequestHandlerV3(Socket socket) {
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
            if (requestString.contains("/favicon.ico")) {
                log("favicon 요청");
                return;
            }
            log("HTTP 요청 정보 출력");
            System.out.println(requestString);
            log("HTTP 응답 생성중...");

            if (requestString.startsWith("GET /site1")) {
                site1(writer);
            } else if (requestString.startsWith("GET /site2")) {
                site2(writer);
            } else if (requestString.startsWith("GET /search")) {
                search(writer, requestString);
            } else if (requestString.startsWith("GET / ")) {
                home(writer);
            } else {
                notFound(writer);
            }

            log("HTTP 응답 전달 완료");

            responseToClient(writer);
        }
    }

    private void site1(PrintWriter writer) {
        // header
        writer.println("HTTP/1.1 200 OK\r\n");
        writer.println("Content-Type: text/html; encoding: utf-8;\r\n");

        writer.println();

        // body
        writer.println("<h1>site1</h1>");
        writer.flush();
    }

    private void site2(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK\r\n");
        writer.println("Content-Type: text/html; encoding: utf-8;\r\n");

        writer.println();

        writer.println("<h1>site2</h1>");
        writer.flush();
    }

    private void search(PrintWriter writer, String requestString) {

        // GET /search?q=hello
        int startIndex = requestString.indexOf("q=");
        System.out.println("startIndex = " + startIndex); // startIndex = 12
        int endIndex = requestString.indexOf(" ", startIndex + 2); // q= 을 건너뛰고
        System.out.println("endIndex = " + endIndex); // endIndex = 19
        String query = requestString.substring(startIndex + 2, endIndex); // hello / 한글의 경우 퍼센트 인코딩된 형태
        String decode = URLDecoder.decode(query, UTF_8); // hello

        writer.println("HTTP/1.1 200 OK\r\n");
        writer.println("Content-Type: text/html; encoding: utf-8;\r\n");

        writer.println();

        writer.println("<h1>Search</h1>");
        writer.println("<ul>");
        writer.println("<li>query: " + query + "</li>");
        writer.println("<li>decode: " + decode + "</li>");
        writer.println("</ul>");

        writer.flush();
    }

    private void home(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK\r\n");
        writer.println("Content-Type: text/html; encoding: utf-8;\r\n");

        writer.println();

        writer.println("<h1>home</h1>");
        writer.println("<ul>");
        writer.println("<li><a href = '/site1'>site1</a></li>");
        writer.println("<li><a href = '/site2'>site2</a></li>");
        writer.println("<li><a href = '/search?q=hello'>검색</a></li>");
        writer.println("</li>");
        writer.println("</ul>");

        writer.flush();
    }

    private void notFound(PrintWriter writer) {
        writer.println("HTTP/1.1 404 NOT FOUND\r\n");
        writer.println("Content-Type: text/html; encoding: utf-8;\r\n");

        writer.println();

        writer.println("<h1>404 페이지를 찾을 수 없습니다.</h1>");
        writer.flush();
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
