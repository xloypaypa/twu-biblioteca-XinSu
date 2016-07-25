package twu.biblioteca.control;

import org.junit.After;
import twu.biblioteca.view.UIThread;

/**
 * Created by xsu on 16/7/25.
 * it's the abstract logic testing.
 * this one is work for clean up thread
 */
public abstract class LogicTesing {

    @After
    public void tearDown() throws Exception {
        while (ControlThread.getControlThread().getNextEvent() != null);
        while (UIThread.getUiThread().getNextUIEvent() != null);
    }
}
