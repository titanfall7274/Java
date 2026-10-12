package was.v4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

import static util.MyLogger.log;

public class HttpServerV4 {

    /*
    new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    */
    private ExecutorService es = Executors.newFixedThreadPool(10);
    private final int port;

    public HttpServerV4(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("서버 시작 port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            es.submit(new HttpRequestHandlerV4(socket));
        }
    }
}
