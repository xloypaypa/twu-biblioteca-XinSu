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

    private Map<String, String> data;

    public Book(String id, String bookName) {
        this.data = new HashMap<>();
        this.setId(id);
        this.setBookName(bookName);
    }

    public Map<String, String> getData() {
        return data;
    }

    public String getId() {
        return this.data.get(BOOK_ID_FIELD);
    }

    public void setId(String id) {
        this.data.put(BOOK_ID_FIELD, id);
    }

    public String getBookName() {
        return this.data.get(BOOK_NAME_FIELD);
    }

    public void setBookName(String bookName) {
        this.data.put(BOOK_NAME_FIELD, bookName);
    }
}
