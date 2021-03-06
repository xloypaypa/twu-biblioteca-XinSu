package twu.biblioteca.control;

import org.junit.Test;
import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.model.entity.CheckoutAbleEntity;
import twu.biblioteca.model.entity.UserEntity;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/25.
 * it's the testing code for check out
 */
public class CheckoutBookLogicTest extends LogicTesing {

    @Test
    public void should_add_check_out_hint_message() throws Exception {
        CheckoutBookLogic checkoutBookLogic = new CheckoutBookLogic();
        checkoutBookLogic.action(null);

        assertEquals("Please input book id.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_back_to_main_menu_after_input() throws Exception {
        CheckoutBookLogic checkoutBookLogic = new CheckoutBookLogic();
        checkoutBookLogic.getInputMessage("1", new UserEntity("000-1111", "p", "n", "e", "ph"));

        assertEquals(MainMenuLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
    }

    @Test
    public void should_mark_book_as_is_checkout_when_select_a_id() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, false));
        }

        CheckoutBookLogic checkoutBookLogic = new CheckoutBookLogic();
        checkoutBookLogic.getInputMessage("1", new UserEntity("000-1111", "p", "n", "e", "ph"));

        Map<String, Object> filter = new HashMap<>();
        filter.put(CheckoutAbleEntity.IS_CHECKOUT_FIELD, true);
        assertEquals(1, bookCollection.findData(filter).size());
        assertEquals("book-1", bookCollection.findData(filter).get(0).getBookName());
    }

    @Test
    public void should_add_success_message_if_success() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, false));
        }

        CheckoutBookLogic checkoutBookLogic = new CheckoutBookLogic();
        checkoutBookLogic.getInputMessage("1", new UserEntity("000-1111", "p", "n", "e", "ph"));

        assertEquals("Thank you! Enjoy the book", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_show_fail_message_if_failed() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, false));
        }

        CheckoutBookLogic checkoutBookLogic = new CheckoutBookLogic();
        checkoutBookLogic.getInputMessage("1000", new UserEntity("000-1111", "p", "n", "e", "ph"));

        assertEquals("That book is not available.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_not_checkout_book_who_is_already_checkout() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, true));
        }

        CheckoutBookLogic checkoutBookLogic = new CheckoutBookLogic();
        checkoutBookLogic.getInputMessage("1", new UserEntity("000-1111", "p", "n", "e", "ph"));

        assertEquals("That book is not available.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

}