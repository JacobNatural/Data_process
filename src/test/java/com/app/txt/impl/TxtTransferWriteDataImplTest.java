package com.app.txt.impl;

import com.app.data_provider.DataProvider;
import com.app.extension.txt.TxtTransferExtension;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@ExtendWith(TxtTransferExtension.class)
@RequiredArgsConstructor
public class TxtTransferWriteDataImplTest {
    private final TxtTransfer<String, String> transfer;

    @BeforeEach
    public void setup(TestInfo testInfo){
        var methodName = testInfo.getTestMethod().orElseThrow().getName();
        if(methodName.equals("test5") || methodName.equals("test6")){
            transfer.writeData(DataProvider.FILENAME_SAVE, DataProvider.SIMPLE_TEXT, x -> x);
        }
    }

    @Test
    @DisplayName("When the filename is null")
    public void test1(){

        Assertions.assertThatThrownBy(
                () -> transfer.writeData(null, DataProvider.SIMPLE_TEXT, x -> x))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename cannot be null");
    }

    @Test
    @DisplayName("When the filename is empty")
    public void test2(){

        Assertions.assertThatThrownBy(
                        () -> transfer.writeData("", DataProvider.SIMPLE_TEXT, x -> x))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename cannot be empty");
    }

    @Test
    @DisplayName("When the T is null")
    public void test3(){

        Assertions.assertThatThrownBy(
                        () -> transfer.writeData(DataProvider.FILENAME_SAVE, null, x -> x))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("T cannot be null");
    }

    @Test
    @DisplayName("When the prepare is null")
    public void test4(){

        Assertions.assertThatThrownBy(
                        () -> transfer.writeData(DataProvider.FILENAME_SAVE, DataProvider.SIMPLE_TEXT, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Prepare cannot be null");
    }

    @Test
    @DisplayName("When the created file exists")
    @SneakyThrows
    public void test5(){
        Assertions.assertThat(Files.exists(Path.of(DataProvider.FILENAME_SAVE)))
                .isTrue();
    }

    @Test
    @DisplayName("When the created file contains the correct data")
    @SneakyThrows
    public void test6(){

        try(var lines = Files.lines(Path.of(DataProvider.FILENAME_SAVE))){

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
