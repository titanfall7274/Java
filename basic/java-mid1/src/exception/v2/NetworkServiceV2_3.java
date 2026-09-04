package exception.v2;

public class NetworkServiceV2_3 {
    // 예외를 던지지 않고(not throws) 잡아서 처리(throw)한다.
    public void sendMessage(String data) {
        String address = "https://example.com";

        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        // 연결 에러
        try {
            client.connect();
            client.send(data);
            client.disconnect();// 예외 발생시 무시
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getMessage() + ", 메시지: " + e.getMessage());
            return;
        }
    }
}
