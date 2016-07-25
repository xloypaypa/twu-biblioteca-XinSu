package twu.biblioteca.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/25.
 * it's the testing code for book entity
 */
public class BookTest {

    @Test
    public void should_get_id_name_author_and_year_published_when_to_string() throws Exception {
        Book book = new Book("i", "n", "a", "1", false);

        assertEquals("i n a 1", book.toString());
    }

}