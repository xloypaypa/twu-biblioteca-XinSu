package twu.biblioteca.model.entity;

/**
 * Created by xsu on 16/7/26.
 * it's the movie entity
 */
public class Movie extends CheckoutAbleEntity {

    public static final String MOVIE_NAME_FIELD = "movieName";
    public static final String MOVIE_YEAR_PUBLISHED_FIELD = "year";
    public static final String MOVIE_DIRECTOR_FIELD = "director";
    public static final String MOVIE_RATE_FIELD = "rate";

    public static final int MOVIE_UNRATED = -1;

    public Movie(String id, String name, String year, String director, int rate, boolean isCheckout) {
        super(id, isCheckout);
        this.setMovieName(name);
        this.setYear(year);
        this.setDirector(director);
        this.setRate(rate);
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + "; name: " + this.getMovieName() + "; year: " + this.getYear() + "; director: " + this.getDirector() +
                "; rate: " + this.getRate();
    }

    public String getMovieName() {
        return (String) this.getData().get(MOVIE_NAME_FIELD);
    }

    public void setMovieName(String name) {
        this.getData().put(MOVIE_NAME_FIELD, name);
    }

    public String getYear() {
        return (String) this.getData().get(MOVIE_YEAR_PUBLISHED_FIELD);
    }

    public void setYear(String year) {
        this.getData().put(MOVIE_YEAR_PUBLISHED_FIELD, year);
    }

    public String getDirector() {
        return (String) this.getData().get(MOVIE_DIRECTOR_FIELD);
    }

    public void setDirector(String director) {
        this.getData().put(MOVIE_DIRECTOR_FIELD, director);
    }

    public int getRate() {
        return (int) this.getData().get(MOVIE_RATE_FIELD);
    }

    public void setRate(int rate) {
        this.getData().put(MOVIE_RATE_FIELD, rate);
    }

}
