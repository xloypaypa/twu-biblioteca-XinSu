package twu.biblioteca;

import com.sun.javafx.binding.StringFormatter;
import twu.biblioteca.control.*;
import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.collection.MovieCollection;
import twu.biblioteca.model.collection.UserCollection;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.model.entity.Movie;
import twu.biblioteca.model.entity.UserEntity;
import twu.biblioteca.view.UIThread;

public class BibliotecaApp {

    public static void main(String[] args) {
        initCollection();

        ControlThread controlThread = ControlThread.getControlThread();
        controlThread.registerLogicNode(new WelcomeLogic());
        controlThread.registerLogicNode(new LoginLogic());
        controlThread.registerLogicNode(new MainMenuLogic());
        controlThread.registerLogicNode(new ListBooksLogic());
        controlThread.registerLogicNode(new ListMoviesLogic());
        controlThread.registerLogicNode(new CheckoutBookLogic());
        controlThread.registerLogicNode(new CheckoutMovieLogic());
        controlThread.registerLogicNode(new ReturnLogic());
        controlThread.registerLogicNode(new ExitLogic());

        controlThread.addEvent(WelcomeLogic.class);

        startThread();
    }

    private static void startThread() {
        ControlThread.getControlThread().start();
        UIThread.getUiThread().start();
    }

    private static void initCollection() {
        BookCollection bookCollection = BookCollection.getBookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i, "author-1", "1999", false));
        }

        MovieCollection movieCollection = MovieCollection.getMovieCollection();
        for (int i = 0; i < 10; i++) {
            movieCollection.insertData(new Movie(Integer.toString(i), "movie-" + i, "1999", "director-" + i / 2, 1, false));
        }

        UserCollection userCollection = UserCollection.getUserCollection();
        for (int i = 0; i < 3; i++) {
            userCollection.insertData(new UserEntity(StringFormatter.format("%d%d%d-%d%d%d%d", i, i, i, i, i, i, i).getValue(), "p" + i));
        }
    }
}
