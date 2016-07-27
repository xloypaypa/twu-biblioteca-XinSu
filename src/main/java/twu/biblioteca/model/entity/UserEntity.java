package twu.biblioteca.model.entity;

/**
 * Created by xsu on 16/7/26.
 * it's the user entity
 */
public class UserEntity extends Entity {

    public static final String USER_PASSWORD_FIELD = "password";
    public static final String USER_NAME_FIELD = "username";
    public static final String USER_EMAIL_FIELD = "email";
    public static final String USER_PHONE_FIELD = "phone";

    public UserEntity(String id, String password, String name, String email, String phone) {
        super(id);
        if (!validateId(id)) {
            throw new RuntimeException("invalidate id");
        }
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + "; email: " + this.getEmail() + "; phone: " + this.getPhone();
    }

    public String getPassword() {
        return (String) this.getData().get(USER_PASSWORD_FIELD);
    }

    public void setPassword(String password) {
        this.getData().put(USER_PASSWORD_FIELD, password);
    }

    public String getName() {
        return (String) this.getData().get(USER_NAME_FIELD);
    }

    public void setName(String name) {
        this.getData().put(USER_NAME_FIELD, name);
    }

    public String getEmail() {
        return (String) this.getData().get(USER_EMAIL_FIELD);
    }

    public void setEmail(String email) {
        this.getData().put(USER_EMAIL_FIELD, email);
    }

    public String getPhone() {
        return (String) this.getData().get(USER_PHONE_FIELD);
    }

    public void setPhone(String phone) {
        this.getData().put(USER_PHONE_FIELD, phone);
    }

    private boolean validateId(String id) {
        String[] split = id.split("-");
        return split.length == 2 && split[0].length() == 3 && split[1].length() == 4;
    }

}
