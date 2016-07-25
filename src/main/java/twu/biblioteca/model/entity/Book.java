package twu.biblioteca.model.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xsu on 16/7/25.
 * it's the book entity
 */
public class Book {

    public static final String BOOK_ID_FIELD = "id";
    public static final String BOOK_NAME_FIELD = "bookName";
    public static final String BOOK_AUTHOR_FIELD = "author";
    public static final String BOOK_YEAR_PUBLISHED_FIELD = "year";
    public static final String BOOK_IS_CHECKOUT_FIELD = "isCheckout";

    private Map<String, Object> data;

    public Book(String id, String bookName, String author, String yearPublished, boolean isCheckout) {
        this.data = new HashMap<>();
        this.data.put(BOOK_ID_FIELD, id);
        this.setBookName(bookName);
        this.setAuthor(author);
        this.setYearPublished(yearPublished);
        this.setISCheckout(isCheckout);
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getBookName() + " " + this.getAuthor() + " " + this.getYearPublished();
    }

    public Map<String, Object> getData() {
        return data;
    }

    public String getId() {
        return (String) this.data.get(BOOK_ID_FIELD);
    }


    public String getBookName() {
        return (String) this.data.get(BOOK_NAME_FIELD);
    }

    public void setBookName(String bookName) {
        this.data.put(BOOK_NAME_FIELD, bookName);
    }

    public String getAuthor() {
        return (String) this.data.get(BOOK_AUTHOR_FIELD);
    }

    public void setAuthor(String author) {
        this.data.put(BOOK_AUTHOR_FIELD, author);
    }

    public String getYearPublished() {
        return (String) this.data.get(BOOK_YEAR_PUBLISHED_FIELD);
    }

    public void setYearPublished(String yearPublished) {
        this.data.put(BOOK_YEAR_PUBLISHED_FIELD, yearPublished);
    }

    public boolean isCheckout() {
        return (boolean) this.data.get(BOOK_IS_CHECKOUT_FIELD);
    }

    public void setISCheckout(boolean isCheckout) {
        this.data.put(BOOK_IS_CHECKOUT_FIELD, isCheckout);
    }
}
