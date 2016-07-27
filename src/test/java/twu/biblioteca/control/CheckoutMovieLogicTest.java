package twu.biblioteca.control;

import org.junit.Test;
import twu.biblioteca.model.collection.MovieCollection;
import twu.biblioteca.model.entity.Movie;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by xsu on 16/7/26.
 * it's the testing code for checkout movie
 */
public class CheckoutMovieLogicTest extends LogicTesing {

    @Test
    public void should_add_check_out_hint_message() throws Exception {
        CheckoutMovieLogic checkoutMovieLogic = new CheckoutMovieLogic();
        checkoutMovieLogic.action(null);

        assertEquals("Please input movie id.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_back_to_main_menu_after_input() throws Exception {
        CheckoutMovieLogic checkoutMovieLogic = new CheckoutMovieLogic();
        checkoutMovieLogic.getInputMessage("1");

        assertEquals(MainMenuLogic.class, ControlThread.getControlThread().getNextEvent().getKey());
    }

    @Test
    public void should_mark_movie_as_is_checkout_when_select_a_id() throws Exception {
        MovieCollection movieCollection = MovieCollection.getMovieCollection();
        for (int i = 0; i < 10; i++) {
            movieCollection.insertData(new Movie(Integer.toString(i), "movie-" + i, "1999", "director-" + i / 2, 1, false));
        }

        CheckoutMovieLogic checkoutMovieLogic = new CheckoutMovieLogic();
        checkoutMovieLogic.getInputMessage("1");

        Map<String, Object> filter = new HashMap<>();
        filter.put(Movie.MOVIE_IS_CHECKOUT_FIELD, true);
        assertEquals(1, movieCollection.findData(filter).size());
        assertEquals("movie-1", movieCollection.findData(filter).get(0).getMovieName());
    }

    @Test
    public void should_add_success_message_if_success() throws Exception {
        MovieCollection movieCollection = MovieCollection.getMovieCollection();
        for (int i = 0; i < 10; i++) {
            movieCollection.insertData(new Movie(Integer.toString(i), "movie-" + i, "1999", "director-" + i / 2, 1, false));
        }

        CheckoutMovieLogic checkoutMovieLogic = new CheckoutMovieLogic();
        checkoutMovieLogic.getInputMessage("1");

        assertEquals("Thank you! Enjoy the movie", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_show_fail_message_if_failed() throws Exception {
        MovieCollection movieCollection = MovieCollection.getMovieCollection();
        for (int i = 0; i < 10; i++) {
            movieCollection.insertData(new Movie(Integer.toString(i), "movie-" + i, "1999", "director-" + i / 2, 1, false));
        }

        CheckoutMovieLogic checkoutMovieLogic = new CheckoutMovieLogic();
        checkoutMovieLogic.getInputMessage("1000");

        assertEquals("That movie is not available.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

    @Test
    public void should_not_checkout_book_who_is_already_checkout() throws Exception {
        MovieCollection movieCollection = MovieCollection.getMovieCollection();
        for (int i = 0; i < 10; i++) {
            movieCollection.insertData(new Movie(Integer.toString(i), "movie-" + i, "1999", "director-" + i / 2, 1, true));
        }

        CheckoutMovieLogic checkoutMovieLogic = new CheckoutMovieLogic();
        checkoutMovieLogic.getInputMessage("1");

        assertEquals("That movie is not available.", UIThread.getUiThread().getNextUIEvent().getMessage());
    }

}