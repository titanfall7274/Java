package chat2.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class Server {

    private final int port;
    private final SessionManager sessionManager;
    private final CommandManager commandManager;

    private ServerSocket serverSocket;

    public Server(int port, SessionManager sessionManager, CommandManager commandManager) {
        this.port = port;
        this.sessionManager = sessionManager;
        this.commandManager = commandManager;
    }

    public void start() throws IOException {
        // listening serverSocket 생성
        System.out.println("서버 시작");
        serverSocket = new ServerSocket(port);

        addShutdownHook();
        running();
    }

    private void addShutdownHook() {
        ShutDownHook target = new ShutDownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(target, "shutdown"));
    }

    public void running(){

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                log("소켓 연결: " + socket);

                Session session = new Session(socket, sessionManager, commandManager);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log("서버 소켓 종료: " + e);
        }
    }

    public void close() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            log(e);
        }
    }
}
