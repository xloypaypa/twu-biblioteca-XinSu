package twu.biblioteca.model.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xsu on 16/7/26.
 * it's the entity
 */
public abstract class Entity {
    public static final String ENTITY_ID_FIELD = "id";
    private Map<String, Object> data;

    Entity(String id) {
        this.data = new HashMap<>();
        this.getData().put(ENTITY_ID_FIELD, id);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public String getId() {
        return (String) this.getData().get(ENTITY_ID_FIELD);
    }
}
