package com.app.line_parser.impl;

import com.app.extension.line_parser.ContentLineParserExtension;
import com.app.parser.impl.ContentLineParser;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

@ExtendWith(ContentLineParserExtension.class)
@RequiredArgsConstructor
public class ContentLineParserParseTest {
    private final ContentLineParser parser;

    @Test
    @DisplayName("When parse cotnent to the map")
    public void test1(){

        Assertions.assertThat(
                parser.parse("some line to parse"))
                .isEqualTo(Map.of(1L, "some line to parse"));
    }
}
