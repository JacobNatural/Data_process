package com.app.parser;

import java.util.Map;

/**
 * The LineParser interface defines a contract for parsing a single line of text into a map.
 *
 * @param <T> the type of keys maintained by the map
 * @param <U> the type of mapped values
 */
public interface LineParser<T, U> {

    /**
     * Parses a given line of text and returns a map of parsed key-value pairs.
     *
     * @param line the line of text to be parsed
     * @return a map containing the parsed key-value pairs
     */
    Map<T, U> parse(String line);
}
