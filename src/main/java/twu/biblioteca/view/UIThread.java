package twu.biblioteca.view;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by xsu on 16/7/25.
 * it's the main ui thread.
 * So all ui change should in this thread.
 */
public class UIThread extends Thread {

    private static UIThread uiThread = new UIThread();

    public static UIThread getUiThread() {
        return uiThread;
    }

    private BlockingQueue<UIEvent> eventBlockingQueue = new LinkedBlockingDeque<>();

    private UIThread() {
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                UIEvent uiEvent = getNextUIEvent();
                if (uiEvent != null) {
                    System.out.println(uiEvent.getMessage());
                    uiEvent.afterShowMessage();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public UIEvent getNextUIEvent() throws InterruptedException {
        return eventBlockingQueue.poll(20L, TimeUnit.MICROSECONDS);
    }

    public void addEvent(UIEvent uiEvent) {
        eventBlockingQueue.add(uiEvent);
    }
}
