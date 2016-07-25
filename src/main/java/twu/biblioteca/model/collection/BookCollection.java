package twu.biblioteca.model.collection;

import twu.biblioteca.model.entity.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xsu on 16/7/25.
 * it's the book collection.
 * it's work as a mock db
 */
public class BookCollection {

    private static BookCollection bookCollection = new BookCollection();

    public static BookCollection getBookCollection() {
        return bookCollection;
    }

    private Map<String, Book> bookMap;

    private BookCollection() {
        this.bookMap = new HashMap<>();
    }

    public void insertData(Book book) {
        this.bookMap.put(book.getId(), book);
    }

    public void removeData(Map<String, Object> filter) {
        List<Book> needRemoveId = findData(filter);
        for (Book book : needRemoveId) {
            this.bookMap.remove(book.getId());
        }
    }

    public void updateData(Book book) {
        this.bookMap.put(book.getId(), book);
    }

    public List<Book> findData(Map<String, Object> filter) {
        List<Book> result = new ArrayList<>();
        for (String id : bookMap.keySet()) {
            Book now = bookMap.get(id);
            boolean isMatch = checkBookIsMatchFilter(filter, now);
            if (isMatch) {
                result.add(now);
            }
        }
        return result;
    }

    private boolean checkBookIsMatchFilter(Map<String, Object> filter, Book now) {
        boolean isMatch = true;
        for (String field : filter.keySet()) {
            if (!now.getData().containsKey(field) || !now.getData().get(field).equals(filter.get(field))) {
                isMatch = false;
                break;
            }
        }
        return isMatch;
    }

    public void clear() {
        this.bookMap.clear();
    }
}
