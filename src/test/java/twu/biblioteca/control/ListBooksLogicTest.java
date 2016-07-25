package twu.biblioteca.control;

import org.junit.Before;
import org.junit.Test;
import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

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
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-" + i / 2, "1999" + i / 3));
        }
    }

    @Test
    public void should_show_all_books_in_book_collection_in_one_ui_event() throws Exception {
        ListBooksLogic listBooksLogic = new ListBooksLogic();
        listBooksLogic.action();

        UIEvent uiEvent = UIThread.getUiThread().getNextUIEvent();

        assertEquals("0 book-0 author-0 19990\r\n" +
                "1 book-1 author-0 19990\r\n" +
                "2 book-2 author-1 19990\r\n" +
                "3 book-3 author-1 19991\r\n" +
                "4 book-4 author-2 19991\r\n" +
                "5 book-5 author-2 19991\r\n" +
                "6 book-6 author-3 19992\r\n" +
                "7 book-7 author-3 19992\r\n" +
                "8 book-8 author-4 19992\r\n" +
                "9 book-9 author-4 19993\r\n", uiEvent.getMessage());
    }
}