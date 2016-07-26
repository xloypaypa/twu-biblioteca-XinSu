package twu.biblioteca.model.collection;

import twu.biblioteca.model.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xsu on 16/7/26.
 * it's the collection
 */
public abstract class Collection<T extends Entity> {
    private Map<String, T> dataMap;

    Collection() {
        this.dataMap = new HashMap<>();
    }

    public void insertData(T book) {
        this.dataMap.put(book.getId(), book);
    }

    public void removeData(Map<String, Object> filter) {
        List<T> needRemoveId = findData(filter);
        for (T book : needRemoveId) {
            this.dataMap.remove(book.getId());
        }
    }

    public void updateData(T book) {
        this.dataMap.put(book.getId(), book);
    }

    public List<T> findData(Map<String, Object> filter) {
        List<T> result = new ArrayList<>();
        for (String id : dataMap.keySet()) {
            T now = dataMap.get(id);
            boolean isMatch = checkBookIsMatchFilter(filter, now);
            if (isMatch) {
                result.add(now);
            }
        }
        return result;
    }

    private boolean checkBookIsMatchFilter(Map<String, Object> filter, T now) {
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
        this.dataMap.clear();
    }
}
