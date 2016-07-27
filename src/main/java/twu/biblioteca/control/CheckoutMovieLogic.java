package twu.biblioteca.control;

import twu.biblioteca.model.collection.MovieCollection;
import twu.biblioteca.model.entity.Entity;
import twu.biblioteca.model.entity.Movie;
import twu.biblioteca.model.entity.UserEntity;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIEventCallBack;
import twu.biblioteca.view.UIThread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by xsu on 16/7/26.
 * it's the logic of checkout movie
 */
public class CheckoutMovieLogic implements LogicNode {
    @Override
    public void action(final Object param) throws Exception {
        UIThread.getUiThread().addEvent(new UIEvent("Please input movie id.", new UIEventCallBack() {
            @Override
            public void action() {
                Scanner scanner = new Scanner(System.in);
                String value = scanner.next();
                getInputMessage(value, param);
            }
        }));
    }

    public void getInputMessage(String value, Object param) {
        Map<String, Object> filter = new HashMap<>();
        filter.put(Entity.ENTITY_ID_FIELD, value);
        filter.put(Movie.IS_CHECKOUT_FIELD, false);
        List<Movie> result = MovieCollection.getMovieCollection().findData(filter);
        for (Movie now : result) {
            now.checkout((UserEntity) param);
            MovieCollection.getMovieCollection().updateData(now);
        }

        if (!result.isEmpty()) {
            UIThread.getUiThread().addEvent(new UIEvent("Thank you! Enjoy the movie"));
        } else {
            UIThread.getUiThread().addEvent(new UIEvent("That movie is not available."));
        }
        ControlThread.getControlThread().addEvent(MainMenuLogic.class);
    }
}
