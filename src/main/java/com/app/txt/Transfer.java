package com.app.txt;

import com.app.parser.LineParser;

import java.util.Map;
import java.util.function.Function;

/**
 * The Transfer interface defines methods for reading and writing data with a specified format.
 * It provides functionality for handling data in a structured way, including reading from and writing to files.
 *
 * @param <T> the type of the keys in the data
 * @param <U> the type of the values in the data
 */
public interface Transfer<T, U> {

    /**
     * Reads data from a file and parses it into a map.
     *
     * @param filename the name of the file to read data from
     * @param lineParser the parser used to convert lines of data into key-value pairs
     * @return a map containing the parsed data, where the key is of type T and the value is of type U
     */
    Map<T, U> readData(String filename, LineParser<T, U> lineParser);

    /**
     * Writes data to a file after processing it with a given function.
     *
     * @param filename the name of the file to write data to
     * @param t the data to be written
     * @param prepare a function used to process the data before writing
     */
    void writeData(String filename, T t, Function<T, U> prepare);
}