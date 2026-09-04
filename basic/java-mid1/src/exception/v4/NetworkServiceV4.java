package exception.v4;

public class NetworkServiceV4 {

    public void sendMessage(String data) {
        String address = "https://example.com";
        NetworkClientV4 networkClient = new NetworkClientV4(address);
        networkClient.initError(data);

        try{
            networkClient.connect();
            networkClient.send(data);
        } finally {
            networkClient.disconnect();
        }
    }
}
