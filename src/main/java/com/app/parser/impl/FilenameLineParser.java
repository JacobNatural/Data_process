package com.app.parser.impl;

import com.app.model.Filename;
import com.app.parser.LineParser;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * Parses lines of text to extract {@link Filename} objects based on a specified regular expression pattern.
 *
 * <p>This class implements the {@link LineParser} interface and provides functionality to parse lines of text
 * into {@link Filename} objects. Each line is expected to match a given regex pattern and contain specific
 * fields separated by semicolons.</p>
 */
@AllArgsConstructor
public class FilenameLineParser implements LineParser<Long, Filename> {

    private final String regex;

    /**
     * Parses a line of text to extract a {@link Filename} object.
     *
     * <p>The line is expected to match the specified regular expression pattern. If the line does not match
     * the pattern, an {@link IllegalArgumentException} is thrown.</p>
     *
     * <p>The line should contain two fields separated by a semicolon: the first field is interpreted as the ID,
     * and the second field is interpreted as the filename.</p>
     *
     * @param line the line of text to parse
     * @return a map containing the ID as the key and the {@link Filename} object as the value
     * @throws IllegalArgumentException if the line does not match the regex pattern
     */
    @Override
    public Map<Long, Filename> parse(String line) {

        if (!line.matches(regex)) {
            throw new IllegalArgumentException("Line does not match regex");
        }

        var split = line.split(";");
        var id = Long.parseLong(split[0]);
        var filename = new Filename(id, split[1]);
        return Map.of(id, filename);
    }
}
