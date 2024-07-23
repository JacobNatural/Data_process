package com.app.user;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Represents a user in the system with an ID, login credentials, and user type.
 *
 * <p>This class encapsulates user information including their ID, login, password, and type.
 * It provides a method to check if the user has administrator privileges.</p>
 *
 * <p>Uses Lombok annotations to automatically generate {@code equals()}, {@code hashCode()},
 * and {@code toString()} methods based on the user's ID.</p>
 */
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class User {
    /**
     * The unique identifier of the user.
     */
    private final Long id;

    /**
     * The login name of the user.
     */
    private final String login;

    /**
     * The password of the user.
     */
    private final String password;

    /**
     * The type of the user (e.g., administrator, regular user).
     */
    private final UserType userType;

    /**
     * Checks if the user is an administrator.
     *
     * <p>Determines whether the user has administrator privileges based on their {@link UserType}.
     * The user is considered an administrator if their user type is {@link UserType#ADMINISTRATOR}.</p>
     *
     * @return {@code true} if the user is an administrator, {@code false} otherwise
     */
    public boolean isAdministrator(){
        return this.userType.equals(UserType.ADMINISTRATOR);
    }
}