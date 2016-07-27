package twu.biblioteca.model.entity;

/**
 * Created by xsu on 16/7/27.
 * it's the entity can be check out
 */
public abstract class CheckoutAbleEntity extends Entity {
    public static final String IS_CHECKOUT_FIELD = "isCheckout";
    public static final String CHECKOUT_USER_FIELD = "checkUser";

    CheckoutAbleEntity(String id, boolean isCheckout) {
        super(id);
        this.setISCheckout(isCheckout);
    }

    public boolean isCheckout() {
        return (boolean) this.getData().get(IS_CHECKOUT_FIELD);
    }

    public void setISCheckout(boolean isCheckout) {
        this.getData().put(IS_CHECKOUT_FIELD, isCheckout);
    }

    public UserEntity getUserWhoCheckoutThis() {
        return (UserEntity) this.getData().get(CHECKOUT_USER_FIELD);
    }

    private void setCheckoutUser(UserEntity userEntity) {
        this.getData().put(CHECKOUT_USER_FIELD, userEntity);
    }

    public void checkout(UserEntity userEntity) {
        setISCheckout(true);
        setCheckoutUser(userEntity);
    }

    public void returnEntity() {
        setISCheckout(false);
        setCheckoutUser(null);
    }

}
