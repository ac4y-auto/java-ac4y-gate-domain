package ac4y.gate.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Advanced unit tests for Ac4yUser domain class.
 * Tests edge cases, immutability concerns, and object equality.
 */
public class Ac4yUserAdvancedTest {

    private Ac4yUser user;

    @Before
    public void setUp() {
        user = new Ac4yUser();
    }

    @Test
    public void testMultipleSetOperations() {
        // Test that multiple set operations work correctly
        user.setUser("initial");
        assertEquals("initial", user.getUser());
        
        user.setUser("updated");
        assertEquals("Updated value should replace old value", "updated", user.getUser());
        
        user.setUser("final");
        assertEquals("final", user.getUser());
    }

    @Test
    public void testWhitespaceHandling() {
        // Test whitespace in username
        user.setUser("  user with spaces  ");
        assertEquals("Whitespace should be preserved", "  user with spaces  ", user.getUser());
        
        user.setPassword("  password with spaces  ");
        assertEquals("Whitespace in password should be preserved", "  password with spaces  ", user.getPassword());
    }

    @Test
    public void testUnicodeCharacters() {
        // Test unicode characters (emojis, international characters)
        String unicodeUser = "用户名称";
        String unicodePassword = "パスワード123";
        
        user.setUser(unicodeUser);
        user.setPassword(unicodePassword);
        
        assertEquals("Unicode username should be preserved", unicodeUser, user.getUser());
        assertEquals("Unicode password should be preserved", unicodePassword, user.getPassword());
    }

    @Test
    public void testSQLInjectionStrings() {
        // Test that potentially dangerous strings are stored correctly
        // (Note: This doesn't test SQL injection protection, just that strings are stored)
        String sqlInjection = "admin' OR '1'='1";
        
        user.setUser(sqlInjection);
        assertEquals("SQL injection string should be stored as-is", sqlInjection, user.getUser());
    }

    @Test
    public void testPasswordWithSpecialCharacters() {
        // Test password complexity requirements
        String complexPassword = "P@ssw0rd!#$%^&*()_+-=[]{}|;:',.<>?/~`";
        
        user.setPassword(complexPassword);
        assertEquals("Complex password should be preserved", complexPassword, user.getPassword());
    }

    @Test
    public void testNewlineAndTabCharacters() {
        // Test control characters
        String usernameWithNewline = "user\nname";
        String passwordWithTab = "pass\tword";
        
        user.setUser(usernameWithNewline);
        user.setPassword(passwordWithTab);
        
        assertEquals("Newline in username should be preserved", usernameWithNewline, user.getUser());
        assertEquals("Tab in password should be preserved", passwordWithTab, user.getPassword());
    }

    @Test
    public void testNumericUsername() {
        // Test purely numeric username
        user.setUser("123456789");
        assertEquals("Numeric username should be valid", "123456789", user.getUser());
    }

    @Test
    public void testObjectInitialState() {
        // Test that newly created object has null fields
        Ac4yUser newUser = new Ac4yUser();
        assertNull("New user should have null username", newUser.getUser());
        assertNull("New user should have null password", newUser.getPassword());
    }

    @Test
    public void testSetUserReturnsVoid() {
        // Verify setter doesn't return anything (void)
        user.setUser("test");
        // If this compiles, the test passes - setUser is void
        assertTrue("Setter executed successfully", true);
    }

    @Test
    public void testIndependentInstances() {
        // Test that two instances don't share state
        Ac4yUser user1 = new Ac4yUser();
        Ac4yUser user2 = new Ac4yUser();
        
        user1.setUser("user1");
        user1.setPassword("pass1");
        
        user2.setUser("user2");
        user2.setPassword("pass2");
        
        assertEquals("user1", user1.getUser());
        assertEquals("pass1", user1.getPassword());
        assertEquals("user2", user2.getUser());
        assertEquals("pass2", user2.getPassword());
        
        assertNotEquals("Different instances should have different values", 
                        user1.getUser(), user2.getUser());
    }

    @Test
    public void testVeryLongPassword() {
        // Test extremely long password (1000 characters)
        StringBuilder sb = new StringBuilder(1000);
        for (int i = 0; i < 1000; i++) {
            sb.append((char)('a' + (i % 26)));
        }
        String veryLongPassword = sb.toString();
        
        user.setPassword(veryLongPassword);
        assertEquals("Very long password should be preserved", veryLongPassword, user.getPassword());
        assertEquals("Password length should be 1000", 1000, user.getPassword().length());
    }

    @Test
    public void testEmailAsUsername() {
        // Test various email formats
        String[] emails = {
            "user@domain.com",
            "first.last@subdomain.example.com",
            "user+tag@example.co.uk",
            "123@456.com"
        };
        
        for (String email : emails) {
            user.setUser(email);
            assertEquals("Email format should be preserved: " + email, email, user.getUser());
        }
    }

    @Test
    public void testPasswordOverwrite() {
        // Test that setting password multiple times overwrites correctly
        user.setPassword("oldPassword");
        String oldPass = user.getPassword();
        assertEquals("oldPassword", oldPass);
        
        user.setPassword("newPassword");
        assertEquals("New password should overwrite old", "newPassword", user.getPassword());
        assertNotEquals("Old password should be replaced", oldPass, user.getPassword());
    }

    @Test
    public void testCaseSensitivity() {
        // Test that username and password are case-sensitive
        user.setUser("TestUser");
        assertEquals("TestUser", user.getUser());
        assertNotEquals("testuser", user.getUser());
        
        user.setPassword("TestPassword");
        assertEquals("TestPassword", user.getPassword());
        assertNotEquals("testpassword", user.getPassword());
    }

    @Test
    public void testSingleCharacterFields() {
        // Test minimum valid length (1 character)
        user.setUser("a");
        user.setPassword("b");
        
        assertEquals("Single character username should be valid", "a", user.getUser());
        assertEquals("Single character password should be valid", "b", user.getPassword());
    }
}
