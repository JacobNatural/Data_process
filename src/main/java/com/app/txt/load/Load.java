package com.app.txt.load;

import java.util.Map;

/**
 * The Load interface defines a contract for loading data from a source file.
 *
 * @param <T> the type of the keys in the data
 * @param <U> the type of the values in the data
 */
public interface Load<T, U> {

    /**
     * Loads data from a specified file and returns it as a map.
     *
     * @param filename the name of the file to load data from
     * @return a map containing the loaded data, where the key is of type T and the value is of type U
     * @throws IllegalArgumentException if the filename is null or empty
     * @throws RuntimeException if an error occurs while reading the file
     */
    Map<T, U> load(String filename);
}