package twu.biblioteca.control;

import org.junit.Test;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/25.
 * it's the testing code for main menu logic
 */
public class MainMenuLogicTest extends LogicTesing {

    @Test
    public void should_add_main_menu_hint_message() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.action();

        assertEquals("Please select one command\r\n1.list books; 0.exit", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_have_input_call_back() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.action();

        UIEvent uiEvent = UIThread.getUiThread().getNextUIEvent();

        assertNotNull(uiEvent.getUiEventCallBack());
    }

    @Test
    public void should_add_list_books_event_when_input_1() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(1);

        assertEquals(ListBooksLogic.class, ControlThread.getControlThread().getNextEvent());
    }

    @Test
    public void should_exit_event_when_input_0() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(0);

        assertEquals(ExitLogic.class, ControlThread.getControlThread().getNextEvent());
    }

    @Test
    public void should_show_error_message_and_back_to_main_menu() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(2);

        assertEquals(MainMenuLogic.class, ControlThread.getControlThread().getNextEvent());
        assertEquals("Select a valid option!", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

}