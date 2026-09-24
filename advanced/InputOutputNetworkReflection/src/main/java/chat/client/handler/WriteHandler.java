package chat.client.handler;

import chat.client.Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static util.MyLogger.log;

public class WriteHandler implements Runnable {
    private final String DELIMETER = ",";

    private final DataOutputStream output;
    private final Client client;

    public boolean closed = false; // 기본값 false

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            String username = inputUsername(scanner);
            output.writeUTF("/join" + DELIMETER + username);

            while (true) {
                String toSend = scanner.nextLine();
                if (toSend.isBlank()) continue;

                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }

                // "/"로 시작하면 명령어, 나머지는 일반 메시지
                if(toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                } else {
                    // "hello" > "/message,hello
                    output.writeUTF("/message" + DELIMETER + toSend);
                }
            }
        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private static String inputUsername(Scanner scanner) {
        System.out.println("이름을 입력하세요.");
        String username;
        do {
            username = scanner.nextLine();
        } while (username.isEmpty());
        return username;
    }

    public synchronized void close() {
        if(closed) {
           return;
        }

        try {
            System.in.close(); // >> scanner > NoSuchElementException > log(e) 종료
        } catch (IOException e) {
            log(e);
        }
        closed = true;
        log("writeHandler 종료");
    }
}
