package twu.biblioteca.control;

import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

/**
 * Created by xsu on 16/7/27.
 * it's the show user info logic
 */
public class ShowUserInfoLogic implements LogicNode {
    @Override
    public void action(Object param) throws Exception {
        UIThread.getUiThread().addEvent(new UIEvent(param.toString()));
        ControlThread.getControlThread().addEvent(MainMenuLogic.class);
    }
}
