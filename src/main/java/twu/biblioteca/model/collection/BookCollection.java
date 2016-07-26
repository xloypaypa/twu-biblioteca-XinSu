package twu.biblioteca.model.collection;

import twu.biblioteca.model.entity.Book;

/**
 * Created by xsu on 16/7/25.
 * it's the book collection.
 * it's work as a mock db
 */
public class BookCollection extends Collection<Book> {

    private static BookCollection bookCollection = new BookCollection();

    public static BookCollection getBookCollection() {
        return bookCollection;
    }

    private BookCollection() {
        super();
    }

}
