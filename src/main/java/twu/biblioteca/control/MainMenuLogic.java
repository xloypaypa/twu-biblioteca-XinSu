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
    public void action(Object param) throws Exception {
        UIThread.getUiThread().addEvent(new UIEvent("Please select one command\r\n" +
                "1.list books; 2.list movies; 3.check out book; 4.check out movie; 5.return book; 6.show user message; 0.exit",
                new UIEventCallBack() {
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
        } else if (value == 2) {
            ControlThread.getControlThread().addEvent(ListMoviesLogic.class);
        } else if (value == 3) {
            ControlThread.getControlThread().addEvent(LoginLogic.class, CheckoutBookLogic.class);
        } else if (value == 4) {
            ControlThread.getControlThread().addEvent(LoginLogic.class, CheckoutMovieLogic.class);
        } else if (value == 5) {
            ControlThread.getControlThread().addEvent(LoginLogic.class, ReturnLogic.class);
        } else if (value == 6) {
            ControlThread.getControlThread().addEvent(LoginLogic.class, ShowUserInfoLogic.class);
        } else if (value == 0) {
            ControlThread.getControlThread().addEvent(ExitLogic.class);
        } else {
            UIThread.getUiThread().addEvent(new UIEvent("Select a valid option!"));
            ControlThread.getControlThread().addEvent(MainMenuLogic.class);
        }
    }
}
