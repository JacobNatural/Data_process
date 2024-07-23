package com.app.processing;

import com.app.extension.processing.DataProcessingExtension;
import com.app.processing.impl.DataProcessingImpl;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static com.app.data_provider.DataProvider.*;
@ExtendWith(DataProcessingExtension.class)
@RequiredArgsConstructor
public class DataImplProcessingGetPatternOccurrences_withUserAndRegexTest {

    private final DataProcessingImpl dataProcessingImpl;

    @Test
    @DisplayName("When user is null")
    public void test1(){


        Assertions.assertThatThrownBy(
                () -> dataProcessingImpl.getPatternOccurrences(null, "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User cannot be null");
    }

    @Test
    @DisplayName("When regex is null")
    public void test2(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.getPatternOccurrences(USER1, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Regex cannot be null");
    }

    @Test
    @DisplayName("When regex is empty")
    public void test3(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.getPatternOccurrences(USER1, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Regex cannot be empty");
    }

    @Test
    @DisplayName("When the user not exists")
    public void test4(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.getPatternOccurrences(USER3, "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User not exist");
    }


    @ParameterizedTest
    @DisplayName("When the method found occurrences")
    @CsvSource({"a,2","for,2","[a-z],49"})
    public void test5(String regex, int expectedOccurrences){

        Assertions.assertThat(dataProcessingImpl.getPatternOccurrences(USER1, regex))
                .isEqualTo(expectedOccurrences);
    }

    @Test
    @DisplayName("When the method not found occurrences")
    public void test6(){

        Assertions.assertThat(dataProcessingImpl.getPatternOccurrences(USER1,"[0-9]"))
                .isEqualTo(0);
    }
}
