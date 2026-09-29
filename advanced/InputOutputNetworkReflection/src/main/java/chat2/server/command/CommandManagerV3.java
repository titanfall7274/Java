package chat2.server.command;

import chat2.server.CommandManager;
import chat2.server.Session;
import chat2.server.SessionManager;

import java.io.IOException;

public class CommandManagerV3 implements CommandManager {

    private static final String DELIMETER = "\\|";
    private final SessionManager sessionManager;

    public CommandManagerV3(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMETER);
        String key = args[0];
    }
}
