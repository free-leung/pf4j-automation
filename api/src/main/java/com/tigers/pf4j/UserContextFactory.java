package com.tigers.pf4j;

/**
 * {@code UserContextFactory}
 *
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public class UserContextFactory {


    public static UserContext defaultUserContext (String username, String password)
    {
        return new DefaultUserContext(username, password) ;
    }
}
