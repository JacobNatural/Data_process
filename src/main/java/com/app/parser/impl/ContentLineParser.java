package com.app.parser.impl;

import com.app.parser.LineParser;
import lombok.AllArgsConstructor;

import java.util.Map;

   /**
   * The ContentLineParser class provides an implementation of the LineParser interface
   * that parses a line of text into a map with a single entry.
   *
   * The key is a fixed long value (1L), and the value is the original line of text.
   */
@AllArgsConstructor
public class ContentLineParser implements LineParser<Long, String> {

    /**
     * Parses a given line of text and returns a map containing a single entry.
     * The key is a fixed long value (1L), and the value is the original line of text.
     *
     * @param line the line of text to be parsed
     * @return a map containing the parsed key-value pair with key 1L and the original line as the value
     */
    @Override
    public Map<Long, String> parse(String line) {
        return Map.of(1L, line);
    }
}
