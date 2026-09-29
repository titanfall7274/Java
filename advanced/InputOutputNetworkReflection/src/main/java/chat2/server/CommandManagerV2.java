package chat2.server;

import java.io.IOException;

public class CommandManagerV2 implements CommandManager{

    private static final String DELIMETER = "\\|";
    private final SessionManager sessionManager;

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if(totalMessage.startsWith("/join")) {
            String[] split = totalMessage.split(DELIMETER);
            String username = split[1];

            session.setUsername(username);
            sessionManager.sendAll(username + "님이 입장했습니다.");
        } else if(totalMessage.startsWith("/message")) {
            String[] split = totalMessage.split(DELIMETER);
            String message = split[1];
            sessionManager.sendAll("[" + session.getUsername() + "]" + message);
        } else if(totalMessage.startsWith("/change")) {
            String[] split = totalMessage.split(DELIMETER);
            String newName = split[1];

            sessionManager.sendAll(session.getUsername() + "님이 " + newName + "으로 이름을 변경했습니다.");
            session.setUsername(newName);
        } else if(totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("처리할 수 없는 명령어 입니다: " + totalMessage);
        }
    }
}
