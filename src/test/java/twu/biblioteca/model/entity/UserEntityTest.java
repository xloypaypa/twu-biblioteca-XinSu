package twu.biblioteca.model.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by xsu on 16/7/26.
 * it's the testing code for use id
 */
public class UserEntityTest {

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_get_invalidate_id() {
        new UserEntity("aaa-bbb", "password", "name", "email", "phone");
    }

    @Test
    public void check_to_String() {
        assertEquals("name: name-1; email: email-1; phone: phone-1", new UserEntity("aaa-bbbb", "password", "name-1", "email-1", "phone-1").toString());
    }

}