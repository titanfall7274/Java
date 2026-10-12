package was.v4;

import java.io.*;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;
import static util.MyLogger.log;

public class HttpRequestHandlerV4 implements Runnable {

    private final Socket socket;

    public HttpRequestHandlerV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            process(socket);
        } catch (IOException e) {
            log(e);
        }
    }

    private void process(Socket socket) throws IOException {
        try (socket;
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), UTF_8))
        ) {
            HttpRequest request = new HttpRequest(reader);
            HttpResponse response = new HttpResponse(writer);

            if (request.getPath().equals("/favicon.ico")) {
                log("favicon 요청");
                return;
            }

            log("HTTP 요청 정보 출력");
            System.out.println(request);

            if (request.getPath().equals("/site1")) {
                site1(response);
            } else if (request.getPath().equals("/site2")) {
                site2(response);
            } else if (request.getPath().equals("/search")) {
                search(response, request);
            } else if (request.getPath().equals("/")) {
                home(response);
            } else {
                notFound(response);
            }
        }
    }

    private void notFound(HttpResponse response) {
        response.setStatusCode(404);
        response.writeBody("<h1>404 페이지를 찾을 수 없습니다.</h1>");
    }

    private void home(HttpResponse response) {
        response.writeBody("<h1>home</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href='/site1'>site1</a></li>");
        response.writeBody("<li><a href='/site2'>site2</a></li>");
        response.writeBody("<li><a href='/search?q=hello'>검색</a></li>");
        response.writeBody("</ul>");
    }

    private void search(HttpResponse response, HttpRequest request) {

        // request.getPath().equals("/search"); 만으로 호출되기 때문에
        // ? 뒤의 q=hello는 저장된 해시맵에서 hashmap.get(name) api를 사용해 가져와야한다.
        String query = request.getParameters("q");// q, hello 방식으로 저장된 맵

        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }

    private void site2(HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }

    private void site1(HttpResponse response) {
        response.writeBody("<h1>site1</h1>");
    }
}
