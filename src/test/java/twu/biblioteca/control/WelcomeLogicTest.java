package twu.biblioteca.control;

import org.junit.Test;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

import static org.junit.Assert.assertEquals;

/**
 * Created by xsu on 16/7/25.
 * it's the testing code for welcome logic testing
 */
public class WelcomeLogicTest extends LogicTesing {

    @Test
    public void should_add_welcome_message_to_ui() throws Exception {
        WelcomeLogic welcomeLogic = new WelcomeLogic();
        welcomeLogic.action();

        UIEvent uiEvent = UIThread.getUiThread().getNextUIEvent();
        assertEquals("this is welcome message :p", uiEvent.getMessage());
    }

    @Test
    public void should_add_main_menu_to_control_logic() throws Exception {
        WelcomeLogic welcomeLogic = new WelcomeLogic();
        welcomeLogic.action();

        Class<? extends LogicNode> clazz = ControlThread.getControlThread().getNextEvent();
        assertEquals(MainMenuLogic.class, clazz);
    }
}