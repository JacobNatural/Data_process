package com.app.txt.save.impl;

import com.app.data_provider.DataProvider;
import com.app.extension.txt.StringToTxtSaveExtension;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@ExtendWith(StringToTxtSaveExtension.class)
@RequiredArgsConstructor
public class StringToTxtSaveSaveTest {
    private final StringToTxtSave stringToTxtSave;


    @BeforeEach
    public void setUp(){
        stringToTxtSave.save(DataProvider.FILENAME_SAVE, DataProvider.SIMPLE_TEXT,x -> x );
    }

    @Test
    @DisplayName("When the created file exists")
    public void test1(){
        Assertions.assertThat(
                Files.exists(Path.of(DataProvider.FILENAME_SAVE)))
                .isTrue();
    }

    @Test
    @DisplayName("When the created file contains the correct data")
    @SneakyThrows
    public void test2(){
        try(var lines = Files.lines(Path.of(DataProvider.FILENAME_SAVE))) {
            Assertions.assertThat(lines.collect(Collectors.joining("\n")))
                    .isEqualTo(DataProvider.SIMPLE_TEXT);
        }
    }

    @AfterEach
    @SneakyThrows
    public void cleanData(){
        Files.deleteIfExists(Path.of(DataProvider.FILENAME_SAVE));
    }
}
