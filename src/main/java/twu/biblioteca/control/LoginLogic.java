package twu.biblioteca.control;

import twu.biblioteca.model.collection.UserCollection;
import twu.biblioteca.model.entity.UserEntity;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIEventCallBack;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by xsu on 16/7/26.
 * it's the login logic
 */
public class LoginLogic implements LogicNode {
    @Override
    public void action(String param) throws Exception {
        UIThread.getUiThread().addEvent(new UIEvent("input your username and password", new UIEventCallBack() {
            @Override
            public void action() {
                Scanner scanner = new Scanner(System.in);
                String username = scanner.nextLine();
                String password = scanner.nextLine();
                getInputMessage(username, password);
            }
        }));
    }

    public void getInputMessage(String username, String password) {
        Map<String, Object> filter = new HashMap<>();
        filter.put(UserEntity.ENTITY_ID_FIELD, username);
        filter.put(UserEntity.USER_PASSWORD_FIELD, password);
        List<UserEntity> users = UserCollection.getUserCollection().findData(filter);
        if (!users.isEmpty()) {
            UIThread.getUiThread().addEvent(new UIEvent("login ok"));
            ControlThread.getControlThread().addEvent(MainMenuLogic.class);
        } else {
            UIThread.getUiThread().addEvent(new UIEvent("login fail"));
            ControlThread.getControlThread().addEvent(LoginLogic.class);
        }
    }
}
