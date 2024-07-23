package com.app.processing;

import com.app.extension.processing.DataProcessingExtension;
import com.app.processing.impl.DataProcessingImpl;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.app.data_provider.DataProvider.*;

@ExtendWith(DataProcessingExtension.class)
@RequiredArgsConstructor
public class DataProcessingModifyDataImplTest {
    private final DataProcessingImpl dataProcessingImpl;

    @Test
    @DisplayName("When user is null")
    public void test1(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.modifyData(null, FILENAME1, SIMPLE_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User cannot be null");
    }

    @Test
    @DisplayName("When filename is null")
    public void test2(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.modifyData(USER1, null, SIMPLE_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename cannot be null");
    }

    @Test
    @DisplayName("When new content is null")
    public void test3(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.modifyData(USER1, FILENAME1,null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Content cannot be null");
    }

    @Test
    @DisplayName("When new content is empty")
    public void test4(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.modifyData(USER1, FILENAME1,""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Content cannot be empty");
    }

    @Test
    @DisplayName("When the user not exists")
    public void test5(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.modifyData(USER3, FILENAME1,SIMPLE_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User not exist");
    }

    @Test
    @DisplayName("When the file not exists")
    public void test6(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.modifyData(USER1, FILENAME3,SIMPLE_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File not exist");
    }

    @Test
    @DisplayName("When the user is not an administrator")
    public void test7(){

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.modifyData(USER1, FILENAME1,SIMPLE_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("This user is not an administrator");
    }

    @Test
    @DisplayName("When modifying the value and not throwing an exception")
    public void test8(){

        Assertions.assertThatNoException().isThrownBy(
                () -> dataProcessingImpl.modifyData(USER2, FILENAME1,SIMPLE_TEXT)
        );
    }
}
