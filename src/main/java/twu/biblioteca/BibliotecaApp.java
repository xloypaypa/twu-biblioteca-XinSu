package twu.biblioteca;

import twu.biblioteca.model.collection.BookCollection;
import twu.biblioteca.model.entity.Book;
import twu.biblioteca.view.UIEvent;
import twu.biblioteca.view.UIThread;

public class BibliotecaApp {

    private static UIThread uiThread;

    public static void main(String[] args) {
        initCollection();
        initMainThread();
        uiThread.addEvent(new UIEvent("this is welcome message :p"));
    }

    private static void initMainThread() {
        uiThread = new UIThread();
        uiThread.start();
    }

    private static void initCollection() {
        BookCollection bookCollection = new BookCollection();
        for (int i = 0; i < 10; i++) {
            bookCollection.insertData(new Book(Integer.toString(i), "book-" + i));
        }
    }
}
