package twu.biblioteca.control;

import javafx.util.Pair;
import org.junit.Test;
import twu.biblioteca.model.collection.UserCollection;
import twu.biblioteca.model.entity.UserEntity;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/26.
 * it's the testing code for login logic
 */
public class LoginLogicTest extends LogicTesing {

    @Test
    public void should_add_login_hint_message() throws Exception {
        LoginLogic loginLogic = new LoginLogic();
        loginLogic.action(null);

        assertEquals("input your username and password",
                UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_have_input_call_back() throws Exception {
        LoginLogic loginLogic = new LoginLogic();
        loginLogic.action(null);

        UIEvent uiEvent = UIThread.getUiThread().getNextUIEvent();

        assertNotNull(uiEvent.getUiEventCallBack());
    }

    @Test
    public void should_show_success_message_and_go_to_main_logic_with_user_entity_when_success() throws Exception {
        UserCollection.getUserCollection().insertData(new UserEntity("000-0000", "p", "n", "e", "ph"));

        LoginLogic loginLogic = new LoginLogic();
        loginLogic.getInputMessage("000-0000", "p", MainMenuLogic.class);

        assertEquals("login ok", UIThread.getUiThread().getNextUIEvent().getMessage());
        Pair<Class<? extends LogicNode>, Object> nextEvent = ControlThread.getControlThread().getNextEvent();
        assertEquals(MainMenuLogic.class, nextEvent.getKey());
        assertEquals("000-0000", ((UserEntity) nextEvent.getValue()).getId());
    }

    @Test
    public void should_show_fail_message_and_go_to_login_logic_when_success() throws Exception {
        UserCollection.getUserCollection().insertData(new UserEntity("000-0000", "p", "n", "e", "ph"));

        LoginLogic loginLogic = new LoginLogic();
        loginLogic.getInputMessage("000-0000", "e", MainMenuLogic.class);

        assertEquals("login fail", UIThread.getUiThread().getNextUIEvent().getMessage());
        assertEquals(LoginLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
    }

}