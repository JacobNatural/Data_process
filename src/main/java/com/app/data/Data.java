package com.app.data;

import com.app.model.Filename;
import com.app.txt.save.Save;

/**
 * Interface representing the operations that can be performed on data.
 * Provides methods to modify, save, check existence, and count pattern occurrences in data.
 */
public interface Data {

    /**
     * Modifies the content associated with the given filename.
     *
     * @param filename   the {@link Filename} object representing the filename
     * @param newContent the new content to be associated with the filename
     * @throws IllegalArgumentException if filename or newContent is null or empty
     */
    void modifyValue(Filename filename, String newContent);

    /**
     * Saves the content associated with the given filename using the provided save mechanism.
     *
     * @param filename the {@link Filename} object representing the filename
     * @param save     the {@link Save} instance used to save the content
     * @throws IllegalArgumentException if filename or save is null
     */
    void saveFile(Filename filename, Save<String> save);

    /**
     * Checks if the given filename exists in the data.
     *
     * @param filename the {@link Filename} object representing the filename
     * @return true if the filename exists, false otherwise
     * @throws IllegalArgumentException if filename is null
     */
    boolean containFile(Filename filename);

    /**
     * Counts the occurrences of the specified pattern (regex) in the data.
     *
     * @param regex the regular expression pattern to count occurrences of
     * @return the number of occurrences of the pattern in the data
     * @throws IllegalArgumentException if regex is null or empty
     */
    long countPatternOccurrences(String regex);

    /**
     * Counts the occurrences of the specified pattern (regex) in the content associated with the given filename.
     *
     * @param regex    the regular expression pattern to count occurrences of
     * @param filename the {@link Filename} object representing the filename
     * @return the number of occurrences of the pattern in the content associated with the filename
     * @throws IllegalArgumentException if regex or filename is null or if regex is empty
     */
    long countPatternOccurrences(String regex, Filename filename);
}