package com.app.processing;

import com.app.processing.impl.DataProcessingImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.app.data_provider.DataProvider.*;


public class DataProcessingUpdateDataImplTest {

    @Test
    @DisplayName("When the user is null")
    public void test1(){
        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(new HashMap<>());

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.updateData(null, DATA_IMPL_1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User cannot be null");
    }

    @Test
    @DisplayName("When the data is null")
    public void test2(){
        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(new HashMap<>());

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.updateData(USER1, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Data cannot be null");
    }

    @Test
    @DisplayName("When update a user who does not exists")
    public void test3(){
        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(Map.of(USER1, DATA_IMPL_1));

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.updateData(USER2, DATA_IMPL_1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User does not exist");
    }

    @Test
    @DisplayName("When updating a user with an empty map")
    public void test4(){
        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(new HashMap<>());

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.updateData(USER2, DATA_IMPL_1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User does not exist");
    }

    @Test
    @DisplayName("When update a user")
    public void test5(){

        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(new HashMap<>(Map.of(USER1, DATA_IMPL_1)));

        Assertions.assertThatNoException().isThrownBy(
                () -> dataProcessingImpl.updateData(USER1, DATA_IMPL_1));
    }


}
