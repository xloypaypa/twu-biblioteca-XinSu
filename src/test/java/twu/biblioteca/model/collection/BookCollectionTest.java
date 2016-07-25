package twu.biblioteca.model.collection;

import org.junit.Before;
import org.junit.Test;
import twu.biblioteca.model.entity.Book;

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
        this.bookCollection = new BookCollection();
    }

    @Test
    public void should_can_be_find_after_insert_data() throws Exception {
        Book book = new Book("1", "b1");

        this.bookCollection.insertData(book);
        Map<String, Object> filter = new HashMap<>();
        filter.put("bookName", "b1");

        assertEquals(1, this.bookCollection.findData(filter).size());
    }

    @Test
    public void should_not_have_data_after_remove_data() throws Exception {
        Book book = new Book("1", "b1");
        this.bookCollection.insertData(book);

        Map<String, Object> filter = new HashMap<>();
        filter.put("bookName", "b1");
        this.bookCollection.removeData(filter);

        assertEquals(0, this.bookCollection.findData(filter).size());
    }

}