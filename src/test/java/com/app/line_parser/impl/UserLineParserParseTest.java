package com.app.line_parser.impl;

import com.app.extension.line_parser.UserLineParserExtension;
import com.app.parser.impl.UserLineParser;
import com.app.user.User;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;

@ExtendWith(UserLineParserExtension.class)
@RequiredArgsConstructor
public class UserLineParserParseTest {

    private final UserLineParser userLineParser;

    @ParameterizedTest
    @DisplayName("When line does not match regex")
    @MethodSource("com.app.data_provider.DataProvider#provideIncorrectUserLines")
    public void test1(String line){

        Assertions.assertThatThrownBy(
                () -> userLineParser.parse(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line does not match regex");
    }

    @ParameterizedTest
    @DisplayName("When line parse to User")
    @MethodSource("com.app.data_provider.DataProvider#provideCorrectUserLines")
    public void test2(String line, Map<Long, User> expected){

        Assertions.assertThat(userLineParser.parse(line))
                .isEqualTo(expected);
    }
}
