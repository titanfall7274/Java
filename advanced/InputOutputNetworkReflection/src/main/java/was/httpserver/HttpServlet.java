package was.httpserver;

import java.io.IOException;

// Http, Server, Applet 줄임말 : servlet
public interface HttpServlet {
    void service(HttpRequest request, HttpResponse response) throws IOException;
}
