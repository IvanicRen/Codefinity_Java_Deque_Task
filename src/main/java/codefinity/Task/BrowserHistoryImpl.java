package codefinity.Task;

import java.util.Deque;

public class BrowserHistoryImpl implements BrowserHistory{
    Deque<String> backDeque;
    Deque<String> forwardDeque;
    String currentURL;

    public BrowserHistoryImpl(Deque<String> backDeque, Deque<String> forwardDeque, String currentURL) {
        this.backDeque = backDeque;
        this.forwardDeque = forwardDeque;
        this.currentURL = currentURL;
    }

    @Override
    public void visitPage(String url) {
        backDeque.push(currentURL);
        currentURL = url;
        forwardDeque.clear();
    }

    @Override
    public void goBack() {
        if (!backDeque.isEmpty()) {
            forwardDeque.push(currentURL);
            currentURL = backDeque.pop();
        } else {
            System.out.println("No previous URL");
        }
    }

    @Override
    public void goForward() {
        if (!forwardDeque.isEmpty()) {
            backDeque.push(currentURL);
            currentURL = forwardDeque.pop();
        } else {
            System.out.println("No previous URL");
        }
    }

    @Override
    public String getCurrentPage() {
        return currentURL;
    }
}
