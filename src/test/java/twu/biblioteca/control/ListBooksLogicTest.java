package twu.biblioteca.control;

import org.junit.Before;
import org.junit.Test;
import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/25.
 * it's the testing code for list books.
 */
public class ListBooksLogicTest extends LogicTesing {

    @Before
    public void setUp() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, false));
        }
    }

    @Test
    public void should_back_to_main_menu() throws Exception {
        ListBooksLogic listBooksLogic = new ListBooksLogic();
        listBooksLogic.action();

        assertEquals(MainMenuLogic.class, ControlThread.getControlThread().getNextEvent());
    }

    @Test
    public void should_only_list_books_not_checkout() throws Exception {
        BookCollection bookCollection = BookCollection.getBookCollection();
        bookCollection.removeData(new HashMap<String, Object>());
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3, i % 2 == 0));
        }

        ListBooksLogic listBooksLogic = new ListBooksLogic();
        listBooksLogic.action();

        UIEvent uiEvent = UIThread.getUiThread().getNextUIEvent();

        assertEquals("id: 1; name: book-1; author: author-0; year: 19990\r\n" +
                "id: 3; name: book-3; author: author-1; year: 19991\r\n" +
                "id: 5; name: book-5; author: author-2; year: 19991\r\n" +
                "id: 7; name: book-7; author: author-3; year: 19992\r\n" +
                "id: 9; name: book-9; author: author-4; year: 19993\r\n", uiEvent.getMessage());
    }

    @Test
    public void should_show_all_books_in_book_collection_in_one_ui_event() throws Exception {
        ListBooksLogic listBooksLogic = new ListBooksLogic();
        listBooksLogic.action();

        UIEvent uiEvent = UIThread.getUiThread().getNextUIEvent();

        assertEquals("id: 0; name: book-0; author: author-0; year: 19990\r\n" +
                "id: 1; name: book-1; author: author-0; year: 19990\r\n" +
                "id: 2; name: book-2; author: author-1; year: 19990\r\n" +
                "id: 3; name: book-3; author: author-1; year: 19991\r\n" +
                "id: 4; name: book-4; author: author-2; year: 19991\r\n" +
                "id: 5; name: book-5; author: author-2; year: 19991\r\n" +
                "id: 6; name: book-6; author: author-3; year: 19992\r\n" +
                "id: 7; name: book-7; author: author-3; year: 19992\r\n" +
                "id: 8; name: book-8; author: author-4; year: 19992\r\n" +
                "id: 9; name: book-9; author: author-4; year: 19993\r\n", uiEvent.getMessage());
    }
}