package twu.biblioteca.model.collection;

import org.junit.Before;
import org.junit.Test;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.model.entity.Entity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/25.
 * it's the testing code for book collection
 */
public class BookCollectionTest {

    private BookCollection bookCollection;

    @Before
    public void setUp() throws Exception {
        this.bookCollection = BookCollection.getBookCollection();
    }

    @Test
    public void should_can_be_find_after_insert_data() throws Exception {
        Book book = new Book("1", "b1", "author-1", "1999", false);

        this.bookCollection.insertData(book);
        Map<String, Object> filter = new HashMap<>();
        filter.put(Book.BOOK_NAME_FIELD, "b1");

        assertEquals(1, this.bookCollection.findData(filter).size());
    }

    @Test
    public void should_not_have_data_after_remove_data() throws Exception {
        Book book = new Book("1", "b1", "author-1", "1999", false);
        this.bookCollection.insertData(book);

        Map<String, Object> filter = new HashMap<>();
        filter.put(Book.BOOK_NAME_FIELD, "b1");
        this.bookCollection.removeData(filter);

        assertEquals(0, this.bookCollection.findData(filter).size());
    }

    @Test
    public void check_update_data() throws Exception {
        Book book = new Book("1", "b1", "author-1", "1999", false);
        this.bookCollection.insertData(book);
        Book after = new Book("1", "b2", "", "", true);
        this.bookCollection.updateData(after);

        Map<String, Object> filter = new HashMap<>();
        filter.put(Entity.ENTITY_ID_FIELD, "1");
        assertEquals("b2", this.bookCollection.findData(filter).get(0).getBookName());
    }

}