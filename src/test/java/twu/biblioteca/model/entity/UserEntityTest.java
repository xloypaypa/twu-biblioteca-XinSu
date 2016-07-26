package twu.biblioteca.model.entity;

import org.junit.Test;

/**
 * Created by xsu on 16/7/26.
 * it's the testing code for use id
 */
public class UserEntityTest {

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_get_invalidate_id() {
        new UserEntity("aaa-bbb", "password");
    }

}