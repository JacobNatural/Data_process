package com.app.repository;

import java.util.Map;

/**
 * The Repository interface provides a method to access a collection of items.
 * It defines a generic contract for retrieving all items in the repository.
 *
 * @param <T> the type of the keys in the repository
 * @param <U> the type of the values in the repository
 */
public interface Repository<T, U> {

    /**
     * Retrieves all items in the repository as a map.
     *
     * @return a map containing all items in the repository, where the key is of type T and the value is of type U
     */
    Map<T, U> getAll();
}