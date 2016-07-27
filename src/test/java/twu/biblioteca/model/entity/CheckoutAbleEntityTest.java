package twu.biblioteca.model.entity;

import org.junit.Test;
import twu.biblioteca.control.LogicTesing;

import static org.junit.Assert.*;

/**
 * Created by xsu on 16/7/27.
 * it's the testing code for entity who can checkout
 */
public class CheckoutAbleEntityTest extends LogicTesing {

    @Test
    public void should_mark_checkout_and_remember_user_entity_when_checkout() throws Exception {
        Book book = new Book("i", "n", "a", "1", false);
        UserEntity userEntity = new UserEntity("000-1111", "p");

        book.checkout(userEntity);

        assertTrue(book.isCheckout());
        assertEquals(userEntity, book.getUserWhoCheckoutThis());
    }

    @Test
    public void should_mark_not_checkout_and_remove_user_entity_when_checkout() throws Exception {
        Book book = new Book("i", "n", "a", "1", false);
        UserEntity userEntity = new UserEntity("000-1111", "p");

        book.checkout(userEntity);
        book.returnEntity();

        assertFalse(book.isCheckout());
        assertNull(book.getUserWhoCheckoutThis());
    }

}