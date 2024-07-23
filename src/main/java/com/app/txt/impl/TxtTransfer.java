package com.app.txt.impl;

import com.app.parser.LineParser;
import com.app.txt.Transfer;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The TxtTransfer class implements the Transfer interface for handling text-based data.
 * It provides methods for reading data from and writing data to text files.
 *
 * @param <T> the type of the keys in the data
 * @param <U> the type of the values in the data
 */
public class TxtTransfer<T, U> implements Transfer<T, U> {

    /**
     * Reads data from a text file and parses it into a map using the provided LineParser.
     *
     * @param filename the name of the file to read data from
     * @param lineParser the parser used to convert lines of data into key-value pairs
     * @return a map containing the parsed data, where the key is of type T and the value is of type U
     * @throws IllegalArgumentException if filename or lineParser is null, or filename is empty
     * @throws RuntimeException if an I/O error occurs while reading the file
     */
    @Override
    @SneakyThrows
    public Map<T, U> readData(String filename, LineParser<T, U> lineParser) {

        if (filename == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }

        if (filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be empty");
        }

        if (lineParser == null) {
            throw new IllegalArgumentException("LineParser cannot be null");
        }

        try (var lines = Files.lines(Paths.get(filename))) {
            return lines
                    .map(lineParser::parse)
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue,
                            (v1, v2) ->
                                    (v1 instanceof String s1 && v2 instanceof String s2) ?
                                            (U) String.join("\n", s1, s2) : v1
                    ));
        }
    }

    /**
     * Writes data to a text file after processing it with a given function.
     *
     * @param filename the name of the file to write data to
     * @param t the data to be written
     * @param prepare a function used to process the data before writing
     * @throws IllegalArgumentException if filename, data (t), or prepare function is null, or filename is empty
     * @throws RuntimeException if an I/O error occurs while writing to the file
     */
    @Override
    @SneakyThrows
    public void writeData(String filename, T t, Function<T, U> prepare) {
        if (filename == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }

        if (filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be empty");
        }

        if (t == null) {
            throw new IllegalArgumentException("T cannot be null");
        }

        if (prepare == null) {
            throw new IllegalArgumentException("Prepare cannot be null");
        }

        try (var fileWriter = new FileWriter(filename); var pw = new PrintWriter(fileWriter)) {
            pw.println(prepare.apply(t));
        }
    }
}