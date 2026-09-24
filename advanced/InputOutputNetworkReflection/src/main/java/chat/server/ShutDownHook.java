package chat.server;

import java.io.IOException;
import java.net.ServerSocket;

public class ShutDownHook implements Runnable {

    private final ServerSocket serverSocket;
    private final SessionManager sessionManager;

    public ShutDownHook(ServerSocket serverSocket, SessionManager sessionManager) {
        this.serverSocket = serverSocket;
        this.sessionManager = sessionManager;
    }

    @Override
    public void run() {
        try {
            serverSocket.close();
            sessionManager.closeAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
