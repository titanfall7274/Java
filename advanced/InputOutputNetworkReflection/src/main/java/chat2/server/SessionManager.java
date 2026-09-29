package chat2.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;

public class SessionManager {

    private final List<Session> sessions;
    public SessionManager() {
        sessions = new ArrayList<>();
    }

    public synchronized void add(Session session) {
        sessions.add(session);
    }

    public synchronized void remove(Session session) {
        sessions.remove(session);
    }

    public synchronized void sendAll(String outputMessage){
        for (Session session : sessions) {
            try {
                session.send(outputMessage);
            } catch (IOException e) {
                log("sessionManager.sendAll(): 메시지 전송중 오류 발생");
            }
        }
    }

    public synchronized void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
    }

    public List<String> getAllUsername() {
        List<String> usernames = new ArrayList<>();

        for (Session session : sessions) {
            usernames.add(session.getUsername());
        }

        return usernames;
    }
}
