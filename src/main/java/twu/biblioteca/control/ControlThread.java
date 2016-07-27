package twu.biblioteca.control;

import javafx.util.Pair;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by xsu on 16/7/25.
 * it's the control thread. all logic should be in this thread.
 * And it's can send ui event to ui thread for update ui.
 */
public class ControlThread extends Thread {

    private static ControlThread controlThread = new ControlThread();

    public static ControlThread getControlThread() {
        return controlThread;
    }

    private Map<Class<? extends LogicNode>, LogicNode> logicNodeMap;
    private BlockingQueue<Pair<Class<? extends LogicNode>, String>> eventBlockingQueue = new LinkedBlockingDeque<>();

    private ControlThread() {
        this.logicNodeMap = new ConcurrentHashMap<>();
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                Pair<Class<? extends LogicNode>, String> nextEvent = getNextEvent();
                if (nextEvent != null) {
                    Class<? extends LogicNode> clazz = nextEvent.getKey();
                    logicNodeMap.get(clazz).action(nextEvent.getValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Pair<Class<? extends LogicNode>, String> getNextEvent() throws InterruptedException {
        return eventBlockingQueue.poll(20L, TimeUnit.MICROSECONDS);
    }

    public void registerLogicNode(LogicNode logicNode) {
        this.logicNodeMap.put(logicNode.getClass(), logicNode);
    }

    public void addEvent(Class<? extends LogicNode> clazz) {
        eventBlockingQueue.add(new Pair<Class<? extends LogicNode>, String>(clazz, null));
    }

}
