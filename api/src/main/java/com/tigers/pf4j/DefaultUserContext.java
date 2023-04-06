package com.tigers.pf4j;

/**
 * {@code DefaultUserContext}
 *
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public class DefaultUserContext implements UserContext {

    private String username ;

    private String password ;

    protected DefaultUserContext(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return
     */
    @Override
    public String getUserName() {
        return username;
    }

    /**
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }
}
