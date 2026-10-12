package reflection;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

public class ReflectionController {

    // *Controller: 애플리케이션의 제어 흐름을 제어(control)한다. 요청을 받아 적절한 비즈니스 로직을 호출하고,
    // 그 결과를 뷰에 전달하는 등의 작업을 수행한다.

    // 개발자는 이런 XxxController 기능만 개발하면 된다.
    // 이런 컨트롤러의 메서드를 리플렉션으로 읽고 호출할 것이다.

    // site를 묶어 SiteController 라고 해도 된다.
    // /site1 -> site1()
    public void site1(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>site1</h1>");
    }

    // /site2 -> site2()
    public void site2(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }

    // 검색기능만 SearchController 만 따로 나누어도 된다.
    // /search -> search()
    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameters("q");

        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
