package twu.biblioteca.control;

import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.entity.Book;
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
    public void action() throws Exception {
        List<Book> books = BookCollection.getBookCollection().findData(new HashMap<String, Object>());
        String message = "";
        for (Book book : books) {
            message += book.getId() + " " + book.getBookName() + "\r\n";
        }
        UIThread.getUiThread().addEvent(new UIEvent(message));
    }
}
