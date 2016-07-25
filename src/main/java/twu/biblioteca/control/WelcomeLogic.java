package twu.biblioteca.control;

import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

/**
 * Created by xsu on 16/7/25.
 * it's the welcome logic. it's show welcome message
 */
public class WelcomeLogic implements LogicNode {
    @Override
    public void action() throws Exception {
        UIThread.getUiThread().addEvent(new UIEvent("this is welcome message :p"));
        ControlThread.getControlThread().addEvent(ListBooksLogic.class);
    }
}
