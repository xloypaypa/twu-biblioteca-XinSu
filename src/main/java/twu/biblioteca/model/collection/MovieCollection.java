package twu.biblioteca.model.collection;

import twu.biblioteca.model.entity.Movie;

/**
 * Created by xsu on 16/7/26.
 * it's the movie collection
 */
public class MovieCollection extends Collection<Movie> {

    private static MovieCollection movieCollection = new MovieCollection();

    public static MovieCollection getMovieCollection() {
        return movieCollection;
    }

    private MovieCollection() {
        super();
    }
}
