package com.app.line_parser.impl;

import com.app.extension.line_parser.FilenameLineParserExtension;
import com.app.model.Filename;
import com.app.parser.impl.FilenameLineParser;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;

@ExtendWith(FilenameLineParserExtension.class)
@RequiredArgsConstructor
public class FilenameLineParserParseTest {
    private final FilenameLineParser filenameLineParser;

    @ParameterizedTest
    @DisplayName("When line does not match regex")
    @MethodSource("com.app.data_provider.DataProvider#provideIncorrectFilenameLines")
    public void test1(String line){

        Assertions.assertThatThrownBy(
                () -> filenameLineParser.parse(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line does not match regex");
    }

    @ParameterizedTest
    @DisplayName("When line parse to filename")
    @MethodSource("com.app.data_provider.DataProvider#provideCorrectFilenameLines")
    public void test2(String line, Map<Long, Filename> expected){
        Assertions.assertThat(filenameLineParser.parse(line))
                .isEqualTo(expected);
    }

}
