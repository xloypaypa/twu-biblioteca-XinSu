package twu.biblioteca.model.entity;

/**
 * Created by xsu on 16/7/25.
 * it's the book entity
 */
public class Book extends CheckoutAbleEntity {

    public static final String BOOK_NAME_FIELD = "bookName";
    public static final String BOOK_AUTHOR_FIELD = "author";
    public static final String BOOK_YEAR_PUBLISHED_FIELD = "year";

    public Book(String id, String bookName, String author, String yearPublished, boolean isCheckout) {
        super(id, isCheckout);
        this.setBookName(bookName);
        this.setAuthor(author);
        this.setYearPublished(yearPublished);
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + "; name: " + this.getBookName() + "; author: " + this.getAuthor() + "; year: " + this.getYearPublished();
    }

    public String getBookName() {
        return (String) this.getData().get(BOOK_NAME_FIELD);
    }

    public void setBookName(String bookName) {
        this.getData().put(BOOK_NAME_FIELD, bookName);
    }

    public String getAuthor() {
        return (String) this.getData().get(BOOK_AUTHOR_FIELD);
    }

    public void setAuthor(String author) {
        this.getData().put(BOOK_AUTHOR_FIELD, author);
    }

    public String getYearPublished() {
        return (String) this.getData().get(BOOK_YEAR_PUBLISHED_FIELD);
    }

    public void setYearPublished(String yearPublished) {
        this.getData().put(BOOK_YEAR_PUBLISHED_FIELD, yearPublished);
    }

}
