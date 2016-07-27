package twu.biblioteca.control;

import org.junit.Test;
import twu.biblioteca.model.entity.UserEntity;
import twu.biblioteca.view.UIThread;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/27.
 * it's the testing code for show user info logic
 */
public class ShowUserInfoLogicTest extends LogicTesing {

    @Test
    public void should_show_user_message_and_back_to_main_menu() throws Exception {
        ShowUserInfoLogic showUserInfoLogic = new ShowUserInfoLogic();
        showUserInfoLogic.action(new UserEntity("aaa-bbbb", "password", "name-1", "email-1", "phone-1"));

        assertEquals("name: name-1; email: email-1; phone: phone-1", UIThread.getUiThread().getNextUIEvent().getMessage());
        assertEquals(MainMenuLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
    }

}