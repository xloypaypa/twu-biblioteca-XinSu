package twu.biblioteca.control;

import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIEventCallBack;
import twu.biblioteca.view.UIThread;

import java.util.Scanner;

/**
 * Created by xsu on 16/7/25.
 * it's the main menu logic
 */
public class MainMenuLogic implements LogicNode {
    @Override
    public void action() throws Exception {
        UIThread.getUiThread().addEvent(new UIEvent("Please input \"1\" to list all books", new UIEventCallBack() {
            @Override
            public void action() {
                Scanner scanner = new Scanner(System.in);
                int value = scanner.nextInt();
                getInputMessage(value);
            }
        }));
    }

    public void getInputMessage(int value) {
        if (value == 1) {
            ControlThread.getControlThread().addEvent(ListBooksLogic.class);
        } else {
            UIThread.getUiThread().addEvent(new UIEvent("Select a valid option!"));
            ControlThread.getControlThread().addEvent(MainMenuLogic.class);
        }
    }
}
