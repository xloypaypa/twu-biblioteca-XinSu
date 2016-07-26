package twu.biblioteca.model.entity;

/**
 * Created by xsu on 16/7/26.
 * it's the user entity
 */
public class UserEntity extends Entity {

    public static final String USER_PASSWORD_FIELD = "password";

    public UserEntity(String id, String password) {
        super(id);
        if (!validateId(id)) {
            throw new RuntimeException("invalidate id");
        }
        this.setPassword(password);
    }

    public String getPassword() {
        return (String) this.getData().get(USER_PASSWORD_FIELD);
    }

    public void setPassword(String password) {
        this.getData().put(USER_PASSWORD_FIELD, password);
    }

    private boolean validateId(String id) {
        String[] split = id.split("-");
        return split.length == 2 && split[0].length() == 3 && split[1].length() == 4;
    }

}
