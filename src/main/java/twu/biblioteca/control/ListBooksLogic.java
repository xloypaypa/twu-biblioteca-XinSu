package twu.biblioteca.control;

import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.model.entity.CheckoutAbleEntity;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xsu on 16/7/25.
 * it's the logic who list books
 */
public class ListBooksLogic implements LogicNode {
    @Override
    public void action(Object param) throws Exception {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put(CheckoutAbleEntity.IS_CHECKOUT_FIELD, false);
        List<Book> books = BookCollection.getBookCollection().findData(filter);
        String message = "";
        for (Book book : books) {
            message += book.toString() + "\r\n";
        }
        UIThread.getUiThread().addEvent(new UIEvent(message));
        ControlThread.getControlThread().addEvent(MainMenuLogic.class);
    }
}
