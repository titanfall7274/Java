package was.httpserver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

// Http, Server, Applet 줄임말 : servlet
public interface HttpServlet {
    void service(HttpRequest request, HttpResponse response) throws IOException;
}
