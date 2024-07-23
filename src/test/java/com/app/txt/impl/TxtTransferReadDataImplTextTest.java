package com.app.txt.impl;

import com.app.data_provider.DataProvider;
import com.app.extension.txt.TxtTransferExtension;
import com.app.extension.line_parser.UserLineParserExtension;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.Map;

@ExtendWith({TxtTransferExtension.class, UserLineParserExtension.class})
@RequiredArgsConstructor
public class TxtTransferReadDataImplTextTest {

    private final TxtTransfer<Long, String> transfer;

    @Test
    @DisplayName("When the filename is null")
    public void test1(){
        Assertions.assertThatThrownBy(
                () -> transfer.readData(null, x -> Map.of(1L, x)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename cannot be null");
    }

    @Test
    @DisplayName("When the filename is empty")
    public void test2(){
        Assertions.assertThatThrownBy(
                        () -> transfer.readData("", x -> Map.of(1L, x)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename cannot be empty");
    }

    @Test
    @DisplayName("When the lineParser is null")
    public void test3(){

        Assertions.assertThatThrownBy(
                        () -> transfer.readData(DataProvider.simpleTransferText(), null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("LineParser cannot be null");
    }

    @Test
    @DisplayName("When path is wrong")
    public void test4(){

        Assertions.assertThatThrownBy(
                        () -> transfer.readData("wrong_path.txt", x -> Map.of(1L, x)))
                .isInstanceOf(IOException.class);
    }

    @Test
    @DisplayName("When the transfer read correctly")
    @SneakyThrows
    public void test5(){

        Assertions.assertThat(
                transfer.readData(
                        DataProvider.simpleTransferText(),
                        x -> Map.of(1L, x)))
                .isEqualTo(Map.of(1L, "simple line"));
    }
}
