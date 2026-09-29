package chat2.server;

import java.net.ServerSocket;

import static util.MyLogger.log;

public class ShutDownHook implements Runnable {

    private final ServerSocket serverSocket;
    private final SessionManager sessionManager;

    public ShutDownHook(ServerSocket serverSocket, SessionManager sessionManager) {
        this.serverSocket = serverSocket;
        this.sessionManager = sessionManager;
    }

    @Override
    public void run() {
        log("shutdownHook 실행");

        try {
            sessionManager.closeAll();
            serverSocket.close();

            Thread.sleep(1000); // 자원 정리 대기
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e = " + e);
        }
    }
}
