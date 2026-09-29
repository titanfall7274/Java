package chat2.server.command;

import chat2.server.Session;
import chat2.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class ExitCommand implements Command {

    private final SessionManager sessionManager;

    public ExitCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}
