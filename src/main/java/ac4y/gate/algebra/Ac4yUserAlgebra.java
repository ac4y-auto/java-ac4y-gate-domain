package ac4y.gate.algebra;

/**
 * Base algebra class for Ac4y user entity.
 * Provides field definitions and accessor methods for user credentials.
 *
 * This class follows the Algebra pattern where base classes define fields
 * and basic operations, which are then extended by domain classes.
 *
 * @author ac4y
 * @version 1.20190129.1
 */
public class Ac4yUserAlgebra {

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the username.
     *
     * @param user the username to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** The username field */
    private String user;

    /** The password field */
    private String password;

}
