package was.v4;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HttpRequest {

    private String method; // GET, POST, etc
    private String path; // / /site1 /site2 /search?q=hello

    private final Map<String, String> queryParameters = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();

    public HttpRequest(BufferedReader reader) throws IOException {
        parseRequestLine(reader);
        parseHeaders(reader);
    }

    // 헤더는 여러 라인일 수 있으니깐
    // ex)
    // Content-type: text/html; charset = utf-8;
    // Content-length: *;
    private void parseHeaders(BufferedReader reader) throws IOException {
        String line;

        while (!(line = reader.readLine()).isEmpty()) {
            String[] headerParts = line.split(":");

            // 헤더는 모두 ASCII 값들이기 때문에 디코드할 필요가 없다.
            headers.put(headerParts[0].trim(), headerParts[1].trim());
        }

    }

    private void parseRequestLine(BufferedReader reader) throws IOException {
        String requestLine = reader.readLine();

        if (requestLine == null) {
            throw new IOException("EOF: No request line received");
        }

        // GET /site1 HTTP/1.1\r\n
        String[] parts = requestLine.split(" ");
        if (parts.length != 3) {
            throw new IOException("Invalid request line: " + requestLine);
        }

        method = parts[0]; // GET
        String[] pathParts = parts[1].split("\\?"); // /search?q=hello 이런 식일수도 있으니깐

        // [/search, q=hello]
        if (pathParts.length > 1) {
            parseQueryParameters(pathParts[1]);
        }

    }

    // pathPart = q=hello 일수도 있는데
    // q1=hello1&q2=hello2 이럴수도 있음
    private void parseQueryParameters(String queryString) {
        for (String param : queryString.split("&")) {
            String[] keyValue = param.split("=");
            String key = URLDecoder.decode(keyValue[0], UTF_8);
            String value = URLDecoder.decode(keyValue[1], UTF_8);

            queryParameters.put(key, value);
        }
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getParameters(String name) {
        return queryParameters.get(name);
    }

    public String getHeaders(String name) {
        return headers.get(name);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", queryParameters=" + queryParameters +
                ", headers=" + headers +
                '}';
    }
}
