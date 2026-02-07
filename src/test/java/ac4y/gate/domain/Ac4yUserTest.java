package ac4y.gate.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Ac4yUser domain class.
 * Tests the basic functionality of user object creation and field access.
 */
public class Ac4yUserTest {

    @Test
    public void testUserCreation() {
        Ac4yUser user = new Ac4yUser();
        assertNotNull("User object should be created", user);
    }

    @Test
    public void testSetAndGetUser() {
        Ac4yUser user = new Ac4yUser();
        String username = "testuser";

        user.setUser(username);

        assertEquals("Username should match the set value", username, user.getUser());
    }

    @Test
    public void testSetAndGetPassword() {
        Ac4yUser user = new Ac4yUser();
        String password = "testpassword123";

        user.setPassword(password);

        assertEquals("Password should match the set value", password, user.getPassword());
    }

    @Test
    public void testSetMultipleFields() {
        Ac4yUser user = new Ac4yUser();
        String username = "admin";
        String password = "adminpass";

        user.setUser(username);
        user.setPassword(password);

        assertEquals("Username should be preserved", username, user.getUser());
        assertEquals("Password should be preserved", password, user.getPassword());
    }

    @Test
    public void testNullValues() {
        Ac4yUser user = new Ac4yUser();

        user.setUser(null);
        user.setPassword(null);

        assertNull("Username can be null", user.getUser());
        assertNull("Password can be null", user.getPassword());
    }

    @Test
    public void testEmptyValues() {
        Ac4yUser user = new Ac4yUser();

        user.setUser("");
        user.setPassword("");

        assertEquals("Username can be empty", "", user.getUser());
        assertEquals("Password can be empty", "", user.getPassword());
    }

    @Test
    public void testSpecialCharactersInUsername() {
        Ac4yUser user = new Ac4yUser();
        String specialUsername = "user@domain.com";

        user.setUser(specialUsername);

        assertEquals("Username with special characters should be preserved", specialUsername, user.getUser());
    }

    @Test
    public void testLongValues() {
        Ac4yUser user = new Ac4yUser();
        // Use Java 8 compatible string building instead of repeat()
        StringBuilder sb1 = new StringBuilder(255);
        StringBuilder sb2 = new StringBuilder(255);
        for (int i = 0; i < 255; i++) {
            sb1.append('a');
            sb2.append('b');
        }
        String longUsername = sb1.toString();
        String longPassword = sb2.toString();

        user.setUser(longUsername);
        user.setPassword(longPassword);

        assertEquals("Long username should be preserved", longUsername, user.getUser());
        assertEquals("Long password should be preserved", longPassword, user.getPassword());
    }
}
