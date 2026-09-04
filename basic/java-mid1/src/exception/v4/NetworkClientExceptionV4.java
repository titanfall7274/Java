package exception.v4;

/**
 * 두개의 에러를포함하게 됩니다.
 * 1. ConnectException
 * 2. SendException
 */
public class NetworkClientExceptionV4 extends RuntimeException {

    public NetworkClientExceptionV4(String message) {
        super(message);
    }
}
