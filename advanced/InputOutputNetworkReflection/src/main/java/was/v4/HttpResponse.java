package was.v4;

import java.io.PrintWriter;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HttpResponse {

    private final PrintWriter writer;
    private int statusCode = 200;
    private final StringBuilder bodyBuilder = new StringBuilder();
    private String contentType = "text/html; charset=UTF-8";

    public HttpResponse(PrintWriter writer) {
        this.writer = writer;
    }

    // 상태 코드는 외부에서 변경할 수 있는 값임
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void writeBody(String body) {
        bodyBuilder.append(body);
    }

    public void flush() {
        int length = bodyBuilder.toString().getBytes(UTF_8).length;

        writer.println("HTTP/1.1 " + statusCode + getReasonPhrase(statusCode));
        writer.println("Content-Type: " + contentType);
        writer.println("Content-Length: " + length);

        writer.println();

        writer.println(bodyBuilder);
        writer.flush();
    }

    private String getReasonPhrase(int statusCode) {
        switch (statusCode) {
            case 200:
                return "OK";
            case 404:
                return "Not Found";
            case 500:
                return "Internal Server Error";
            default:
                return "Unknown Status";
        }
    }
}
