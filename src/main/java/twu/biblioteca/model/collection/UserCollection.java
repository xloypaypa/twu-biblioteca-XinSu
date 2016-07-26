package twu.biblioteca.model.collection;

import twu.biblioteca.model.entity.UserEntity;

/**
 * Created by xsu on 16/7/26.
 * it's the user collection
 */
public class UserCollection extends Collection<UserEntity> {

    private static UserCollection userCollection = new UserCollection();

    public static UserCollection getUserCollection() {
        return userCollection;
    }

    private UserCollection() {
        super();
    }
}
