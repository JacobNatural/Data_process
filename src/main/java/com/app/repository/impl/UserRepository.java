package com.app.repository.impl;

import com.app.repository.Repository;
import com.app.txt.load.Load;
import com.app.user.User;

import java.util.Map;

/**
 * The UserRepository class implements the Repository interface for managing user data.
 * It loads user data from a file and provides access to the data through a map.
 */
public class UserRepository implements Repository<Long, User> {

    private final Map<Long, User> users;

    /**
     * Constructs a UserRepository with user data loaded from a file.
     *
     * @param load the Load strategy used to load user data
     * @param filename the name of the file containing user data
     * @throws IllegalArgumentException if the load strategy is null
     */
    public UserRepository(Load<Long, User> load, String filename) {
        if (load == null) {
            throw new IllegalArgumentException("Load cannot be null");
        }
        this.users = load.load(filename);
    }

    /**
     * Retrieves all users in the repository.
     *
     * @return a map containing all users, where the key is the user ID (Long) and the value is the User object
     */
    @Override
    public Map<Long, User> getAll() {
        return users;
    }
}