package com.tigers.pf4j.exp;

/**
 * {@code LoginException}
 *
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public class LoginException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public LoginException(String message) {
        super(message);
    }
}
