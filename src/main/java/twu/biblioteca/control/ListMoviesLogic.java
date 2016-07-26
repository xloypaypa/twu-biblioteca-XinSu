package twu.biblioteca.control;

import twu.biblioteca.model.collection.MovieCollection;
import twu.biblioteca.model.entity.Movie;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xsu on 16/7/26.
 * it's the logic to list movies
 */
public class ListMoviesLogic implements LogicNode {
    @Override
    public void action() throws Exception {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put(Movie.MOVIE_IS_CHECKOUT_FIELD, false);
        List<Movie> movies = MovieCollection.getMovieCollection().findData(filter);
        String message = "";
        for (Movie movie : movies) {
            message += movie.toString() + "\r\n";
        }
        UIThread.getUiThread().addEvent(new UIEvent(message));
        ControlThread.getControlThread().addEvent(MainMenuLogic.class);
    }
}
