package twu.biblioteca.control;

import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.model.entity.Entity;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIEventCallBack;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by xsu on 16/7/25.
 * it's the logic to check out book
 */
public class CheckOutLogic implements LogicNode {
    @Override
    public void action() throws Exception {
        UIThread.getUiThread().addEvent(new UIEvent("Please input book id.", new UIEventCallBack() {
            @Override
            public void action() {
                Scanner scanner = new Scanner(System.in);
                String value = scanner.next();
                getInputMessage(value);
            }
        }));
    }

    public void getInputMessage(String value) {
        Map<String, Object> filter = new HashMap<>();
        filter.put(Entity.ENTITY_ID_FIELD, value);
        filter.put(Book.BOOK_IS_CHECKOUT_FIELD, false);
        List<Book> result = BookCollection.getBookCollection().findData(filter);
        for (Book now : result) {
            now.setISCheckout(true);
            BookCollection.getBookCollection().updateData(now);
        }

        if (!result.isEmpty()) {
            UIThread.getUiThread().addEvent(new UIEvent("Thank you! Enjoy the book"));
        } else {
            UIThread.getUiThread().addEvent(new UIEvent("That book is not available."));
        }
        ControlThread.getControlThread().addEvent(MainMenuLogic.class);
    }
}
