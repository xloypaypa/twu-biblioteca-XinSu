package twu.biblioteca.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/26.
 * it's the testing for movie entity
 */
public class MovieTest {

    @Test
    public void should_get_id_name_year_director_and_rate_when_to_string() throws Exception {
        Movie movie = new Movie("1", "n", "y", "d", 1, false);

        assertEquals("id: 1; name: n; year: y; director: d; rate: 1", movie.toString());
    }

}