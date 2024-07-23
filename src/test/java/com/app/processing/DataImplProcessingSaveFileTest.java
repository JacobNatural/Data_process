package com.app.processing;

import com.app.data_provider.DataProvider;
import com.app.extension.processing.DataProcessingExtension;
import com.app.extension.txt.StringToTxtSaveExtension;
import com.app.processing.impl.DataProcessingImpl;
import com.app.txt.save.impl.StringToTxtSave;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static com.app.data_provider.DataProvider.*;

@ExtendWith({DataProcessingExtension.class, StringToTxtSaveExtension.class})
@RequiredArgsConstructor
public class DataImplProcessingSaveFileTest {

    private final DataProcessingImpl dataProcessingImpl;
    private final StringToTxtSave stringToTxtSave;

    @Test
    @DisplayName("When the user is null")
    public void test1(){
        Assertions.assertThatThrownBy(
                () -> dataProcessingImpl.saveFile(
                        null, FILENAME1, stringToTxtSave)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User cannot be null");
    }

    @Test
    @DisplayName("When the filename is null")
    public void test2(){
        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.saveFile(
                                USER1,null, stringToTxtSave)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename cannot be null");
    }

    @Test
    @DisplayName("When the save is null")
    public void test3(){
        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.saveFile(
                                USER1,FILENAME1,null )
                        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Save cannot be null");
    }

    @Test
    @DisplayName("When the user not exists")
    public void test4(){
        Assertions.assertThatThrownBy(
                () -> dataProcessingImpl.saveFile(USER3, FILENAME1, stringToTxtSave))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User not exist");
    }

    @Test
    @DisplayName("When the user not exists")
    public void test5(){
        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.saveFile(USER3, FILENAME1, stringToTxtSave))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User not exist");
    }

    @Test
    @DisplayName("When the user is not an administrator")
    public void test6(){
        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.saveFile(USER1, FILENAME1, stringToTxtSave))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This user is not an administrator");
    }

    @Test
    @DisplayName("When the user is not an administrator")
    public void test7(){
        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.saveFile(USER1, FILENAME1, stringToTxtSave))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This user is not an administrator");
    }

    @Test
    @DisplayName("When the file not exists")
    public void test8(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.saveFile(USER2, FILENAME3,stringToTxtSave))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File not exist");
    }


    @Test
    @DisplayName("When the save filename")
    @SneakyThrows
    public void test9(){

        dataProcessingImpl.saveFile(USER2, FILENAME1, stringToTxtSave);



        try(var lines = Files.lines(Path.of(DataProvider.FILENAME1.filename()))){
            Assertions.assertThat(lines.collect(Collectors.joining("\n")))
                    .isEqualTo(DATA_REPOSITORY.getAll().get(FILENAME1));
        }
    }

    @AfterAll
    @SneakyThrows
    public static void cleanData(){
        Files.deleteIfExists(Path.of(DataProvider.FILENAME1.filename()));
    }


}
