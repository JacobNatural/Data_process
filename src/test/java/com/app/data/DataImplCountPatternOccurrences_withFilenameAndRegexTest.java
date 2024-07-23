package com.app.data;

import com.app.data.impl.DataImpl;
import com.app.repository.impl.DataRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Map;

import static com.app.data_provider.DataProvider.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings()
public class DataImplCountPatternOccurrences_withFilenameAndRegexTest {

    @Mock
    DataRepository dataRepository;

    @InjectMocks
    DataImpl dataImpl;

    @BeforeEach
    void setUp() {
        Mockito.when(dataRepository.getAll())
                .thenReturn(Map.of(
                        FILENAME1,"content for found occurrences",
                        FILENAME2,"another text for searching"
                ));
    }


    @ParameterizedTest
    @DisplayName("When the method found occurrences")
    @CsvSource({"o,4","for,1","[a-z],26"})
    public void test1(String regex, int expectedOccurrences){

        Assertions.assertThat(dataImpl.countPatternOccurrences(regex, FILENAME1))
                .isEqualTo(expectedOccurrences);

        Mockito.verify(dataRepository, Mockito.times(1)).getAll();
    }

    @Test
    @DisplayName("When the method not found occurrences")
    public void test2(){

        Assertions.assertThat(dataImpl.countPatternOccurrences("[0-9]",FILENAME1))
                .isEqualTo(0);

        Mockito.verify(dataRepository, Mockito.times(1)).getAll();

    }

}
