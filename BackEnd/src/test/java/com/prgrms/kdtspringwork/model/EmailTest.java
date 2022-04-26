package com.prgrms.kdtspringwork.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            var email = new Email("accccc");
        });
    }

    @Test
    public void testValidEmail() {
        var email = new Email("accccc@gmail.com");
        assertTrue(email.getAddress().equals("accccc@gmail.com"));
    }

    @Test
    public void testEqEmail() {
        var email = new Email("accccc@gmail.com");
        var email2 = new Email("accccc@gmail.com");
        assertEquals(email,email2);
    }

}