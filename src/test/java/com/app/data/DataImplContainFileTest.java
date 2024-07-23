package com.app.data;

import com.app.data.impl.DataImpl;
import com.app.repository.impl.DataRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Map;

import static com.app.data_provider.DataProvider.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings()
public class DataImplContainFileTest {

    @Mock
    DataRepository dataRepository;

    @InjectMocks
    DataImpl dataImpl;

    @BeforeEach
    void setUp() {
        Mockito.when(dataRepository.getAll())
                .thenReturn(Map.of(
                        FILENAME1,"content for found occurrences"
                ));
    }

    @Test
    @DisplayName("When the data contains a file")
    public void test1(){

        Assertions.assertThat(dataImpl.containFile(FILENAME1))
                .isTrue();

        Mockito.verify(dataRepository, Mockito.times(1)).getAll();
    }

    @Test
    @DisplayName("When the data do not contain a file")
    public void test2(){

        Assertions.assertThat(dataImpl.containFile(FILENAME2))
                .isFalse();

        Mockito.verify(dataRepository, Mockito.times(1)).getAll();
    }
}
