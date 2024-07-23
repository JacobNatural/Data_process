package com.app.processing;

import com.app.data.impl.DataImpl;
import com.app.model.Filename;
import com.app.txt.save.Save;
import com.app.user.User;

/**
 * Interface representing the operations that can be performed for data processing.
 * Provides methods to add, remove, update users and data, as well as to retrieve pattern occurrences,
 * modify data, and save files.
 */
public interface DataProcessing {

    /**
     * Adds a user with associated data.
     *
     * @param user     the {@link User} object representing the user
     * @param dataImpl the {@link DataImpl} object representing the data associated with the user
     * @throws IllegalArgumentException if user or dataImpl is null, or if the user already exists
     */
    void addUser(User user, DataImpl dataImpl);

    /**
     * Removes the specified user.
     *
     * @param user the {@link User} object representing the user
     * @throws IllegalArgumentException if user is null or does not exist
     */
    void removeUser(User user);

    /**
     * Updates the data associated with the specified user.
     *
     * @param user     the {@link User} object representing the user
     * @param dataImpl the {@link DataImpl} object representing the new data
     * @throws IllegalArgumentException if user or dataImpl is null, or if the user does not exist
     */
    void updateData(User user, DataImpl dataImpl);

    /**
     * Gets the occurrences of a pattern in the data associated with the specified user.
     *
     * @param user  the {@link User} object representing the user
     * @param regex the regular expression pattern to count occurrences of
     * @return the number of occurrences of the pattern
     * @throws IllegalArgumentException if user or regex is null, if regex is empty, or if the user does not exist
     */
    long getPatternOccurrences(User user, String regex);

    /**
     * Gets the occurrences of a pattern in the content associated with the specified filename for the specified user.
     *
     * @param user     the {@link User} object representing the user
     * @param regex    the regular expression pattern to count occurrences of
     * @param filename the {@link Filename} object representing the filename
     * @return the number of occurrences of the pattern in the content associated with the filename
     * @throws IllegalArgumentException if user, regex, or filename is null, if regex is empty, if the user does not exist,
     * or if the file does not exist
     */
    long getPatternOccurrences(User user, String regex, Filename filename);

    /**
     * Modifies the content associated with the specified filename for the specified user.
     *
     * @param user       the {@link User} object representing the user
     * @param fileName   the {@link Filename} object representing the filename
     * @param newContent the new content to be associated with the filename
     * @throws IllegalArgumentException if user, fileName, or newContent is null, if newContent is empty,
     * if the user does not exist, if the file does not exist, or if the user is not an administrator
     */
    void modifyData(User user, Filename fileName, String newContent);

    /**
     * Saves the content associated with the specified filename for the specified user using the provided save mechanism.
     *
     * @param user     the {@link User} object representing the user
     * @param filename the {@link Filename} object representing the filename
     * @param save     the {@link Save} instance used to save the content
     * @throws IllegalArgumentException if user, filename, or save is null, if the user does not exist,
     * if the user is not an administrator, or if the file does not exist
     */
    void saveFile(User user, Filename filename, Save<String> save);
}