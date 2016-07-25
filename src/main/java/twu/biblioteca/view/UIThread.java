package twu.biblioteca.view;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by xsu on 16/7/25.
 * it's the main ui thread.
 * So all ui change should in this thread.
 */
public class UIThread extends Thread {

    private BlockingQueue<UIEvent> eventBlockingQueue = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                UIEvent uiEvent = eventBlockingQueue.take();
                System.out.println(uiEvent.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addEvent(UIEvent uiEvent) {
        eventBlockingQueue.add(uiEvent);
    }
}
