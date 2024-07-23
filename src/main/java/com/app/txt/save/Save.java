package com.app.txt.save;

import java.util.function.Function;

/**
 * Interface for saving data to a text file.
 *
 * @param <T> the type of the data to be saved
 */
public interface Save<T> {

    /**
     * Saves the specified data to a file using the provided filename.
     *
     * @param filename the name of the file to which data will be saved
     * @param t the data to be saved
     * @param prepare a function that transforms the data into a String representation suitable for saving
     */
    void save(String filename, T t, Function<T, String> prepare);
}