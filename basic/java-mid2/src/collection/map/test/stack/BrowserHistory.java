package collection.map.test.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {

    private final Deque<String> pages;

    public BrowserHistory() {
        pages = new ArrayDeque<>();
    }

    public BrowserHistory(Deque<String> pages) {
        this.pages = pages;
    }

    public void visitPage(String page) {
        System.out.println("방문: " + page);
        pages.push(page);
    }


    public String goBack() {
        System.out.println("뒤로 가기: " + pages.peek());
        return pages.pop();
    }
}
