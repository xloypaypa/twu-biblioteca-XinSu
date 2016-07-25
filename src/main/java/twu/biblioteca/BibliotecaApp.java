package twu.biblioteca;

import twu.biblioteca.control.ControlThread;
import twu.biblioteca.control.ListBooksLogic;
import twu.biblioteca.control.WelcomeLogic;
import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.view.UIThread;

public class BibliotecaApp {

    public static void main(String[] args) {
        initCollection();

        ControlThread controlThread = ControlThread.getControlThread();
        controlThread.registerLogicNode(new WelcomeLogic());
        controlThread.registerLogicNode(new ListBooksLogic());
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
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i));
        }
    }
}
