package com.app.parser.impl;

import com.app.parser.LineParser;
import com.app.user.User;
import com.app.user.UserType;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * Parses lines of text to extract {@link User} objects based on a specified regex pattern.
 *
 * <p>This class implements the {@link LineParser} interface and provides functionality to parse lines of text
 * into {@link User} objects. Each line is expected to match a specified regex pattern and contain specific fields
 * separated by semicolons.</p>
 */
@AllArgsConstructor
public class UserLineParser implements LineParser<Long, User> {

    private final String regex;

    /**
     * Parses a line of text to extract a {@link User} object.
     *
     * <p>The line should match the specified regex pattern and contain four fields separated by semicolons:
     * the first field is interpreted as the ID, the second field as the login, the third field as the password,
     * and the fourth field as the user type.</p>
     *
     * @param line the line of text to parse
     * @return a map containing the ID as the key and the {@link User} object as the value
     * @throws IllegalArgumentException if the line does not match the specified regex pattern
     */
    @Override
    public Map<Long, User> parse(String line) {

        if(!line.matches(regex)){
            throw new IllegalArgumentException("Line does not match regex");
        }

        var split = line.split(";");
        var id = Long.parseLong(split[0]);
        var user = new User(id, split[1], split[2], UserType.valueOf(split[3]));
        return Map.of(id, user);
    }
}
