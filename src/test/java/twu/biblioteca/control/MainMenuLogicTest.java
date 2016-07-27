package twu.biblioteca.control;

import javafx.util.Pair;
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
        mainMenuLogic.action(null);

        assertEquals("Please select one command\r\n1.list books; 2.list movies; 3.check out book; 4.check out movie; 5.return book; 0.exit",
                UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_have_input_call_back() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.action(null);

        UIEvent uiEvent = UIThread.getUiThread().getNextUIEvent();

        assertNotNull(uiEvent.getUiEventCallBack());
    }

    @Test
    public void should_add_list_books_event_when_input_1() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(1);

        assertEquals(ListBooksLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
    }

    @Test
    public void should_add_list_movies_event_when_input_2() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(2);

        assertEquals(ListMoviesLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
    }

    @Test
    public void should_add_check_out_books_event_with_check_out_book_param_when_input_3() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(3);

        Pair<Class<? extends LogicNode>, Object> nextEvent = ControlThread.getControlThread().getNextEvent();
        assertEquals(LoginLogic.class, nextEvent.getKey());
        assertEquals(CheckoutBookLogic.class, nextEvent.getValue());
    }

    @Test
    public void should_add_check_out_movies_event_with_check_out_movie_when_input_4() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(4);

        Pair<Class<? extends LogicNode>, Object> nextEvent = ControlThread.getControlThread().getNextEvent();
        assertEquals(LoginLogic.class, nextEvent.getKey());
        assertEquals(CheckoutMovieLogic.class, nextEvent.getValue());
    }

    @Test
    public void should_add_return_books_event_with_return_book_event_when_input_5() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(5);

        Pair<Class<? extends LogicNode>, Object> nextEvent = ControlThread.getControlThread().getNextEvent();
        assertEquals(LoginLogic.class, nextEvent.getKey());
        assertEquals(ReturnLogic.class, nextEvent.getValue());
    }

    @Test
    public void should_exit_event_when_input_0() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(0);

        assertEquals(ExitLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
    }

    @Test
    public void should_show_error_message_and_back_to_main_menu() throws Exception {
        MainMenuLogic mainMenuLogic = new MainMenuLogic();
        mainMenuLogic.getInputMessage(100);

        assertEquals(MainMenuLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
        assertEquals("Select a valid option!", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

}