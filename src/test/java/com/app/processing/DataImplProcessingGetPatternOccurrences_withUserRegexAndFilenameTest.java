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
public class DataImplProcessingGetPatternOccurrences_withUserRegexAndFilenameTest {
    private final DataProcessingImpl dataProcessingImpl;

    @Test
    @DisplayName("When user is null")
    public void test1(){


        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.getPatternOccurrences(null, "a", FILENAME1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User cannot be null");
    }

    @Test
    @DisplayName("When regex is null")
    public void test2(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.getPatternOccurrences(USER1, null, FILENAME1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Regex cannot be null");
    }

    @Test
    @DisplayName("When filename is null")
    public void test3(){
        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.getPatternOccurrences(USER1, "a", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename cannot be null");
    }

    @Test
    @DisplayName("When regex is empty")
    public void test4(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.getPatternOccurrences(USER1, "", FILENAME1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Regex cannot be empty");
    }

    @Test
    @DisplayName("When the user not exists")
    public void test5(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.getPatternOccurrences(USER3, "a", FILENAME1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User not exist");
    }

    @Test
    @DisplayName("When the file not exists")
    public void test6(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.getPatternOccurrences(USER1, "a", FILENAME3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File not exist");
    }

    @ParameterizedTest
    @DisplayName("When the method found occurrences")
    @CsvSource({"o,4","for,1","[a-z],26"})
    public void test7(String regex, int expectedOccurrences){

        Assertions.assertThat(dataProcessingImpl.getPatternOccurrences(USER1,regex, FILENAME1))
                .isEqualTo(expectedOccurrences);
    }

    @Test
    @DisplayName("When the method not found occurrences")
    public void test8(){

        Assertions.assertThat(dataProcessingImpl.getPatternOccurrences(USER1,"[0-9]",FILENAME1))
                .isEqualTo(0);
    }

}
