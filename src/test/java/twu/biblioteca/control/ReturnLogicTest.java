package twu.biblioteca.control;

import org.junit.Test;
import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/26.
 * it's the testing code for return book logic
 */
public class ReturnLogicTest extends LogicTesing {

    @Test
    public void should_add_return_book_hint_message() throws Exception {
        ReturnLogic returnLogic = new ReturnLogic();
        returnLogic.action(null);

        assertEquals("Please input book id.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_back_to_main_menu_after_input() throws Exception {
        ReturnLogic returnLogic = new ReturnLogic();
        returnLogic.getInputMessage("1");

        assertEquals(MainMenuLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
    }

    @Test
    public void should_mark_book_as_not_checkout_when_select_a_id() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, true));
        }

        ReturnLogic returnLogic = new ReturnLogic();
        returnLogic.getInputMessage("1");

        Map<String, Object> filter = new HashMap<>();
        filter.put(Book.BOOK_IS_CHECKOUT_FIELD, false);
        assertEquals(1, bookCollection.findData(filter).size());
        assertEquals("book-1", bookCollection.findData(filter).get(0).getBookName());
    }

    @Test
    public void should_add_success_message_if_success() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, true));
        }

        ReturnLogic returnLogic = new ReturnLogic();
        returnLogic.getInputMessage("1");

        assertEquals("Thank you for returning the book.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_show_fail_message_if_failed() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, true));
        }

        ReturnLogic returnLogic = new ReturnLogic();
        returnLogic.getInputMessage("1000");

        assertEquals("That is not a valid book to return.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_not_return_book_who_is_already_return() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, false));
        }

        ReturnLogic returnLogic = new ReturnLogic();
        returnLogic.getInputMessage("1");

        assertEquals("That is not a valid book to return.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

}