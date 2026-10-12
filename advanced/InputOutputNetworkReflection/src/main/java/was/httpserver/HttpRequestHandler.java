package was.httpserver;

import java.io.*;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;
import static util.MyLogger.log;

public class HttpRequestHandler implements Runnable {

    private final Socket socket;
    private final ServletManager servletManager;

    public HttpRequestHandler(Socket socket, ServletManager servletManager) {
        this.socket = socket;
        this.servletManager = servletManager;
    }

    @Override
    public void run() {
        try {
            process(socket);
        } catch (IOException e) {
            log(e);
            e.printStackTrace();
        }
    }

    private void process(Socket socket) throws IOException {
        try (socket;
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), UTF_8))
        ) {
            HttpRequest request = new HttpRequest(reader);
            HttpResponse response = new HttpResponse(writer);

            log("HTTP 요청: " + request);
            servletManager.execute(request, response);
            response.flush();
            log("HTTP 응답 완료");
        }
    }
}
