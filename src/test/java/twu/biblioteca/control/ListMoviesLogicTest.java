package twu.biblioteca.control;

import org.junit.Before;
import org.junit.Test;
import twu.biblioteca.model.collection.MovieCollection;
import twu.biblioteca.model.entity.Movie;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by xsu on 16/7/26.
 * it's the testing code for list movie logic
 */
public class ListMoviesLogicTest extends LogicTesing {

    @Before
    public void setUp() throws Exception {
        MovieCollection movieCollection = MovieCollection.getMovieCollection();
        for (int i = 0; i < 10; i++) {
            movieCollection.insertData(new Movie(Integer.toString(i), "movie-" + i, "1999", "director-" + i / 2, 1, false));
        }
    }

    @Test
    public void should_back_to_main_menu() throws Exception {
        ListMoviesLogic listMoviesLogic = new ListMoviesLogic();
        listMoviesLogic.action(null);

        assertEquals(MainMenuLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
    }

    @Test
    public void should_only_list_movies_not_checkout() throws Exception {
        MovieCollection movieCollection = MovieCollection.getMovieCollection();
        movieCollection.removeData(new HashMap<String, Object>());
        for (int i = 0; i < 10; i++) {
            movieCollection.insertData(new Movie(Integer.toString(i), "movie-" + i, "1999", "director-" + i / 2, 1, i % 2 == 0));
        }

        ListMoviesLogic listMoviesLogic = new ListMoviesLogic();
        listMoviesLogic.action(null);

        UIEvent uiEvent = UIThread.getUiThread().getNextUIEvent();

        assertEquals("id: 1; name: movie-1; year: 1999; director: director-0; rate: 1\r\n" +
                "id: 3; name: movie-3; year: 1999; director: director-1; rate: 1\r\n" +
                "id: 5; name: movie-5; year: 1999; director: director-2; rate: 1\r\n" +
                "id: 7; name: movie-7; year: 1999; director: director-3; rate: 1\r\n" +
                "id: 9; name: movie-9; year: 1999; director: director-4; rate: 1\r\n", uiEvent.getMessage());
    }

    @Test
    public void should_show_all_books_in_book_collection_in_one_ui_event() throws Exception {
        ListMoviesLogic listMoviesLogic = new ListMoviesLogic();
        listMoviesLogic.action(null);

        UIEvent uiEvent = UIThread.getUiThread().getNextUIEvent();

        assertEquals("id: 0; name: movie-0; year: 1999; director: director-0; rate: 1\r\n" +
                "id: 1; name: movie-1; year: 1999; director: director-0; rate: 1\r\n" +
                "id: 2; name: movie-2; year: 1999; director: director-1; rate: 1\r\n" +
                "id: 3; name: movie-3; year: 1999; director: director-1; rate: 1\r\n" +
                "id: 4; name: movie-4; year: 1999; director: director-2; rate: 1\r\n" +
                "id: 5; name: movie-5; year: 1999; director: director-2; rate: 1\r\n" +
                "id: 6; name: movie-6; year: 1999; director: director-3; rate: 1\r\n" +
                "id: 7; name: movie-7; year: 1999; director: director-3; rate: 1\r\n" +
                "id: 8; name: movie-8; year: 1999; director: director-4; rate: 1\r\n" +
                "id: 9; name: movie-9; year: 1999; director: director-4; rate: 1\r\n", uiEvent.getMessage());
    }

}